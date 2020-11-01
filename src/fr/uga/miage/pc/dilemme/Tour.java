package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

import fr.uga.miage.object.Triplet;

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
	
	public char[] joue;
	
	private ArrayList<Triplet<Strategie, Integer, String>> partie;
	
	private Tour lastTour;
	
	/**
	 * @description Constructor of the class
	 * @param int[] score
	 * @version 1.0.0
	 * @see Tour#score
	 */
	public Tour(Strategie s1, Strategie s2) {
		this(s1, s2, null);
	}
	
	public Tour(Strategie s1, Strategie s2, Tour t) {
		this.lastTour = t;
		this.setStrategie(s1);
		this.setStrategie(s2);
	}
	
	public void setStrategie(Strategie s) {
		this.setStrategie(s, 0, "");
	}
	
	public void setStrategie(Strategie s, int i) {
		this.setStrategie(s, i, "");
	}
	
	public void setStrategie(Strategie s, int i, String st) {
		this.partie.add(new Triplet<Strategie, Integer, String>(s, i, st));
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
	public void setScore(int[] score){
			this.score = score;
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
}
