package fr.uga.miage.pc.dilemme;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.exception.ForfaitException;

class TestStrategie extends Strategie{

	public TestStrategie() { super("Test", "Test Description"); }

	@Test
	void testGetNomStrategie() { assertEquals("Test", this.getNomStrategie()); }
	
	@Test
	void testGetDescription() { assertEquals("Test Description", this.getDescription()); }
	
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
		assertThrows(ForfaitException.class, () -> { this.setForfait(false); });
	}
	
	@Test
	void testIsForfait() throws ForfaitException {
		assertFalse(this.isForfait());
		this.setForfait(true);
		assertTrue(this.isForfait());
	}
	
	@Test
	void testIncrementTour() {
		assertEquals(1, this.getNumTour());
		this.incrementNumTour();
		this.incrementNumTour();
		assertEquals(3, this.getNumTour());
	}
	
	@Test
	void TestSetPlay() {
		this.setPlay("test");
		assertEquals("test", this.getPlayValue(0));
	}
	
	@Test
	void TestFindValue() {
		this.setPlay("test");
		this.setPlay("lol");
		this.setPlay("lol");
		assertTrue(this.findValue("test"));
		assertTrue(this.findValue("lol"));
		assertFalse(this.findValue("grog"));
	}
	
	@Test
	void TestSizeListPlay() {
		this.setPlay("fge");
		this.setPlay("gze,lg,");
		assertEquals(2, this.sizeListPlay());
	}
	
	@Test
	void TestClear() {
		this.incrementNumTour();
		this.setPlay("bbbu");
		this.clear();
		assertEquals(1, this.getNumTour());
		assertEquals(0, this.sizeListPlay());
	}
	
	@Test
	void TestToString() { assertEquals("Stratégie : Test\nDescription : Test Description\nEst toujours dans la course !", this.toString()); }
	
	@Test
	void TestEquals() {
		TestStrategie ts = new TestStrategie();
		assertTrue(this.equals(ts));
		ts.setDescription("gjgjgjgj");
		assertFalse(this.equals(ts));
	}

	@Override
	public String play() { return null; }
	@Override
	public Strategie clone() { return null; }
}
