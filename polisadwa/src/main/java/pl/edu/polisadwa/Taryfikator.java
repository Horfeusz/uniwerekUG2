package pl.edu.polisadwa;

import java.math.BigDecimal;

import com.google.common.base.Preconditions;

import pl.edu.polisadwa.polisa.PolisaDTO;
import pl.edu.polisadwa.ryzyko.RyzykoDTO;

public class Taryfikator {

	private void checkPolisa(PolisaDTO polisa) {
		Preconditions.checkArgument(polisa != null, "Nie podano danych polisy");
		Preconditions.checkArgument(polisa.getRyzyka() != null, "Na polisie nie ma zainicjowanych ryzyk");
	}

	public void sumaSkladek(PolisaDTO polisa) {
		checkPolisa(polisa);
		BigDecimal skladka = BigDecimal.ZERO;
		for (RyzykoDTO ryzyko : polisa.getRyzyka()) {
			skladka = skladka.add(ryzyko.getSkladka());
		}
		polisa.setSkladka(skladka);
	}

	public void zwyzka(PolisaDTO polisa, int procentZwyzki) {
		checkPolisa(polisa);
		if (procentZwyzki == 0) {
			return;
		}
		Preconditions.checkArgument(procentZwyzki > 0, "Wartość zwyżki musi być większa od zera");
		double mnoznikTmp = procentZwyzki / 100d;
		BigDecimal mnoznik = BigDecimal.valueOf(mnoznikTmp);
		mnoznik = mnoznik.add(BigDecimal.ONE);
		for (RyzykoDTO ryzyko : polisa.getRyzyka()) {
			BigDecimal skladka = ryzyko.getSkladka().multiply(mnoznik);
			ryzyko.setSkladka(skladka);
		}
		sumaSkladek(polisa);
	}

}
