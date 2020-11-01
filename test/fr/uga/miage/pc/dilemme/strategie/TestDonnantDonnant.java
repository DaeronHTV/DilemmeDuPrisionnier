package fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDonnantDonnant {

	@Test
	void testPlay() {
		DonnantDonnant dd = new DonnantDonnant();
		assertEquals(1, dd.getNumTour());
		String result = dd.play();
		assertEquals("c", result);
		assertEquals(2, dd.getNumTour());
		dd.setPlay("t");
		result = dd.play();
		assertEquals("t", result);
		assertEquals(3, dd.getNumTour());
		dd.setPlay("bonjour");
		result = dd.play();
		assertEquals("bonjour", result);
	}

}
