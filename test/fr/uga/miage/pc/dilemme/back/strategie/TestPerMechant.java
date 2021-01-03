package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.interfaces.Comportement;

class TestPerMechant {

	@Test
	@Order(1)
	void testPlay() {
		PerMechant pm = new PerMechant();
		assertEquals(1, pm.numTour);
		pm.compareComportements();
		Comportement result = pm.getComportement();
		assertEquals(Comportement.TRAHIR, result);
		assertEquals(2, pm.numTour);
		pm.compareComportements();
		result = pm.getComportement();
		assertEquals(Comportement.TRAHIR, result);
		assertEquals(3, pm.numTour);
		pm.compareComportements();
		result = pm.getComportement();
		assertEquals(Comportement.COOPERER, result);
		assertEquals(4, pm.numTour);
		pm.compareComportements();
		result = pm.getComportement();
		assertEquals(Comportement.TRAHIR, result);
		assertEquals(5, pm.numTour);
		pm.compareComportements();
		result = pm.getComportement();
		assertEquals(Comportement.TRAHIR, result);
		assertEquals(6, pm.numTour);
		pm.compareComportements();
		result = pm.getComportement();
		assertEquals(Comportement.COOPERER, result);
		assertEquals(7, pm.numTour);
	}

}
