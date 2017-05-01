package pl.edu.polisadwa.polisa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import pl.edu.polisadwa.ConnectionFactory;

/**
 * Klasa DAO odpowiedzialana za operacje bazodanowe na polisie
 * 
 * @author michalh
 *
 */
public class PolisaDAO {

	private Log log = LogFactory.getLog(PolisaDAO.class);

	/**
	 * Metoda odpowiedzialna za dodanie polisy do bazy danych
	 * 
	 * @param polisa
	 * @throws SQLException
	 */
	public void insert(PolisaDTO polisa) throws SQLException {
		Connection conn = ConnectionFactory.instance().getConnection();
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO POLISA(symbol, data_od, data_do, skladka)" + "values(?,?,?,?)");
		ps.setString(1, polisa.getSymbol());
		ps.setDate(2, polisa.getDataOd());
		ps.setDate(3, polisa.getDataDo());
		ps.setBigDecimal(4, polisa.getSkladka());
		int row = ps.executeUpdate();
		log.info("Dodano: " + row + " do tabeli POLISA");
	}

	/**
	 * Odczytanie danych polisy z result seta
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private PolisaDTO readPolicy(ResultSet rs) throws SQLException {
		PolisaDTO polisa = new PolisaDTO();
		polisa.setId(rs.getInt("id"));
		polisa.setSymbol(rs.getString("symbol"));
		polisa.setDataOd(rs.getDate("data_od"));
		polisa.setDataDo(rs.getDate("data_do"));
		polisa.setSkladka(rs.getBigDecimal("skladka"));
		return polisa;
	}

	/**
	 * Wyszukiwanie polis po symbolu polisy
	 * 
	 * @param symbol
	 *            polisy która jest szukana
	 * @return lista znalezionych polis
	 * @throws SQLException
	 */
	public List<PolisaDTO> selectForSymbol(String symbol) throws SQLException {
		List<PolisaDTO> result = Lists.newArrayList();
		if (Strings.isNullOrEmpty(symbol)) {
			return result;
		}
		Connection conn = ConnectionFactory.instance().getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM POLISA WHERE symbol = ?");
		ps.setString(1, symbol);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			result.add(readPolicy(rs));
		}
		return result;
	}

	/**
	 * Wyszukiwanie polisy po dacie która powinna się mieścić w okresie ochrony
	 * 
	 * @param date
	 *            data
	 * @return
	 * @throws SQLException
	 */
	public List<PolisaDTO> selectForDate(Date date) throws SQLException {
		List<PolisaDTO> result = Lists.newArrayList();
		if (Objects.isNull(date)) {
			return result;
		}
		Connection conn = ConnectionFactory.instance().getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM POLISA WHERE DATA_OD <= ? and DATA_DO >= ?");
		ps.setDate(1, date);
		ps.setDate(2, date);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			result.add(readPolicy(rs));
		}
		return result;
	}

}
