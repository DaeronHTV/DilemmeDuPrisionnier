package test.fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.IStrategie;
import fr.uga.miage.pc.dilemme.strategie.Mechante;

class TestMechante {

	@Test
	void testPlay() {
		Mechante g = new Mechante();
		assertEquals(1, g.getNumTour());
		g.play();
		String result = g.getPlay();
		assertEquals("t", result);
		assertEquals(2, g.getNumTour());
	}

	@Test
	void testClone() {
		Mechante dd = new Mechante();
		IStrategie test = (IStrategie)dd.clone();
		assertTrue(test.getNom().equals(dd.getNom()));
		assertTrue(test.getDescription().equals(dd.getDescription()));
	}
}
