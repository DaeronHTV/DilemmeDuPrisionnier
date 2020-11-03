package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

/**
 * @description This class implement all the features to describe a Tournament
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public class Tournoi {
	
	private int nbTours;
	private int matchNum; 
	private ArrayList<Rencontre> confrontations;
	private ArrayList<Strategie> strategies;
	
	public Tournoi(int nbTours, ArrayList<Strategie> strategies){
		if(strategies.size() >= 1) {
			this.confrontations = new ArrayList<Rencontre>();
			this.nbTours = nbTours;
			this.matchNum = 0;
			this.setStrategies(strategies);
		}
	}
	
	public void start() {
		for(Rencontre r: this.confrontations) {
			System.out.println("Rencontre N°" + (this.matchNum+1));
			System.out.println(r.toString());
			r.start(this.nbTours);
			System.out.println(r.scoreFinalToString()+"\n");
			this.rencontreIncrement();
		}
	}
	
	public ArrayList<Rencontre> getConfrontations() {
		return this.confrontations;
	}
	
	public Rencontre getConfrontation(int index) {
		return this.confrontations.get(index);
	}

	public void setConfrontations(ArrayList<Rencontre> confrontations) {
		this.confrontations = confrontations;
	}
	
	public String confrontationsToString() {
		int i = 0;
		String result = "Voici les differentes rencontres du tournoi : \n";
		for(Rencontre r: this.confrontations) {
			result = result + "Rencontre " + i + " : " + r.getStrategie1().getNomStrategie() + " - " + r.getStrategie2().getNomStrategie() + "\n";
			i++;
		}
		return result;
	}
	
	public ArrayList<Strategie> getStrategies(){
		return this.strategies;
	}
	
	public Strategie getStrategie(int index) {
		return this.strategies.get(index);
	}

	public void setStrategies(ArrayList<Strategie> strategies) {
		this.strategies = strategies;
		this.confrontations.clear();
		for(int j = 0; j < this.strategies.size(); j++) {
			for(int i = j; i < this.strategies.size(); i++) {
				this.confrontations.add(new Rencontre(this.strategies.get(j), this.strategies.get(i)));
			}
		}
	}

	public String strategiesToString() {
		String result = "Ce tournoi opposera les strategies suivantes : \n";
		for(Strategie s: this.strategies) {
			result = result + s.getNomStrategie() + " : " + s.getDescription() + "\n";
		}
		return result;
	}

	/*public int getNbTours() {
		return this.nbTours;
	}*/

	/*public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}*/
	
	public void rencontreIncrement() {
		this.matchNum++;
	}
	
	/*public int getNumRencontre() {
		return this.matchNum;
	}*/
	
	@Override
	public String toString() {
		return "Voici la configuration du tournoi actuelle : \n\nNombre de rencontre : " + this.confrontations.size() + "\n" +
				"Nombre de Tours par rencontre : " + this.nbTours + "\n\n" +this.strategiesToString() + "\n" 
				+ this.confrontationsToString();
	}
	
}
