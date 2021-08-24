package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.back.strategie.PerMechant;

class TestPerMechant {

	@Test
	@Order(1)
	void testPlay() {
		PerMechant pm = new PerMechant();
		assertEquals(1, pm.numTour);
		pm.play();
		String result = pm.getPlay();
		assertEquals("t", result);
		assertEquals(2, pm.numTour);
		pm.play();
		result = pm.getPlay();
		assertEquals("t", result);
		assertEquals(3, pm.numTour);
		pm.play();
		result = pm.getPlay();
		assertEquals("c", result);
		assertEquals(4, pm.numTour);
		pm.play();
		result = pm.getPlay();
		assertEquals("t", result);
		assertEquals(5, pm.numTour);
		pm.play();
		result = pm.getPlay();
		assertEquals("t", result);
		assertEquals(6, pm.numTour);
		pm.play();
		result = pm.getPlay();
		assertEquals("c", result);
		assertEquals(7, pm.numTour);
	}

}
