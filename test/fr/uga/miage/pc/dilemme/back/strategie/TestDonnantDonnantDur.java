package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.interfaces.Comportement;

class TestDonnantDonnantDur {

	@Test
	@Order(1)
	void testPlay() {
		DonnantDonnantDur ddd = new DonnantDonnantDur();
		assertEquals(1, ddd.numTour);
		ddd.compareComportements();
		Comportement result = ddd.getComportement();
		assertEquals(Comportement.COOPERER, result);
		assertEquals(2, ddd.numTour);
		ddd.opponentComportement(Comportement.TRAHIR);
		ddd.compareComportements();
		result = ddd.getComportement();
		assertEquals(3, ddd.numTour);
		assertEquals(Comportement.TRAHIR, result);
		ddd.opponentComportement(Comportement.COOPERER);
		ddd.opponentComportement(Comportement.RENONCER);
		ddd.compareComportements();
		result = ddd.getComportement();
		assertEquals(Comportement.COOPERER, result);
	}
}
