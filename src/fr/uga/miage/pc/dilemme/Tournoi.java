package fr.uga.miage.pc.dilemme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @description This class implement all the features to describe a Tournament
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public class Tournoi {
	
	private int nbTours;
	private String resumeTournoi = "\t|";
	//private boolean skipMenu;
	//private boolean skipTournoi;
	private ArrayList<Rencontre> confrontations;
	private ArrayList<Strategie> strategies;
	
	public Tournoi(int nbTours, ArrayList<Strategie> strategies){
		if(strategies.size() >= 1) {
			//this.skipMenu = false;
			//this.skipTournoi = false;
			this.confrontations = new ArrayList<Rencontre>();
			this.nbTours = nbTours;
			this.setStrategies(strategies);
		}
	}
	
	public void start() {
		int num = 1;
		for(Rencontre r: this.confrontations) {
			//if(!this.skipTournoi) {
				System.out.println("Rencontre N°" + num);
				System.out.println(r.toString()+"\n");
				/*if(!this.skipMenu) {
					this.menu();
				}*/
				r.start(this.nbTours);
				System.out.println(r.scoreFinalToString()+"\n");
				num++;
			//}
		}
		System.out.println("Fin du Tournoi !\nResume du Tournoi : ");
		System.out.println(this.resumeTournoi());
	}
	
	/*public void menu() throws IOException {
		System.out.println("Que souhaitez-vous faire ?");
		System.out.println("1. Demarrez la rencontre");
		System.out.println("2. Lancer toutes les rencontres (skipMenu)");
		System.out.println("3. Déclarer forfait une strategie");
		System.out.println("4. Quittez le tournoi");
		System.out.println("\nVotre choix : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String choix = br.readLine();
		switch(choix) {
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				this.skipTournoi = true;
				break;
		}
		
	}*/
	
	public ArrayList<Rencontre> getConfrontations() { return this.confrontations; }
	
	public Rencontre getConfrontation(int index) { return this.confrontations.get(index); }

	public void setConfrontations(ArrayList<Rencontre> confrontations) { this.confrontations = confrontations; }
	
	/**
	 * @description Return a String which show the list of the Rencontre of the Tournoi
	 * @see Tournoi#confrontations
	 * @see Rencontre#Rencontre(Strategie, Strategie)
	 * @return String
	 */
	public String confrontationsToString() {
		int i = 0;
		String result = "Voici les differentes rencontres du tournoi : \n";
		for(Rencontre r: this.confrontations) {
			result = result + "Rencontre " + i + " : " + r.getStrategie1().getNomStrategie() + " - " + r.getStrategie2().getNomStrategie() + "\n";
			i++;
		}
		return result;
	}
	
	/**
	 * return all the list of the participants
	 * @see Tournoi#strategies
	 * @see Strategie#Strategie(String, String)
	 * @return ArrayList<Strategie>
	 */
	public ArrayList<Strategie> getStrategies(){
		return this.strategies;
	}
	
	/**
	 * @description return the participant a the index position
	 * @param int index
	 * @see Tournoi#strategies
	 * @see Strategie#Strategie(String, String)
	 * @return Strategie
	 */
	public Strategie getStrategie(int index) {
		return this.strategies.get(index);
	}

	/**
	 * @description set a list of Strategie and change the list of Rencontre in function of this last
	 * @param ArrayList<Strategie> strategies
	 * @see Tournoi#strategies
	 * @see Strategie#Strategie(String, String)
	 */
	public void setStrategies(ArrayList<Strategie> strategies) {
		this.strategies = strategies;
		this.confrontations.clear();
		for(int j = 0; j < this.strategies.size(); j++) {
			for(int i = j; i < this.strategies.size(); i++) {
				if(i == j) {
					this.confrontations.add(new Rencontre(this.strategies.get(j), this.strategies.get(j).clone()));
				}else {
					this.confrontations.add(new Rencontre(this.strategies.get(j), this.strategies.get(i)));
				}
			}
			this.resumeTournoi = this.resumeTournoi + this.strategies.get(j).getNomStrategie() + "|";
		}
		this.resumeTournoi = this.resumeTournoi + "TOTAL\t|";
	}
	
	/**
	 * @description return a String which show all the participants of the Tournoi
	 * @see Tournoi#strategies
	 * @return String
	 */
	public String strategiesToString() {
		String result = "Ce tournoi opposera les strategies suivantes : \n";
		for(Strategie s: this.strategies) {
			result = result + s.getNomStrategie() + " : " + s.getDescription() + "\n";
		}
		return result;
	}

	public int getNbTours() {
		return this.nbTours;
	}

	public void setNbTours(int nbTours) { this.nbTours = nbTours; }
	
	/**
	 * @description Return a Tournoi's configuration sum up
	 * @see Tournoi#nbTours
	 * @see Tournoi#strategiesToString()
	 * @return String
	 */
	@Override
	public String toString() {
		return "Voici la configuration du tournoi actuelle : \n\nNombre de rencontre : " + this.confrontations.size() + "\n" +
				"Nombre de Tours par rencontre : " + this.nbTours + "\n\n" +this.strategiesToString() + "\n" 
				+ this.confrontationsToString();
	}
	
	/**
	 * @description Return a string which represent the table with all the scores of the different Rencontre
	 * @see Tournoi#confrontations
	 * @see Tournoi#strategies
	 * @return String
	 */
	public String resumeTournoi() {
		String line = "\n--------------------------------------------------------------------------\n";
		this.resumeTournoi = this.resumeTournoi + line;
		for(Strategie s: this.strategies) {
			int total = 0;
			this.resumeTournoi = s.getNomStrategie().length() <= 15 
					? this.resumeTournoi + s.getNomStrategie() + "|"
					:this.resumeTournoi + s.getNomStrategie() + "|";
			for(Rencontre r: this.confrontations) {
				if(s.equals(r.getStrategie1())) {
					total += r.getFinalScoreS1();
					this.resumeTournoi = this.resumeTournoi + r.getFinalScoreS1() + "\t|";
				}else if(s.equals(r.getStrategie2())){
					total += r.getFinalScoreS2();
					this.resumeTournoi = this.resumeTournoi + r.getFinalScoreS2() + "\t|";
				}
			}
			this.resumeTournoi = this.resumeTournoi + total + "\t|" + line;
		}
		return this.resumeTournoi;
	}
	
	/**
	 * @description Clean the Object and initialize the attributes with the default value
	 * @see Tournoi#strategies
	 * @see Tournoi#confrontations
	 * @see Tournoi#matchNum
	 */
	public void clear() {
		this.strategies = null;
		this.confrontations = null;
		this.nbTours = 0;
	}
}
