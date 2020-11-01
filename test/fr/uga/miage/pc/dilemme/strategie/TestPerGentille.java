package fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPerGentille {

	@Test
	void testPlay() {
		PerGentille pg = new PerGentille();
		assertEquals(1, pg.getNumTour());
		String result = pg.play();
		assertEquals("c", result);
		assertEquals(2, pg.getNumTour());
		result = pg.play();
		assertEquals("c", result);
		assertEquals(3, pg.getNumTour());
		result = pg.play();
		assertEquals("t", result);
		assertEquals(4, pg.getNumTour());
		result = pg.play();
		assertEquals("c", result);
		assertEquals(5, pg.getNumTour());
		result = pg.play();
		assertEquals("c", result);
		assertEquals(6, pg.getNumTour());
		result = pg.play();
		assertEquals("t", result);
		assertEquals(7, pg.getNumTour());
	}

}
