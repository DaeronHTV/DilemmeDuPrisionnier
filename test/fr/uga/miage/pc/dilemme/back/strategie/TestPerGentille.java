package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class TestPerGentille {

	@Test
	@Order(1)
	void testPlay() {
		PerGentille pg = new PerGentille();
		assertEquals(1, pg.numTour);
		pg.play();
		String result = pg.getPlay();
		assertEquals("c", result);
		assertEquals(2, pg.numTour);
		pg.play();
		result = pg.getPlay();
		assertEquals("c", result);
		assertEquals(3, pg.numTour);
		pg.play();
		result = pg.getPlay();
		assertEquals("t", result);
		assertEquals(4, pg.numTour);
		pg.play();
		result = pg.getPlay();
		assertEquals("c", result);
		assertEquals(5, pg.numTour);
		pg.play();
		result = pg.getPlay();
		assertEquals("c", result);
		assertEquals(6, pg.numTour);
		pg.play();
		result = pg.getPlay();
		assertEquals("t", result);
		assertEquals(7, pg.numTour);
	}

}
