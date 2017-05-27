package pl.edu.money;

public class Test1 {

	public static void main(String[] args) {

		// Typy proste a dzielenie
		System.out.println(1.03d - 0.42d);

		// Kolejność wykonywania działań
		double[] numbers = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9 };
		for (double nb : numbers) {
			System.out.format("1 + nb - nb = nb - nb + 1 dla %s to %s: (%s, %s)\n", nb, 1 + nb - nb == nb - nb + 1,
					1 + nb - nb, nb - nb + 1);
		}

	}

}
