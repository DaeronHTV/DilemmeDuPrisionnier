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
		if(strategies.size() >= 1) {
			this.confrontations = new ArrayList<Rencontre>();
			this.nbTours = nbTours;
			this.matchNum = 0;
			this.setStrategies(strategies);
		} else {
			throw new LengthException("Impossible de lancer un tournoi avec moins de deux Strategies !");
		}
		//this.finalScores = new ArrayList<int[]>(); Je mets en commentaire vu que je m'en sert pas pour l'instant
	}
	
	/*Ensemble des fonctions appliqu�s � la liste des confrontations*/
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
		String result = "Voici les diff�rentes recontres du tournoi : \n";
		for(Rencontre r: this.confrontations) {
			result = result + "Rencontre " + i + " : " + r.getStrategie1().getNomStrategie() + " - " + r.getStrategie2().getNomStrategie() + "\n";
			i++;
		}
		return result;
	}
	
	/*Ensemble des fonctions appliqu�es � la liste des strategies*/
	//GETTER
	public ArrayList<Strategie> getStrategies(){
		return this.strategies;
	}
	public Strategie getStrategie(int index) {
		return this.strategies.get(index);
	}
	//SETTER
	public void setStrategies(ArrayList<Strategie> strategies) {
		this.strategies = strategies;
		this.confrontations.clear();
		for(int j = 0; j < this.strategies.size(); j++) {
			for(int i = j; i < this.strategies.size(); i++) {
				this.confrontations.add(new Rencontre(this.strategies.get(j), this.strategies.get(i)));
			}
		}
	}
	public void setStrategies(Strategie[] strategies) {
		this.strategies.clear();
		this.confrontations.clear();
		for(Strategie s: strategies) { this.strategies.add(s); }
		for(int j = 0; j < this.strategies.size(); j++) {
			for(int i = j; i < this.strategies.size(); i++) {
				this.confrontations.add(new Rencontre(this.strategies.get(j), this.strategies.get(i)));
			}
		}
	}
	//TOSTRING
	public String strategiesToString() {
		String result = "Ce tournoi opposera les strategies suivantes : \n";
		for(Strategie s: this.strategies) {
			result = result + s.getNomStrategie() + " : " + s.getDescription() + "\n";
		}
		return result;
	}
	
	/*Ensemble des fonctions appliqu�es au nombre de tours par rencontre*/
	//GETTER
	public int getNbTours() {
		return this.nbTours;
	}
	//SETTER
	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Du coup cette foncion serait � enlever si on enl�ve l'arraylist
	/*public ArrayList<int[]> getFinalScores(){
		return this.finalScores;
	}*/
	//M�me chose pour cette fonction
	/*public int[] getFinalScore(int index) {
		return this.finalScores.get(index);
	}*/
	
	
	
	//Est-ce qu'on ajoute une exception si le tournoi est d�marr� ?
	//Du type : Impossible de changer le nb de tours une fois le tournoi lanc�
	//Dans ce cas l� il faudra rajouter un boolean
	
	
	
	
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
