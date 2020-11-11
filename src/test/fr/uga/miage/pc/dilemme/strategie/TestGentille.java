package test.fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.IStrategie;
import fr.uga.miage.pc.dilemme.strategie.Gentille;

class TestGentille {

	@Test
	void testPlay() {
		Gentille g = new Gentille();
		assertEquals(1, g.getNumTour());
		g.play();
		String result = g.getPlay();
		assertEquals("c", result);
		assertEquals(2, g.getNumTour());
	}
	
	@Test
	void testClone() {
		Gentille dd = new Gentille();
		IStrategie test = (IStrategie)dd.clone();
		assertTrue(test.getNom().equals(dd.getNom()));
		assertTrue(test.getDescription().equals(dd.getDescription()));
	}
}
