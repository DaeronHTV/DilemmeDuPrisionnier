package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.back.strategie.Mefiante;

class TestMefiante {

	@Test
	@Order(1)
	void testPlay() {
		Mefiante mf = new Mefiante();
		assertEquals(1, mf.numTour);
		mf.play();
		String result = mf.getPlay();
		assertEquals("t", result);
		assertEquals(2, mf.numTour);
		mf.setOppPlay("t");
		mf.play();
		result = mf.getPlay();
		assertEquals("t", result);
		assertEquals(3, mf.numTour);
		mf.setOppPlay("bonjour");
		mf.play();
		result = mf.getPlay();
		assertEquals("bonjour", result);
	}
}
