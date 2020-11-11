package test.fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.IStrategie;
import fr.uga.miage.pc.dilemme.strategie.DonnantDonnantDur;

class TestDonnantDonnantDur {

	@Test
	void testPlay() {
		DonnantDonnantDur ddd = new DonnantDonnantDur();
		assertEquals(1, ddd.getNumTour());
		ddd.play();
		String result = ddd.getPlay();
		assertEquals("c", result);
		assertEquals(2, ddd.getNumTour());
		ddd.setOppPlay("t");
		ddd.play();
		result = ddd.getPlay();
		assertEquals(3, ddd.getNumTour());
		assertEquals("t", result);
		ddd.setOppPlay("c");
		ddd.setOppPlay("n");
		ddd.play();
		result = ddd.getPlay();
		assertEquals("c", result);
	}
	
	@Test
	void testClone() {
		DonnantDonnantDur dd = new DonnantDonnantDur();
		IStrategie test = (IStrategie)dd.clone();
		assertTrue(test.getNom().equals(dd.getNom()));
		assertTrue(test.getDescription().equals(dd.getDescription()));
	}

}
