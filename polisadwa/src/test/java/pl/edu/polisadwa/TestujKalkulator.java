package pl.edu.polisadwa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Assert;

public class TestujKalkulator {

	@BeforeClass
	public static void przedTestami() {
	}

	@AfterClass
	public static void poTestach() {
	}

	@Before
	public void przed() {
	}

	@After
	public void po() {
	}

	@Test
	public void test() {
		String symbolPolisy = SymbolPolisyGenerator.generuj("110");
		Assert.assertNotNull("Generator nie wygenerował numeru polisy", symbolPolisy);
	}
}
