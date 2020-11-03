package fr.uga.miage.pc.dilemme;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.strategie.Gentille;
import fr.uga.miage.pc.dilemme.strategie.Mechante;

class TestRencontre extends Rencontre{

	public TestRencontre() {
		super(new Gentille(), new Mechante());
	}

	@Test
	void testGetStrategie1() {
		Strategie s = this.getStrategie1();
		assertTrue(s.equals(new Gentille()));
	}
	
	@Test
	void testGetStrategie2(){
		Strategie s = this.getStrategie2();
		assertTrue(s.equals(new Mechante()));
	}
	
	@Test
	void testSetStrategie1() {
		
	}
	
	@Test
	void testSetStrategie2() {
		
	}
	
	/*@Test
	void testGetFinalScores() {
		this.start(20);
		assertEquals(0, this.getFinalScores()[0]);
		assertEquals(100, this.getFinalScores()[1]);
	}*/
	
	@Test
	void testGetFinalScoreS1() {
		this.start(20);
		assertEquals(0, this.getFinalScoreS1());
	}
	
	@Test
	void testGetFinalScoreS2() {
		this.start(20);
		assertEquals(100, this.getFinalScoreS2());
	}
	
	@Test
	void testToString() {
		assertEquals("La rencontre oppose " + this.getStrategie1().getNomStrategie() + " et " + this.getStrategie2().getNomStrategie(), this.toString());
	}
	
	@Test
	void testLaunch() {
		this.start(20);
		assertEquals(0, this.getFinalScoreS1());
		assertEquals(100, this.getFinalScoreS2());
	}
}
