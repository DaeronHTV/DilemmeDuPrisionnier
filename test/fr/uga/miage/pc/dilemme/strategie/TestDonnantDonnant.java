package fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.IStrategie;

class TestDonnantDonnant {

	@Test
	void testPlay() {
		DonnantDonnant dd = new DonnantDonnant();
		assertEquals(1, dd.getNumTour());
		dd.play();
		String result = dd.getPlay();
		assertEquals("c", result);
		assertEquals(2, dd.getNumTour());
		dd.setOppPlay("t");
		dd.play();
		result = dd.getPlay();
		assertEquals("t", result);
		assertEquals(3, dd.getNumTour());
		dd.setOppPlay("bonjour");
		dd.play();
		result = dd.getPlay();
		assertEquals("bonjour", result);
	}
	
	@Test
	void testClone() {
		DonnantDonnant dd = new DonnantDonnant();
		IStrategie test = (IStrategie)dd.clone();
		assertTrue(test.equals(dd));
	}

}
