package test.fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.strategie.PerGentille;

class TestPerGentille {

	@Test
	void testPlay() {
		PerGentille pg = new PerGentille();
		assertEquals(1, pg.getNumTour());
		pg.play();
		String result = pg.getPlay();
		assertEquals("c", result);
		assertEquals(2, pg.getNumTour());
		pg.play();
		result = pg.getPlay();
		assertEquals("c", result);
		assertEquals(3, pg.getNumTour());
		pg.play();
		result = pg.getPlay();
		assertEquals("t", result);
		assertEquals(4, pg.getNumTour());
		pg.play();
		result = pg.getPlay();
		assertEquals("c", result);
		assertEquals(5, pg.getNumTour());
		pg.play();
		result = pg.getPlay();
		assertEquals("c", result);
		assertEquals(6, pg.getNumTour());
		pg.play();
		result = pg.getPlay();
		assertEquals("t", result);
		assertEquals(7, pg.getNumTour());
	}

}
