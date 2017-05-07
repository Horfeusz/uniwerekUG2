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

	static Taryfikator taryfikator;

	@BeforeClass
	public static void przedTestami() {
		taryfikator = new Taryfikator();
	}

	@Before
	public void przed() {
		polisa = new PolisaDTO();
	}

	@Test
	public void sumaSkladekTest() {
		List<RyzykoDTO> ryzyka = Lists.newArrayList();

		RyzykoDTO ryz1 = new RyzykoDTO();
		ryz1.setSkladka(BigDecimal.TEN);
		ryzyka.add(ryz1);

		RyzykoDTO ryz2 = new RyzykoDTO();
		ryz2.setSkladka(BigDecimal.ONE);
		ryzyka.add(ryz2);

		polisa.setRyzyka(ryzyka);

		taryfikator.sumaSkladek(polisa);

		Assert.assertEquals(polisa.getSkladka().doubleValue(), BigDecimal.valueOf(11d).doubleValue(), 0);

	}

}
