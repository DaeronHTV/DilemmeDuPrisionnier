package test.fr.uga.miage.pc.dilemme.strategie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.strategie.Strategie;

class TestStrategie extends Strategie{

	public TestStrategie() { super("Test", "Test Description"); }

	@Test
	void testGetNomStrategie() { assertEquals("Test", this.getNom()); }
	
	@Test
	void testSetNomStrategie() {
		this.setNom("NouveauTest");
		assertEquals("NouveauTest", this.getNom());
	}
	
	@Test
	void testGetDescription() { assertEquals("Test Description", this.getDescription()); }
	
	@Test
	void testSetDescription() {
		this.setDescription("NouveauTest");
		assertEquals("NouveauTest", this.getDescription());
	}
	
	@Test
	void testSetForfait() {
		assertFalse(this.isForfait());
		this.setForfait(true);
		assertTrue(this.isForfait());
	}
	
	@Test
	void testIsForfait() {
		assertFalse(this.isForfait());
		this.setForfait(true);
		assertTrue(this.isForfait());
	}
	
	@Test
	void testGetSetPlay() {
		assertEquals(getPlay(), null);
		setPlay("hello");
		assertEquals(getPlay(), "hello");
	}
	
	@Test
	void TestClear() {
		incrementNumTour();
		setPlay("bbbu");
		clear();
		assertEquals(1, this.getNumTour());
		assertEquals(0, this.sizeOppPlay());
	}
	
	@Test
    void TestGetSetOppPlay() throws IndexOutOfBoundsException{
            assertThrows(IndexOutOfBoundsException.class, () -> {
                getOppPlay(1);
            });
            setOppPlay("test");
            assertEquals("test", getOppPlay(0));
    }
	
	@Test
	void TestSizeOppPlay() {
		this.setOppPlay("fge");
		this.setOppPlay("gze,lg,");
		assertEquals(2, this.sizeOppPlay());
	}
	
	@Test
	void TestFindValue() {
		setOppPlay("test");
		setOppPlay("lol");
		setOppPlay("lol");
		assertTrue(findValue("test"));
		assertTrue(findValue("lol"));
		assertFalse(findValue("grog"));
	}
	
	@Test
	void testIncrementGetTour() {
		assertEquals(1, getNumTour());
		this.incrementNumTour();
		this.incrementNumTour();
		assertEquals(3, getNumTour());
	}
	
	@Test
	void TestToString() { assertEquals("Test - Test Description", toString()); }

	@Override
	public void play() { }
	@Override
	public Object clone() { return null; }
}
