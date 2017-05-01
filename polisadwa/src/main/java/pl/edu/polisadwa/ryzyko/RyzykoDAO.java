package pl.edu.polisadwa.ryzyko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.edu.polisadwa.ConnectionFactory;

public class RyzykoDAO {

	private Log log = LogFactory.getLog(RyzykoDAO.class);
	
	public void insert(RyzykoDTO ryzyko) throws SQLException {
		Connection conn = ConnectionFactory.instance().getConnection();
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO RYZYKO(pol_id, ubezpieczenie, skladka) values(?,?,?)");
		ps.setInt(1, ryzyko.getPolId());
		ps.setString(2, ryzyko.getUbezpieczenie());
		ps.setBigDecimal(3, ryzyko.getSkladka());
		int row = ps.executeUpdate();
		log.info("Dodano: " + row + " wiersz do tabeli RYZYKO");
	}

}
