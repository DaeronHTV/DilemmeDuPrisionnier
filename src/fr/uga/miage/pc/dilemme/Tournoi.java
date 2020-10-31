package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

import fr.uga.miage.exception.LengthException;

/**
 * @description This class implement all the features to describe a Tournament
 * @author Avanzino Aur�lien - Gourdon St�phanie
 * @version 1.0
 */

public class Tournoi {
	
	//Ceci est � garder car ce sera donn� par l'utilisateur
	private int nbTours;
	
	//Permet d'indiquer � quel match on est dans le tournoi
	private int matchNum; 
	
	//Pas besoin je pense �tant donn�e qu'on peut r�cup�rer � partir des confrontations
	private ArrayList<int[]> finalScores;
	
	//Ceci est � garder car il nous permettra d'effectuer les diff�rents calculs pour les scores
	private ArrayList<Rencontre> confrontations;
	
	//Je rajoute cette ArrayList car c'est l'utilisateur qui indique es strategies qui jouent
	private ArrayList<Strategie> strategies;
	
	//Ici je pense qu'il faut mieux mettre en param�tre la liste des Strategies
	//Avec cette derni�re on pourra calculer facilement le nombre de rencontre et les cr�er
	//en faisant un genre de foreach
	public Tournoi(int nbTours, ArrayList<Strategie> strategies) throws LengthException{
		//On prend en compte l'exception si jamais on a pas assez de strategies pour effectuer le tournoi
		if(this.strategies.size() <= 1) {
			this.strategies = strategies;
			this.nbTours = nbTours;
			this.matchNum = 0;
			//Permet de calculer le nombre de rencontres en fonction du nombre de strategies
			// On fait (n�-n)/2, on pourrait faire �galement n(n+1)/2 avec n = nbStrategie - 1
			double nbRencontre = (Math.pow(this.strategies.size(), 2) - this.strategies.size())/2;
		} else {
			throw new LengthException("Impossible de lancer un tournoi avec moins de deux Strategies !");
		}
		
		//this.finalScores = new ArrayList<int[]>(); Je mets en commentaire vu que je m'en sert pas pour l'instant
	}
	
	public ArrayList<Rencontre> getConfrontations() {
		return this.confrontations;
	}
	
	public Rencontre getConfrontation(int index) {
		return this.confrontations.get(index);
	}
	
	//Du coup cette foncion serait � enlever si on enl�ve l'arraylist
	/*public ArrayList<int[]> getFinalScores(){
		return this.finalScores;
	}*/
	//M�me chose pour cette fonction
	/*public int[] getFinalScore(int index) {
		return this.finalScores.get(index);
	}*/
	
	public int getNbTours() {
		return this.nbTours;
	}
	
	//Est-ce qu'on ajoute une exception si le tournoi est d�marr� ?
	//Du type : Impossible de changer le nb de tours une fois le tournoi lanc�
	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}
	
	public void setConfrontations(ArrayList<Rencontre> confrontations) {
		this.confrontations = confrontations;
	}
	
	public void setConfrontations(Rencontre[] confrontations) {
		this.confrontations.clear();
		for(Rencontre confrontation: confrontations) {
			this.confrontations.add(confrontation);
		}
	}
	
	//Je ne l'implemente pas encore car je sais pas si je le ferais
	/*public void setConfrontations(ArrayList<Strategie> strategies) {
		
	}
	
	public void setConfrontations(Strategie[] strategies) {
		
	}*/
	
	
	
	//A supprimer si on enl�ve l'arraylist finalScores
	/*public void setFinalScores(ArrayList<int[]> finalScores) {
		this.finalScores = finalScores;
	}*/
	//Meme chose 
	/*public void setFinalScores(int[][] finalScores) {
		this.finalScores.clear();
		for(int[] finalScore: finalScores) {
			this.finalScores.add(finalScore);
		}
	}*/
	
}
