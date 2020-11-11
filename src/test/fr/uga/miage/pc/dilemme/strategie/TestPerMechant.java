package test.fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.strategie.PerMechant;

class TestPerMechant {

	@Test
	void testPlay() {
		PerMechant pm = new PerMechant();
		assertEquals(1, pm.getNumTour());
		pm.play();
		String result = pm.getPlay();
		assertEquals("t", result);
		assertEquals(2, pm.getNumTour());
		pm.play();
		result = pm.getPlay();
		assertEquals("t", result);
		assertEquals(3, pm.getNumTour());
		pm.play();
		result = pm.getPlay();
		assertEquals("c", result);
		assertEquals(4, pm.getNumTour());
		pm.play();
		result = pm.getPlay();
		assertEquals("t", result);
		assertEquals(5, pm.getNumTour());
		pm.play();
		result = pm.getPlay();
		assertEquals("t", result);
		assertEquals(6, pm.getNumTour());
		pm.play();
		result = pm.getPlay();
		assertEquals("c", result);
		assertEquals(7, pm.getNumTour());
	}

}
