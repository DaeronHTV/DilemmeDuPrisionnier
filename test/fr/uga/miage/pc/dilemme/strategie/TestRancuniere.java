package fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRancuniere {

	@Test
	void testPlay() {
		Rancuniere r = new Rancuniere();
		String result = r.play();
		assertEquals("c", result);
		r.setPlay("c");
		r.setPlay("c");
		r.setPlay("n");
		result = r.play();
		assertEquals("c", result);
		r.setPlay("t");
		result = r.play();
		assertEquals("t", result);
		r.setPlay("c");
		r.setPlay("c");
		r.setPlay("c");
		result = r.play();
		assertEquals("t", result);
	}

}
