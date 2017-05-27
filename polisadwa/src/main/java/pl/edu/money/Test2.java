package pl.edu.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test2 {

	public static void main(String[] argc) {

		BigDecimal bd = new BigDecimal("156.455");
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		System.out.println(bd);

		BigDecimal bd2 = new BigDecimal("156.455");
		bd2 = bd2.setScale(2, RoundingMode.DOWN);
		System.out.println(bd2);

		BigDecimal bd3 = new BigDecimal("156.455");
		bd3 = bd3.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println(bd3);

		BigDecimal bd4 = new BigDecimal("156.455");
		bd4 = bd4.setScale(2, RoundingMode.CEILING);
		System.out.println(bd4);

		BigDecimal bd5 = new BigDecimal("156.455");
		bd5 = bd5.setScale(2, RoundingMode.FLOOR);
		System.out.println(bd5);

		BigDecimal bd6 = new BigDecimal("156.455");
		bd6 = bd6.setScale(2, RoundingMode.UP);
		System.out.println(bd6);

		BigDecimal r1 = bd.add(bd2);
		System.out.println(r1);
		
		BigDecimal r2 = bd3.subtract(bd4);
		System.out.println(r2);
		
		BigDecimal r3 = bd4.multiply(bd);
		System.out.println(r3);
		
		BigDecimal r4 = bd.divide(bd2);
		System.out.println(r4);
		
		
		
		
	}
	
	

}
