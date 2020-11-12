package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * This class allows to construct a object tournament. It can be use in order to launch different fight between two opponent
 * or more which implement IStrategie interface.
 * This class was created for an french university project
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @since 1.0
 * @version 2.0
 * @see Enumeration
 * @see Confrontation
 * @see IStrategie
 */

public class Tournoi implements Enumeration<String>{
	
	private int nbTours;
	private int currentConfrontation;
	private String resumeTournoi;
	private List<Confrontation> confrontations;
	private List<IStrategie> strategies;
	
	/**
	 * Constructs a tournament with the number of round for the fight and a participant's list.
	 * Declare a Exception if the list is null or the size equals zero
	 * @param nbTours The number of round
	 * @param strategies The list of participant
	 * @see Exception#Exception(String)
	 * @see IStrategie
	 * @throws Exception
	 */
	public Tournoi(int nbTours, List<IStrategie> strategies) throws Exception{
		try {
			if(strategies.size() >= 1) {
				this.nbTours = nbTours;
				resumeTournoi = "\t|";
				currentConfrontation = 0;
				setStrategies(strategies);
			} else { 
				throw new Exception("EmptyException : An tournament with nobody is impossible\n.at Tournoi(int nbTours, List<IStrategie> strategies) - Tournoi:line.47"); 
			}
		}catch(NullPointerException npe) { npe.printStackTrace(); }
	}
	
	/**
	 * Allows to know if the tournament still have fight
	 * @see java.util.Enumeration#hasMoreElements()
	 * @return boolean Says if the tournament continues
	 */
	@Override
	public boolean hasMoreElements() { return currentConfrontation < confrontations.size(); }
	
	/**
	 * Launch the next fight of the tournament and give a sum up of this last at the end
	 * @see java.util.Enumeration#nextElement()
	 * @see Tournoi#sumUpConfrontation()
	 * @return String The sum up of the fight
	 */
	@Override
	public String nextElement() {
		getConfrontation(currentConfrontation).start(nbTours);
		String result = sumUpConfrontation();
		currentConfrontation++;
		return result;
	}
	
	
	/**
	 * Give the fight's tournament list
	 * @see Confrontation#Confrontation(IStrategie, IStrategie)
	 * @return ArrayList The list of fight
	 */
	public List<Confrontation> getConfrontations() { return confrontations; }
	
	/**
	 * Get the Confrontation at the index position of the list
	 * @param index Position in the list
	 * @see Confrontation#Confrontation(IStrategie, IStrategie)
	 * @return Confrontation the fight number index
	 */
	public Confrontation getConfrontation(int index) { return confrontations.get(index); }
	
	/**
	 * Return a String which show the list of the Rencontre of the Tournoi
	 * @see Confrontation#Confrontation(IStrategie, IStrategie)
	 * @return String The list of all the fight of the tournament
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
	 * Give all the opponent
	 * @see IStrategie
	 * @see java.util.List
	 * @return List All the opponent of the tournament
	 */
	public List<IStrategie> getStrategies(){ return strategies; }
	
	/**
	 * Give the opponent saved at the index position of the list
	 * @param index Position in the list
	 * @see IStrategie
	 * @return IStrategie The opponent number index
	 */
	public IStrategie getStrategie(int index) { return strategies.get(index); }

	/**
	 * Set the different opponent and theirs fights too
	 * @param strategies Opponent of the tournament
	 * @see Confrontation#Confrontation(IStrategie, IStrategie)
	 * @see IStrategie
	 */
	public void setStrategies(List<IStrategie> strategies) {
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
	 * Return all the opponent of the tournament
	 * @see IStrategie
	 * @return String containing all the opponent during this tournament
	 */
	public String strategiesToString() {
		String result = "Ce tournoi opposera les strategies suivantes : \n";
		for(IStrategie strategie: strategies) { result += strategie.toString() + "\n"; }
		return result;
	}

	/**
	 * Return the number of round for each fight in the tournament
	 * @return int The number of round for a fight
	 */
	public int getNbTours() { return nbTours; }

	/**
	 * Set the number of round for the tournament
	 * @param nbTours The number of round for a fight
	 */
	public void setNbTours(int nbTours) { this.nbTours = nbTours; }
	
	/**
	 * Return the configuration of the tournament
	 * @see Object#toString()
	 * @return String which contains the number of fight and round, the different opponent and fight
	 */
	@Override
	public String toString() {
		return "Voici la configuration du tournoi actuelle : \nNombre de rencontre : " + confrontations.size() + "\n" +
				"Nombre de Tours par rencontre : " + nbTours + "\n" + strategiesToString() + "\n" 
				+ confrontationsToString();
	}
	
	/**
	 * Return a sum up of the current fight
	 * @return String which contains the two opponent and the final score
	 */
	public String sumUpConfrontation() {
		Confrontation confrontation = getConfrontation(currentConfrontation);
		return "Rencontre N°" + (currentConfrontation + 1) + "\n" + confrontation.toString()+"\n" + confrontation.scoreFinalToString()+"\n";
	}
	
	/**
	 * Return the table of scores for the current tournament
	 * @see Confrontation#getFinalScoreS1()
	 * @see Confrontation#getStrategie1()
	 * @return String which shows the score for each fight and the final score for the tournament for each opponent
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
