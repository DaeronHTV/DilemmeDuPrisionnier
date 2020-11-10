package fr.uga.miage.pc.dilemme;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.strategie.Gentille;
import fr.uga.miage.pc.dilemme.strategie.Mechante;
import fr.uga.miage.pc.dilemme.strategie.Strategie;

class TestRencontre extends Confrontation{

	public TestRencontre() { super(new Gentille(), new Mechante()); }

	@Test
	void testGetStrategie1() { Strategie s = this.getStrategie1(); assertTrue(s.equals(new Gentille())); }
	
	@Test
	void testGetStrategie2(){ Strategie s = this.getStrategie2(); assertTrue(s.equals(new Mechante())); }

	
	@Test
	void testToString() {
		assertEquals("La rencontre oppose " + this.getStrategie1().getNom() + " et " + this.getStrategie2().getNom(), this.toString());
	}
	
	@Test
	void testLaunch() {
		this.start(20);
		assertEquals(0, this.getFinalScoreS1());
		assertEquals(100, this.getFinalScoreS2());
	}
}
