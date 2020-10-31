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
		if(strategies.size() > 1) {
			this.strategies = strategies;
			this.confrontations = new ArrayList<Rencontre>();
			this.nbTours = nbTours;
			this.matchNum = 0;
			//Permet de calculer le nombre de rencontres en fonction du nombre de strategies
			// On fait n(n+1)/2 avec n = nbStrategie
			double nbRencontre = (this.strategies.size()*(this.strategies.size()+1))/2;
			for(int j = 0; j < this.strategies.size(); j++) {
				for(int i = j; i < this.strategies.size(); i++) {
					this.confrontations.add(new Rencontre(this.strategies.get(j), this.strategies.get(i)));
				}
			}
		} else {
			throw new LengthException("Impossible de lancer un tournoi avec moins de deux Strategies !");
		}
		//this.finalScores = new ArrayList<int[]>(); Je mets en commentaire vu que je m'en sert pas pour l'instant
	}
	
	/*Ensemble des fonctions appliqués à la liste des confrontations*/
	//GETTER
	public ArrayList<Rencontre> getConfrontations() {
		return this.confrontations;
	}
	
	public Rencontre getConfrontation(int index) {
		return this.confrontations.get(index);
	}
	//SETTER
	public void setConfrontations(ArrayList<Rencontre> confrontations) {
		this.confrontations = confrontations;
	}
	
	public void setConfrontations(Rencontre[] confrontations) {
		this.confrontations.clear();
		for(Rencontre confrontation: confrontations) {
			this.confrontations.add(confrontation);
		}
	}
	//TOSTRING
	public String confrontationsToString() {
		int i = 0;
		String result = "Voici les différentes recontres du tournoi : \n";
		for(Rencontre r: this.confrontations) {
			result = result + "Rencontre " + i + " : " + r.getStrategie1().getNomStrategie() + " - " + r.getStrategie2().getNomStrategie() + "\n";
			i++;
		}
		return result;
	}
	
	/*Ensemble des fonctions appliquées à la liste des strategies*/
	//GETTER
	
	//SETTER
	
	//TOSTRING
	public String strategiesToString() {
		String result = "Ce tournoi opposera les strategies suivantes : \n";
		for(Strategie s: this.strategies) {
			result = result + s.getNomStrategie() + " : " + s.getDescription() + "\n";
		}
		return result;
	}
	
	/*Ensemble des fonctions appliquées au nombre de tours par rencontre*/
	//GETTER
	public int getNbTours() {
		return this.nbTours;
	}
	//SETTER
	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Du coup cette foncion serait à enlever si on enlève l'arraylist
	/*public ArrayList<int[]> getFinalScores(){
		return this.finalScores;
	}*/
	//Même chose pour cette fonction
	/*public int[] getFinalScore(int index) {
		return this.finalScores.get(index);
	}*/
	
	
	
	//Est-ce qu'on ajoute une exception si le tournoi est démarré ?
	//Du type : Impossible de changer le nb de tours une fois le tournoi lancé
	//Dans ce cas là il faudra rajouter un boolean
	
	
	
	
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
