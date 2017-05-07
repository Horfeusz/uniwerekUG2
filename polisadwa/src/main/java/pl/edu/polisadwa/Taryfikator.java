package pl.edu.polisadwa;

import java.math.BigDecimal;

import com.google.common.base.Preconditions;

import pl.edu.polisadwa.polisa.PolisaDTO;
import pl.edu.polisadwa.ryzyko.RyzykoDTO;

public class Taryfikator {

	public void sumaSkladek(PolisaDTO polisa) {
		Preconditions.checkArgument(polisa != null, "Nie podano danych polisy");
		BigDecimal skladka = BigDecimal.ZERO;
		for (RyzykoDTO ryzyko : polisa.getRyzyka()) {
			skladka = skladka.add(ryzyko.getSkladka());
		}
		polisa.setSkladka(skladka);
	}

}
