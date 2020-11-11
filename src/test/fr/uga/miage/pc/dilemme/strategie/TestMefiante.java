package test.fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.IStrategie;
import fr.uga.miage.pc.dilemme.strategie.Mefiante;

class TestMefiante {

	@Test
	void testPlay() {
		Mefiante mf = new Mefiante();
		assertEquals(1, mf.getNumTour());
		mf.play();
		String result = mf.getPlay();
		assertEquals("t", result);
		assertEquals(2, mf.getNumTour());
		mf.setOppPlay("t");
		mf.play();
		result = mf.getPlay();
		assertEquals("t", result);
		assertEquals(3, mf.getNumTour());
		mf.setOppPlay("bonjour");
		mf.play();
		result = mf.getPlay();
		assertEquals("bonjour", result);
	}
	
	@Test
	void testClone() {
		Mefiante dd = new Mefiante();
		IStrategie test = (IStrategie)dd.clone();
		assertTrue(test.getNom().equals(dd.getNom()));
		assertTrue(test.getDescription().equals(dd.getDescription()));
	}

}
