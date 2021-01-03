package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.interfaces.Comportement;

class TestRancuniere {

	@Test
	@Order(1)
	void testPlay() {
		Rancuniere r = new Rancuniere();
		r.compareComportements();
		Comportement result = r.getComportement();
		assertEquals(Comportement.COOPERER, result);
		r.opponentComportement(Comportement.COOPERER);
		r.opponentComportement(Comportement.COOPERER);
		r.opponentComportement(Comportement.RENONCER);
		r.compareComportements();
		result = r.getComportement();
		assertEquals(Comportement.COOPERER, result);
		r.opponentComportement(Comportement.TRAHIR);
		r.compareComportements();
		result = r.getComportement();
		assertEquals(Comportement.TRAHIR, result);
		r.opponentComportement(Comportement.COOPERER);
		r.opponentComportement(Comportement.COOPERER);
		r.opponentComportement(Comportement.COOPERER);
		r.compareComportements();
		result = r.getComportement();
		assertEquals(Comportement.TRAHIR, result);
	}
}
