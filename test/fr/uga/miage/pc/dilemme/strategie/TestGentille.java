package fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGentille {

	@Test
	void testPlay() {
		Gentille g = new Gentille();
		assertEquals(1, g.getNumTour());
		String result = g.play();
		assertEquals("c", result);
		assertEquals(2, g.getNumTour());
	}
}
