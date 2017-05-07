package pl.edu.polisadwa;

import java.util.Date;

import com.google.common.base.Preconditions;

public class SymbolPolisyGenerator {

	public static String generuj(String wyroznik) {
		Preconditions.checkNotNull(wyroznik, "Nie podano wyróżnika dla numeru polisy");
		if(wyroznik.equals("100")) {
			wyroznik = "199";
		}
		Date date = new Date();
		return wyroznik + String.valueOf(date.getTime()).substring(4);
	}

}
