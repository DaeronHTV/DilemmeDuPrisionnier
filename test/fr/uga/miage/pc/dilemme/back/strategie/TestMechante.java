package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TestMechante {

	@Test
	@Order(1)
	void testPlay() {
		Mechante g = new Mechante();
		assertEquals(1, g.numTour);
		g.play();
		String result = g.getPlay();
		assertEquals("t", result);
		assertEquals(2, g.numTour);
	}
}
