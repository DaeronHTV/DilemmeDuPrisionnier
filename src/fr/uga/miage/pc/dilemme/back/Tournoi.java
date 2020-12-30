package fr.uga.miage.pc.dilemme.back;

import fr.uga.miage.pc.dilemme.back.strategie.CloneHelper;
import fr.uga.miage.pc.dilemme.back.strategie.IStrategie;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * This class allows to construct a object tournament. It can be use in order to launch different fight between two opponent
 * or more which implement <code>IStrategie</code> interface.
 * This class was created for an french university project
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @since 1.0
 * @version 2.0
 * @see Enumeration
 * @see Confrontation
 * @see IStrategie
 */

public class Tournoi implements Enumeration<Confrontation>{
	private int nbTours;
	private int currentConfrontation;
	private List<Confrontation> confrontations;
	private List<IStrategie> strategies;
	
	/**
	 * Constructs a tournament with the number of round for the fight and a participant's list.
	 * Declare a Exception if the list is null or the size equals zero
	 * @param nbTours The number of round
	 * @param strategies The list of participant
	 * @see IStrategie
	 * @see List
	 * @throws Exception If the user doesn't give at least one Strategie
	 */
	public Tournoi(int nbTours, List<IStrategie> strategies) throws NullPointerException, Exception {
		if(strategies.size() >= 1) {
			setNbTours(nbTours);
			currentConfrontation = 0;
			setStrategies(strategies);
		} else { 
			throw new Exception("EmptyException : An tournament with nobody is impossible\n.at Tournoi(int nbTours, List<IStrategie> strategies) - Tournoi:line.47"); 
		}
	}
	
	/**
	 * Allows to know if the tournament still have fight
	 * @see java.util.Iterator#hasNext()
	 * @return boolean Says if the tournament continues
	 */
	@Override
	public boolean hasMoreElements() { return currentConfrontation < confrontations.size(); }
	
	/**
	 * Launch the next fight of the tournament and give a sum up of this last at the end
	 * @see java.util.Iterator#next()
	 * @see Tournoi#sumUpConfrontation()
	 * @return String The sum up of the fight
	 */
	@Override
	public Confrontation nextElement() {
		Confrontation result = getConfrontation(currentConfrontation);
		result.start(nbTours);
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
	public void setStrategies(List<IStrategie> strategies) throws Exception{
		this.strategies = strategies;
		confrontations = new ArrayList<Confrontation>();
		for(int j = 0; j < strategies.size(); j++) {
			for(int i = j; i < strategies.size(); i++) {
				if(i == j) {
					confrontations.add(new Confrontation(getStrategie(j), CloneHelper.clone(getStrategie(j))));
				}else {
					confrontations.add(new Confrontation(getStrategie(j), getStrategie(i)));
				}
			}
		}
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
	 * Return the confrontation of the tournament
	 * @see Object#toString()
	 * @return String which contains the number of fight and round, the different opponent and fight
	 */
	@Override
	public String toString() {
		String result = ""; int i = 0;
		for(Confrontation confrontation: confrontations) {
			result += "Rencontre " + i + " : " + confrontation.toString() + "\n";
			i++;
		}
		return result;
	}
}
