package pl.edu.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

import com.google.common.base.Preconditions;

public class Money {

	private BigDecimal value;

	private Currency currency;

	private static final DecimalFormat DF = new DecimalFormat("#.00");

	public Money() {
		this.value = BigDecimal.ZERO;
		this.currency = Currency.getInstance(Locale.getDefault());
	}

	public Money(BigDecimal value) {
		Preconditions.checkArgument(value != null, "Wartość nie może być równa null");
		this.value = value.setScale(2, RoundingMode.HALF_UP);
		this.currency = Currency.getInstance(Locale.getDefault());
	}

	public Money(double value) {
		this.value = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
		this.currency = Currency.getInstance(Locale.getDefault());
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append(DF.format(this.value)).append(" ").append(this.currency).toString();
	}

}
