package fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMechante {

	@Test
	void testPlay() {
		Mechante g = new Mechante();
		assertEquals(1, g.getNumTour());
		String result = g.play();
		assertEquals("t", result);
		assertEquals(2, g.getNumTour());
	}

}
