package fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPerMechant {

	@Test
	void testPlay() {
		PerMechant pm = new PerMechant();
		assertEquals(1, pm.getNumTour());
		String result = pm.play();
		assertEquals("t", result);
		assertEquals(2, pm.getNumTour());
		result = pm.play();
		assertEquals("t", result);
		assertEquals(3, pm.getNumTour());
		result = pm.play();
		assertEquals("c", result);
		assertEquals(4, pm.getNumTour());
		result = pm.play();
		assertEquals("t", result);
		assertEquals(5, pm.getNumTour());
		result = pm.play();
		assertEquals("t", result);
		assertEquals(6, pm.getNumTour());
		result = pm.play();
		assertEquals("c", result);
		assertEquals(7, pm.getNumTour());
	}

}
