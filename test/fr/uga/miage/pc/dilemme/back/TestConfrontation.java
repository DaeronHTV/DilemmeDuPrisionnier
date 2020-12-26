package fr.uga.miage.pc.dilemme.back;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.back.strategie.IStrategie;
import fr.uga.miage.pc.dilemme.back.strategie.DonnantDonnant;
import fr.uga.miage.pc.dilemme.back.strategie.DonnantDonnantDur;
import fr.uga.miage.pc.dilemme.back.strategie.Gentille;
import fr.uga.miage.pc.dilemme.back.strategie.Mechante;

class TestConfrontation extends Confrontation{

	public TestConfrontation() { super(new Gentille(), new Mechante()); }

	@Test
	@Order(1)
	void testGetterStrategie() { 
		IStrategie s1 = getStrategie(ConfrontationConstants.STRATEGIE_1);
		assertTrue(s1.equals(new Gentille())); 
		IStrategie s2 = getStrategie(ConfrontationConstants.STRATEGIE_2); 
		assertTrue(s2.equals(new Mechante()));
	}
	
	@Test
	@Order(2)
	void testSetterStrategie() {
		setStrategie(ConfrontationConstants.STRATEGIE_1, new DonnantDonnant());
		setStrategie(ConfrontationConstants.STRATEGIE_2, new DonnantDonnantDur());
		//TODO Finir le cas de test (Priorité éleve)
	}
	
	@Test
	@Order(3)
	void testGetterScoresFinal() {
		this.start(20);
		assertEquals(0, getFinalScore(ConfrontationConstants.STRATEGIE_1));
		assertEquals(100, getFinalScore(ConfrontationConstants.STRATEGIE_2));
	}

	
	@Test
	@Order(4)
	void testToString() {
		assertEquals(getStrategie(ConfrontationConstants.STRATEGIE_1).getNom() + " VS " 
		+ getStrategie(ConfrontationConstants.STRATEGIE_2).getNom(), toString());
	}
	
	@Test
	@Order(5)
	void testStartAndScoreTour() {
		//TODO Voir si il est possible de modifier le façon de faire le test (priorité faible)
		this.start(20);
		assertEquals(0, getFinalScore(ConfrontationConstants.STRATEGIE_1));
		assertEquals(100, getFinalScore(ConfrontationConstants.STRATEGIE_2));
	}

	/***************************DEPRECATED TEST*****************************************/
	@Test
	@Order(6)
	@Deprecated
	@Disabled
	void testGettersStrategie() { 
		IStrategie s1 = getStrategie1(); 
		assertTrue(s1.equals(new Gentille())); 
		IStrategie s2 = getStrategie2(); 
		assertTrue(s2.equals(new Mechante()));
	}

	@Test
	@Order(7)
	@Deprecated
	@Disabled
	void testGettersScoresFinal() {
		this.start(20);
		assertEquals(0, this.getFinalScoreS1());
		assertEquals(100, this.getFinalScoreS2());
	}

	@Test
	@Order(8)
	@Deprecated
	@Disabled
	void testSettersStrategie() {
		setStrategie1(new DonnantDonnant());
		setStrategie2(new DonnantDonnantDur());
	}
}
