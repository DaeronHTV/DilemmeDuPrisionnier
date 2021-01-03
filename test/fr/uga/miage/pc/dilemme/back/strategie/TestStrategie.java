package fr.uga.miage.pc.dilemme.back.strategie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.interfaces.Comportement;

class TestStrategie extends Strategie{

	public TestStrategie() { super("Test", "Test Description"); }

	@Test
	@Order(1)
	void testGetNomStrategie() { assertEquals("Test", this.getStrategyName()); }
	
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
		assertEquals(getComportement(), null);
		setComportement(Comportement.COOPERER);
		assertEquals(getComportement(), Comportement.COOPERER);
	}
	
	@Test
	@Order(6)
	void TestClear() {
		numTour++;
		setComportement(Comportement.COOPERER);clear();
		assertEquals(1, numTour);
		assertEquals(0, sizeOppPlay());
	}
	
	@Test
	@Order(7)
    void TestGetSetOppPlay() throws IndexOutOfBoundsException{
            assertThrows(IndexOutOfBoundsException.class, () -> {
                getOppPlay(1);
            });
            opponentComportement(Comportement.RENONCER);
            assertEquals(Comportement.RENONCER, getOppPlay(0));
    }
	
	@Test
	@Order(8)
	void TestSizeOppPlay() {
		opponentComportement(Comportement.RENONCER);opponentComportement(Comportement.RENONCER);
		assertEquals(2, sizeOppPlay());
	}
	
	@Test
	@Order(9)
	void TestFindValue() {
		opponentComportement(Comportement.COOPERER);opponentComportement(Comportement.RENONCER);
		opponentComportement(Comportement.TRAHIR);
		assertTrue(findValue(Comportement.COOPERER));
		assertTrue(findValue(Comportement.RENONCER));
		assertFalse(findValue(Comportement.TRAHIR));
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
	public void compareComportements() { }
}
