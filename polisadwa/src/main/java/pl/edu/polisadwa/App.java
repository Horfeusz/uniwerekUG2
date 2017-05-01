package pl.edu.polisadwa;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.edu.polisadwa.polisa.PolisaDAO;
import pl.edu.polisadwa.polisa.PolisaDTO;

/**
 * Hello world!
 *
 */
public class App {

	Log log = LogFactory.getLog(getClass());

	public String generateSymbol() {
		Date date = new Date();
		return "105" + String.valueOf(date.getTime()).substring(4);
	}

	public void dodaniePolisy(String symbol) throws SQLException {
		PolisaDTO polisa = new PolisaDTO();
		polisa.setSymbol(symbol);
		polisa.setDataOd(java.sql.Date.valueOf("2017-01-01"));
		polisa.setDataDo(java.sql.Date.valueOf("2017-12-31"));
		polisa.setSkladka(BigDecimal.valueOf(567.67));

		PolisaDAO polisaDao = new PolisaDAO();
		polisaDao.insert(polisa);
	}

	public void szukajPolise(String symbol) throws SQLException {
		PolisaDAO polisaDao = new PolisaDAO();
		List<PolisaDTO> polisy = polisaDao.selectForSymbol(symbol);
		for (PolisaDTO polisa : polisy) {
			log.info(polisa);
		}
	}

	public void szukajPolise(LocalDate insuranceDate) throws SQLException {
		PolisaDAO polisaDao = new PolisaDAO();
		java.sql.Date sqldate = java.sql.Date.valueOf(insuranceDate);
		List<PolisaDTO> polisy = polisaDao.selectForDate(sqldate);
		for (PolisaDTO polisa : polisy) {
			log.info(polisa);
		}

	}

	public static void main(String[] args) throws SQLException {
		App app = new App();
		String symbol = app.generateSymbol();
		app.dodaniePolisy(symbol);
		app.szukajPolise(symbol);
		app.szukajPolise(LocalDate.now());

	}
}
