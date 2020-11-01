package fr.uga.miage.pc.dilemme.test;
import fr.uga.miage.pc.dilemme.Tour;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTour {
	
	/**
	 * @description Test for the first constructor of the class Tour
	 * @see Tour#Tour(int length)
	 */
	@Test
	void TestConstructor1() {
		Tour test = new Tour(2);
		assertEquals(2, test.getNbParticipant());
	}
	
	/**
	 * @description Test for the second constructor of the class Tour
	 * @throws LengthException
	 * @see Tour#Tour(int[] score)
	 */
	/*@Test
	void TestCosntructor2() throws LengthException{
		Tour test = new Tour(new int[] {2, 3, 5});
		assertEquals(3, test.getNbParticipant());
		assertEquals(2, test.getScore()[0]);
	}*/
	
	/**
	 * @description Test the score's setter of the class
	 * @throws LengthException
	 * @see Tour#setScore(int[] score)
	 */
	/*@Test
	void TestSetScore() throws LengthException{
		Tour test = new Tour(3);
		test.setScore(new int[] {2, 3, 5});
		assertEquals(5, test.getScore()[2]);
		assertEquals(3, test.getNbParticipant());
		assertThrows(LengthException.class, () -> {
		    test.setScore(new int[] {2, 5});;
		});
	}*/
	
	/**
	 * @description Test the score's getter of the class
	 * @see Tour#getScore()
	 */
	@Test
	void TestGetScore() {
		Tour test = new Tour(new int[] {2, 5, 6});
		assertEquals(2, test.getScore()[0]);
		assertEquals(5, test.getScore()[1]);
		assertEquals(6, test.getScore()[2]);
	}
	
	/**
	 * @description Test the number participant's setter of the class
	 * @see Tour#setNbParticipant(int nbParticipant)
	 */
	@Test
	void TestSetNbParticipant() {
		Tour test = new Tour(5);
		test.setNbParticipant(25);
		assertEquals(25, test.getNbParticipant());
	}
	
	/**
	 * @description Test the number participant's getter of the class
	 * @see Tour#getNbParticipant()
	 */
	@Test
	void TestGetNbParticipant() {
		Tour test = new Tour(5);
		assertEquals(5, test.getNbParticipant());
	}
}
