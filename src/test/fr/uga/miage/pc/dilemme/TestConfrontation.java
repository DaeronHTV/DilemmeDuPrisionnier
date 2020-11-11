package test.fr.uga.miage.pc.dilemme;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.Confrontation;
import fr.uga.miage.pc.dilemme.IStrategie;
import fr.uga.miage.pc.dilemme.strategie.DonnantDonnant;
import fr.uga.miage.pc.dilemme.strategie.DonnantDonnantDur;
import fr.uga.miage.pc.dilemme.strategie.Gentille;
import fr.uga.miage.pc.dilemme.strategie.Mechante;

class TestConfrontation extends Confrontation{

	public TestConfrontation() { super(new Gentille(), new Mechante()); }

	@Test
	void testGetterStrategie() { 
		// TODO Modifier les asserts pour correspondre à nouvelle implémentation
		IStrategie s1 = getStrategie1(); 
		assertTrue(s1.equals(new Gentille())); 
		IStrategie s2 = getStrategie2(); 
		assertTrue(s2.equals(new Mechante()));
	}
	
	@Test
	void testSetterStrategie() {
		setStrategie1(new DonnantDonnant());
		setStrategie2(new DonnantDonnantDur());
	}
	
	@Test
	void testGetterScoresFinal() {
		this.start(20);
		assertEquals(0, this.getFinalScoreS1());
		assertEquals(100, this.getFinalScoreS2());
	}

	
	@Test
	void testToString() {
		assertEquals(getStrategie1().getNom() + " VS " + getStrategie2().getNom(), toString());
	}
	
	@Test
	void testStartAndScoreTour() {
		this.start(20);
		assertEquals(0, this.getFinalScoreS1());
		assertEquals(100, this.getFinalScoreS2());
	}
}
