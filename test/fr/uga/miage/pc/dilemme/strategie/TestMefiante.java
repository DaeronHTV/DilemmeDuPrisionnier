package fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMefiante {

	@Test
	void testPlay() {
		Mefiante mf = new Mefiante();
		assertEquals(1, mf.getNumTour());
		String result = mf.play();
		assertEquals("t", result);
		assertEquals(2, mf.getNumTour());
		mf.setPlay("t");
		result = mf.play();
		assertEquals("t", result);
		assertEquals(3, mf.getNumTour());
		mf.setPlay("bonjour");
		result = mf.play();
		assertEquals("bonjour", result);
	}

}
