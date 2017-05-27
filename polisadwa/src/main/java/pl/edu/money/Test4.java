package pl.edu.money;

import java.math.BigDecimal;
import java.util.Locale;
import org.joda.money.Money;

import org.joda.money.CurrencyUnit;

public class Test4 {

	public static void main(String[] args) {
		Money money = Money.of(CurrencyUnit.getInstance(Locale.getDefault()), BigDecimal.ONE);

		Money kwota = Money.of(CurrencyUnit.getInstance(Locale.getDefault()), BigDecimal.valueOf(34.64d));
		
		
		System.out.println(money);
		System.out.println(kwota);
		System.out.println(money.minus(kwota));
		
	}

}
