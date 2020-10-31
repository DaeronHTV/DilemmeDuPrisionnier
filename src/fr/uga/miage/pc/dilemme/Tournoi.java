package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

import fr.uga.miage.exception.LengthException;

/**
 * @description This class implement all the features to describe a Tournament
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public class Tournoi {
	
	//Ceci est à garder car ce sera donné par l'utilisateur
	private int nbTours;
	
	//Permet d'indiquer à quel match on est dans le tournoi
	private int matchNum; 
	
	//Pas besoin je pense étant donnée qu'on peut récupérer à partir des confrontations
	private ArrayList<int[]> finalScores;
	
	//Ceci est à garder car il nous permettra d'effectuer les différents calculs pour les scores
	private ArrayList<Rencontre> confrontations;
	
	//Je rajoute cette ArrayList car c'est l'utilisateur qui indique es strategies qui jouent
	private ArrayList<Strategie> strategies;
	
	//Ici je pense qu'il faut mieux mettre en paramètre la liste des Strategies
	//Avec cette dernière on pourra calculer facilement le nombre de rencontre et les créer
	//en faisant un genre de foreach
	public Tournoi(int nbTours, ArrayList<Strategie> strategies) throws LengthException{
		//On prend en compte l'exception si jamais on a pas assez de strategies pour effectuer le tournoi
		if(this.strategies.size() <= 1) {
			this.strategies = strategies;
			this.nbTours = nbTours;
			this.matchNum = 0;
			//Permet de calculer le nombre de rencontres en fonction du nombre de strategies
			// On fait (n²-n)/2, on pourrait faire également n(n+1)/2 avec n = nbStrategie - 1
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
	
	//Du coup cette foncion serait à enlever si on enlève l'arraylist
	/*public ArrayList<int[]> getFinalScores(){
		return this.finalScores;
	}*/
	//Même chose pour cette fonction
	/*public int[] getFinalScore(int index) {
		return this.finalScores.get(index);
	}*/
	
	public int getNbTours() {
		return this.nbTours;
	}
	
	//Est-ce qu'on ajoute une exception si le tournoi est démarré ?
	//Du type : Impossible de changer le nb de tours une fois le tournoi lancé
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
	
	
	
	//A supprimer si on enlève l'arraylist finalScores
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
