package fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDonnantDonnantDur {

	@Test
	void testPlay() {
		DonnantDonnantDur ddd = new DonnantDonnantDur();
		assertEquals(1, ddd.getNumTour());
		String result = ddd.play();
		assertEquals("c", result);
		assertEquals(2, ddd.getNumTour());
		ddd.setPlay("t");
		result = ddd.play();
		assertEquals(3, ddd.getNumTour());
		assertEquals("t", result);
		ddd.setPlay("c");
		ddd.setPlay("n");
		result = ddd.play();
		assertEquals("c", result);
	}

}
