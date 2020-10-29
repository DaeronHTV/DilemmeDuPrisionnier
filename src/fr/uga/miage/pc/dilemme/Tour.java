package fr.uga.miage.pc.dilemme;

import fr.uga.miage.exception.LengthException;

/**
 * @description This class implement all the features to desribe a Tour
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public class Tour {
	/**
	 * @description Represent the different score for each member of the game
	 * @see Tour#Tour(int[])
	 * @see Tour#setScore(int[])
	 */
	public int[] score;
	
	/**
	 * @description Number of participant in this Tour
	 * @see Tour#Tour(int)
	 * @see Tour#setNbParticipant(int)
	 */
	public int nbParticipant;
	
	/**
	 * @description Default constructor of the class Tour
	 * @version 1.0.0
	 * @see Tour#score
	 */
	public Tour(int nbParticipant) {
		this.score = new int[nbParticipant];
		this.nbParticipant = nbParticipant;
	}
	
	/**
	 * @description Constructor of the class
	 * @param int[] score
	 * @version 1.0.0
	 * @see Tour#score
	 */
	public Tour(int[] score) {
		this.score = score;
		this.nbParticipant = this.score.length;
	}
	
	/**
	 * @description Change the value of the different score
	 * We supposed that the user cannot change the array by another with a different length
	 * @param int[] score
	 * @version 1.0.0
	 * @throws LengthException 
	 * @see LengthException#LengthException
	 * @see Tour#score
	 */
	public void setScore(int[] score) throws LengthException {
		if(score.length == this.nbParticipant) {
			this.score = score;
		} else {
			throw new LengthException("The length of the array doesn't match !");
		}
	}
	
	/**
	 * @description Get the list of the different score
	 * @return int[]
	 * @version 1.0.0
	 * @see Tour#score
	 */
	public int[] getScore() {
		return this.score;
	}
	
	/**
	 * @description Get the number of participant
	 * @version 1.0.0
	 * @return int
	 * @see Tour#nbParticipant
	 */
	public int getNbParticipant() {
		return this.nbParticipant;
	}
	
	/**
	 * @description Set a new number of participant
	 * @version 1.0.0
	 * @param int nbParticipant
	 * @see Tour#nbParticipant
	 */
	public void setNbParticipant(int nbParticipant) {
		this.nbParticipant = nbParticipant;
		int[] temp = this.score;
		this.score = new int[nbParticipant];
		int length = this.score.length < temp.length ? this.score.length : temp.length;
		for(int i = 0; i < length; i++) {
			this.score[i] = temp[i];
		}
	}
}
