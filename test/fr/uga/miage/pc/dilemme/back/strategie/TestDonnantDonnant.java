package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.interfaces.Comportement;

class TestDonnantDonnant {

	@Test
	@Order(1)
	void testPlay() {
		DonnantDonnant dd = new DonnantDonnant();
		dd.numTour = 10;
		assertEquals(1, dd.numTour);
		dd.compareComportements();
		Comportement result = dd.getComportement();
		assertEquals(Comportement.COOPERER, result);
		assertEquals(2, dd.numTour);
		dd.opponentComportement(Comportement.TRAHIR);
		dd.compareComportements();
		result = dd.getComportement();
		assertEquals(Comportement.TRAHIR, result);
		assertEquals(3, dd.numTour);
		dd.opponentComportement(Comportement.COOPERER);
		dd.compareComportements();
		result = dd.getComportement();
		assertEquals(Comportement.COOPERER, result);
	}
}
