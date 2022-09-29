package fr.uga.miage.pc.dilemme.back;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.back.strategie.DonnantDonnant;
import fr.uga.miage.pc.dilemme.back.strategie.DonnantDonnantDur;
import fr.uga.miage.pc.dilemme.back.strategie.Gentille;
import fr.uga.miage.pc.dilemme.back.strategie.Mechante;
import fr.uga.miage.pc.interfaces.IStrategie;

class TestConfrontation extends Confrontation{

	public TestConfrontation() { super(new Gentille(), new Mechante(), 1); }

	//TODO Modifier la méthode equals pour le test
	@Test
	@Order(1)
	void testGetterStrategie() {
		TestConfrontation test = new TestConfrontation();
		IStrategie s1 = test.Strategie(ConfrontationConstants.STRATEGIE_1);
		assertTrue(s1.equals(new Gentille())); 
		IStrategie s2 = test.Strategie(ConfrontationConstants.STRATEGIE_2); 
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
		assertEquals(0, FinalScore(ConfrontationConstants.STRATEGIE_1));
		assertEquals(100, FinalScore(ConfrontationConstants.STRATEGIE_2));
	}

	
	@Test
	@Order(4)
	void testToString() {
		assertEquals(Strategie(ConfrontationConstants.STRATEGIE_1).getStrategyName() + " VS " 
		+ Strategie(ConfrontationConstants.STRATEGIE_2).getStrategyName(), toString());
	}
	
	@Test
	@Order(5)
	void testStartAndScoreTour() {
		//TODO Voir si il est possible de modifier le façon de faire le test (priorité faible)
		this.start(20);
		assertEquals(0, FinalScore(ConfrontationConstants.STRATEGIE_1));
		assertEquals(100, FinalScore(ConfrontationConstants.STRATEGIE_2));
	}
}
