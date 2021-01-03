package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.interfaces.Comportement;

class TestGentille {

	@Test
	@Order(1)
	void testPlay() {
		Gentille g = new Gentille();
		assertEquals(1, g.numTour);
		g.compareComportements();
		Comportement result = g.getComportement();
		assertEquals(Comportement.COOPERER, result);
		assertEquals(2, g.numTour);
	}
}
