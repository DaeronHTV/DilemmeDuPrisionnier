package test.fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.IStrategie;
import fr.uga.miage.pc.dilemme.strategie.Rancuniere;

class TestRancuniere {

	@Test
	void testPlay() {
		Rancuniere r = new Rancuniere();
		r.play();
		String result = r.getPlay();
		assertEquals("c", result);
		r.setOppPlay("c");
		r.setOppPlay("c");
		r.setOppPlay("n");
		r.play();
		result = r.getPlay();
		assertEquals("c", result);
		r.setOppPlay("t");
		r.play();
		result = r.getPlay();
		assertEquals("t", result);
		r.setOppPlay("c");
		r.setOppPlay("c");
		r.setOppPlay("c");
		r.play();
		result = r.getPlay();
		assertEquals("t", result);
	}

	@Test
	void testClone() {
		Rancuniere dd = new Rancuniere();
		IStrategie test = (IStrategie)dd.clone();
		assertTrue(test.getNom().equals(dd.getNom()));
		assertTrue(test.getDescription().equals(dd.getDescription()));
	}
}
