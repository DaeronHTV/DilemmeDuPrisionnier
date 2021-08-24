package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.back.strategie.DonnantDonnantDur;

class TestDonnantDonnantDur {

	@Test
	@Order(1)
	void testPlay() {
		DonnantDonnantDur ddd = new DonnantDonnantDur();
		assertEquals(1, ddd.numTour);
		ddd.play();
		String result = ddd.getPlay();
		assertEquals("c", result);
		assertEquals(2, ddd.numTour);
		ddd.setOppPlay("t");
		ddd.play();
		result = ddd.getPlay();
		assertEquals(3, ddd.numTour);
		assertEquals("t", result);
		ddd.setOppPlay("c");
		ddd.setOppPlay("n");
		ddd.play();
		result = ddd.getPlay();
		assertEquals("c", result);
	}
}
