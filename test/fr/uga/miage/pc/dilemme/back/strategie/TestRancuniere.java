package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.back.strategie.Rancuniere;

class TestRancuniere {

	@Test
	@Order(1)
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
}
