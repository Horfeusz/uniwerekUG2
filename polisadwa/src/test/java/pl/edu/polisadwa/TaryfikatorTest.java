package pl.edu.polisadwa;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Lists;

import pl.edu.polisadwa.polisa.PolisaDTO;
import pl.edu.polisadwa.ryzyko.RyzykoDTO;

public class TaryfikatorTest {

	PolisaDTO polisa;
	
	List<RyzykoDTO> ryzyka = Lists.newArrayList();

	static Taryfikator taryfikator;

	@BeforeClass
	public static void przedTestami() {
		taryfikator = new Taryfikator();
	}

	@Before
	public void przed() {
		polisa = new PolisaDTO();
		
		RyzykoDTO ryz1 = new RyzykoDTO();
		ryz1.setSkladka(BigDecimal.TEN);
		ryzyka.add(ryz1);

		RyzykoDTO ryz2 = new RyzykoDTO();
		ryz2.setSkladka(BigDecimal.TEN);
		ryzyka.add(ryz2);		
	}

	@Test
	public void sumaSkladekTest() {
		polisa.setRyzyka(ryzyka);
		
		taryfikator.sumaSkladek(polisa);

		Assert.assertEquals(polisa.getSkladka().doubleValue(), BigDecimal.valueOf(20d).doubleValue(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void polisaNullTest() {
		taryfikator.sumaSkladek(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void polisaBezRyzyk() {
		taryfikator.sumaSkladek(polisa);
	}
	
	@Test
	public void zwyzkaTest() {
		polisa.setRyzyka(ryzyka);
		
		taryfikator.zwyzka(polisa, 10);
		
		Assert.assertEquals(polisa.getSkladka().doubleValue(), BigDecimal.valueOf(22d).doubleValue(), 0);
		
	}
	
}
