package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import fr.uga.miage.pc.dilemme.strategie.Strategie;

/**
 * @description This class implement all the features to describe a Tournament
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public class Tournoi implements Enumeration<String>{
	
	private int nbTours;
	private int currentConfrontation;
	private String resumeTournoi;
	private List<Confrontation> confrontations;
	private List<? extends IStrategie> strategies;
	
	/**
	 * Constructor of a Tournoi which takes the number of tour for a Confrontation and a list of participant
	 * @param int nbTours
	 * @param ArrayList strategies
	 * @throws Exception 
	 */
	public Tournoi(int nbTours, List<? extends IStrategie> strategies) throws Exception{
		try {
			if(strategies.size() >= 1) {
				this.nbTours = nbTours;
				resumeTournoi = "\t|";
				currentConfrontation = 0;
				setStrategies(strategies);
			} else { throw new Exception("EmptyException : An tournament with nobody is impossible - Tournoi:line.47"); }
		}catch(NullPointerException npe) { npe.printStackTrace(); }
	}
	
	/**
	 * @see Enumeration#hasMoreElements()
	 */
	@Override
	public boolean hasMoreElements() { return currentConfrontation < confrontations.size(); }
	
	/**
	 * @see Enumeration#nextElement()
	 */
	@Override
	public String nextElement() {
		getConfrontation(currentConfrontation).start(nbTours);
		String result = sumUpConfrontation();
		currentConfrontation++;
		return result;
	}
	
	
	/**
	 * @description return the list of all the Rencontre of the Tournoi
	 * @see Tournoi#confrontations
	 * @return ArrayList
	 */
	public List<Confrontation> getConfrontations() { return confrontations; }
	
	/**
	 * @description Get the Rencontre at the index position of the list
	 * @param int index
	 * @see Tournoi#confrontations
	 * @return Rencontre
	 */
	public Confrontation getConfrontation(int index) { return confrontations.get(index); }
	
	/**
	 * @description Return a String which show the list of the Rencontre of the Tournoi
	 * @see Tournoi#confrontations
	 * @see Confrontation#Rencontre(Strategie, Strategie)
	 * @return String
	 */
	public String confrontationsToString() {
		int i = 0;
		String result = "Voici les differentes rencontres du tournoi : \n";
		for(Confrontation confrontation: confrontations) {
			result += "Rencontre " + i + " : " + confrontation.toString() + "\n";
			i++;
		}
		return result;
	}
	
	/**
	 * return all the list of the participants
	 * @see Tournoi#strategies
	 * @see Strategie#Strategie(String, String)
	 * @return ArrayList
	 */
	public List<? extends IStrategie> getStrategies(){ return strategies; }
	
	/**
	 * @description return the participant a the index position
	 * @param int index
	 * @see Tournoi#strategies
	 * @see Strategie#Strategie(String, String)
	 * @return Strategie
	 */
	public IStrategie getStrategie(int index) { return strategies.get(index); }

	/**
	 * @description set a list of Strategie and change the list of Rencontre in function of this last
	 * @param ArrayList<Strategie> strategies
	 * @see Tournoi#strategies
	 * @see Strategie#Strategie(String, String)
	 */
	public void setStrategies(List<? extends IStrategie> strategies) {
		this.strategies = strategies;
		confrontations = new ArrayList<Confrontation>();
		for(int j = 0; j < strategies.size(); j++) {
			for(int i = j; i < strategies.size(); i++) {
				if(i == j) {
					confrontations.add(new Confrontation(getStrategie(j), (IStrategie)getStrategie(j).clone()));
				}else {
					confrontations.add(new Confrontation(getStrategie(j), getStrategie(i)));
				}
			}
			resumeTournoi += getStrategie(j).getNom() + "|";
		}
		resumeTournoi += "TOTAL\t|";
	}
	
	/**
	 * @description return a String which show all the participants of the Tournoi
	 * @see Tournoi#strategies
	 * @return String
	 */
	public String strategiesToString() {
		String result = "Ce tournoi opposera les strategies suivantes : \n";
		for(IStrategie strategie: strategies) { result += strategie.toString() + "\n"; }
		return result;
	}

	/**
	 * @description Return the number of tours for each Rencontre in the Tournoi
	 * @see Tournoi#nbTours
	 * @return int
	 */
	public int getNbTours() { return nbTours; }

	/**
	 * @description set the number of Tours for each Rencontre in the Tournoi
	 * @see Tournoi#nbTours
	 * @param int nbTours
	 */
	public void setNbTours(int nbTours) { this.nbTours = nbTours; }
	
	/**
	 * @description Return a Tournoi's configuration sum up
	 * @see Tournoi#nbTours
	 * @see Tournoi#strategiesToString()
	 * @return String
	 */
	@Override
	public String toString() {
		return "Voici la configuration du tournoi actuelle : \n\nNombre de rencontre : " + confrontations.size() + "\n" +
				"Nombre de Tours par rencontre : " + nbTours + "\n\n" + strategiesToString() + "\n" 
				+ confrontationsToString();
	}
	
	public String sumUpConfrontation() {
		Confrontation confrontation = getConfrontation(currentConfrontation);
		return "Rencontre N°" + (currentConfrontation + 1) + "\n" + confrontation.toString()+"\n" + confrontation.scoreFinalToString()+"\n";
	}
	
	/**
	 * @description Return a string which represent the table with all the scores of the different Rencontre
	 * @see Tournoi#confrontations
	 * @see Tournoi#strategies
	 * @return String
	 */
	public String sumUpTournoi() {
		String line = "\n--------------------------------------------------------------------------\n";
		resumeTournoi += line;
		for(IStrategie strategie: strategies) {
			int total = 0;
			resumeTournoi += strategie.getNom() + "|";
			for(Confrontation confrontation: confrontations) {
				if(strategie.equals(confrontation.getStrategie1())) {
					total += confrontation.getFinalScoreS1();
					resumeTournoi += confrontation.getFinalScoreS1() + "\t|";
				}else if(strategie.equals(confrontation.getStrategie2())){
					total += confrontation.getFinalScoreS2();
					resumeTournoi += confrontation.getFinalScoreS2() + "\t|";
				}
			}
			resumeTournoi += total + "\t|" + line;
		}
		return resumeTournoi;
	}
}
