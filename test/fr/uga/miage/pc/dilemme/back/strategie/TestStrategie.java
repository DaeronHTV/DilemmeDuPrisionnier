package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.back.strategie.Strategie;

class TestStrategie extends Strategie{

	public TestStrategie() { super("Test", "Test Description"); }

	@Test
	@Order(1)
	void testGetNomStrategie() { assertEquals("Test", this.getNom()); }
	
	@Test
	@Order(2)
	void testSetNomStrategie() {
		this.setNom("NouveauTest");
		assertEquals("NouveauTest", this.getNom());
	}
	
	@Test
	@Order(3)
	void testGetDescription() { assertEquals("Test Description", this.getDescription()); }
	
	@Test
	@Order(4)
	void testSetDescription() {
		this.setDescription("NouveauTest");
		assertEquals("NouveauTest", this.getDescription());
	}
	
	@Test
	@Order(5)
	void testGetSetPlay() {
		assertEquals(getPlay(), null);
		setPlay("hello");
		assertEquals(getPlay(), "hello");
	}
	
	@Test
	@Order(6)
	void TestClear() {
		numTour++;
		setPlay("bbbu");clear();
		assertEquals(1, numTour);
		assertEquals(0, sizeOppPlay());
	}
	
	@Test
	@Order(7)
    void TestGetSetOppPlay() throws IndexOutOfBoundsException{
            assertThrows(IndexOutOfBoundsException.class, () -> {
                getOppPlay(1);
            });
            setOppPlay("test");
            assertEquals("test", getOppPlay(0));
    }
	
	@Test
	@Order(8)
	void TestSizeOppPlay() {
		setOppPlay("fge");setOppPlay("gze,lg,");
		assertEquals(2, sizeOppPlay());
	}
	
	@Test
	@Order(9)
	void TestFindValue() {
		setOppPlay("test");setOppPlay("lol");
		setOppPlay("lol");
		assertTrue(findValue("test"));
		assertTrue(findValue("lol"));
		assertFalse(findValue("grog"));
	}
	
	@Test
	@Order(10)
	void testIncrementGetTour() {
		assertEquals(1, numTour);
		numTour++;numTour++;
		assertEquals(3, numTour);
	}
	
	@Test
	@Order(11)
	void TestToString() { assertEquals("Test - Test Description", toString()); }

	@Override
	public void play() { }
}
