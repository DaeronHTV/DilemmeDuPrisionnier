package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TestDonnantDonnant {

	@Test
	@Order(1)
	void testPlay() {
		DonnantDonnant dd = new DonnantDonnant();
		dd.numTour = 10;
		assertEquals(1, dd.numTour);
		dd.play();
		String result = dd.getPlay();
		assertEquals("c", result);
		assertEquals(2, dd.numTour);
		dd.setOppPlay("t");
		dd.play();
		result = dd.getPlay();
		assertEquals("t", result);
		assertEquals(3, dd.numTour);
		dd.setOppPlay("bonjour");
		dd.play();
		result = dd.getPlay();
		assertEquals("bonjour", result);
	}
}
