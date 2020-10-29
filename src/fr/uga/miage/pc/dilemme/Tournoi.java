package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

public class Tournoi {
	private int nbTours;
	private ArrayList<int[]> finalScores;
	private ArrayList<Rencontre> confrontations;
	
	public Tournoi(int nbTours, ArrayList<Rencontre> confrontations) {
		this.confrontations = confrontations;
		this.nbTours = nbTours;
		this.finalScores = new ArrayList<int[]>();
	}
	
	public ArrayList<Rencontre> getConfrontations() {
		return this.confrontations;
	}
	
	public Rencontre getConfrontation(int index) {
		return this.confrontations.get(index);
	}
	
	public ArrayList<int[]> getFinalScores(){
		return this.finalScores;
	}
	
	public int[] getFinalScore(int index) {
		return this.finalScores.get(index);
	}
	
	public int getNbTours() {
		return this.nbTours;
	}
	
	public void setConfrontations(ArrayList<Rencontre> confrontations) {
		this.confrontations = confrontations;
	}
	
	public void setConfrontations(Rencontre[] confrontations) {
		//TODO
	}
	
	public void setFinalScores(ArrayList<int[]> finalScores) {
		this.finalScores = finalScores;
	}
	
	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}
	
}
