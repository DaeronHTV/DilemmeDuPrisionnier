package fr.uga.miage.pc.dilemme;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.uga.miage.exception.ForfaitException;

class TestStrategie extends Strategie{

	public TestStrategie() {
		super("Test", "Test Description");
	}

	@Test
	void testGetNomStrategie() {
		assertEquals("Test", this.getNomStrategie());
	}
	
	@Test
	void testGetDescription() {
		assertEquals("Test Description", this.getDescription());
	}
	
	@Test
	void testSetNomStrategie() {
		this.setNomStrategie("NouveauTest");
		assertEquals("NouveauTest", this.getNomStrategie());
	}
	
	@Test
	void testSetDescription() {
		this.setDescription("NouveauTest");
		assertEquals("NouveauTest", this.getDescription());
	}
	
	@Test
	void testSetForfait() throws ForfaitException {
		assertFalse(this.isForfait());
		this.setForfait(true);
		assertTrue(this.isForfait());
	}

	@Override
	public String play() {
		return null;
	}

}
