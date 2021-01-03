package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.interfaces.Comportement;

class TestMefiante {

	@Test
	@Order(1)
	void testPlay() {
		Mefiante mf = new Mefiante();
		assertEquals(1, mf.numTour);
		mf.compareComportements();
		Comportement result = mf.getComportement();
		assertEquals(Comportement.TRAHIR, result);
		assertEquals(2, mf.numTour);
		mf.opponentComportement(Comportement.TRAHIR);
		mf.compareComportements();
		result = mf.getComportement();
		assertEquals(Comportement.TRAHIR, result);
		assertEquals(3, mf.numTour);
		mf.opponentComportement(Comportement.RENONCER);
		mf.compareComportements();
		result = mf.getComportement();
		assertEquals(Comportement.RENONCER, result);
	}
}
