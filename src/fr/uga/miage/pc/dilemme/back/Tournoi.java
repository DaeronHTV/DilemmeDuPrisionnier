package fr.uga.miage.pc.dilemme.back;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import fr.uga.miage.pc.core.ClassHelper;
import fr.uga.miage.pc.dilemme.back.interfaces.IConfrontation;
import fr.uga.miage.pc.dilemme.back.interfaces.ITournoi;
import fr.uga.miage.pc.interfaces.IStrategie;

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

public class Tournoi implements ITournoi{
	private int nbTours;
	private Iterator<IConfrontation> iterator;
	private Collection<IConfrontation> confrontations;
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
			this.nbTours = nbTours;
			setStrategies(strategies);
			iterator = confrontations.iterator();
		} 
		else{
			throw new Exception("EmptyException : An tournament with nobody is impossible\n.at Tournoi(int nbTours, List<IStrategie> strategies) - Tournoi:line.47"); 
		}
	}
	
	/**
	 * Allows to know if the tournament still have fight
	 * @see java.util.Enumeration#hasMoreElements()
	 * @return boolean Says if the tournament continues
	 */
	@Override
	public boolean hasMoreElements() { return iterator.hasNext(); }
	
	/**
	 * Launch the next fight of the tournament and give a sum up of this last at the end
	 * @see java.util.Enumaration#nextElement()
	 * @return String The sum up of the fight
	 */
	@Override
	public IConfrontation nextElement() {
		IConfrontation result = iterator.next();
		result.start(nbTours);
		return result;
	}
	
	/**
	 * Give the fight's tournament list
	 * @see Confrontation#Confrontation(IStrategie, IStrategie)
	 * @return ArrayList The list of fight
	 */
	public Collection<IConfrontation> Confrontations() { return confrontations; }
	
	/**
	 * Give the opponent saved at the index position of the list
	 * @param index Position in the list
	 * @see IStrategie
	 * @return IStrategie The opponent number index
	 */
	public final IStrategie Challenger(final int index) { return strategies.get(index); }
	
	public final int NbChallenger() { return strategies.size(); }

	/**
	 * Set the different opponent and theirs fights too
	 * @param strategies Opponent of the tournament
	 * @see Confrontation#Confrontation(IStrategie, IStrategie)
	 * @see IStrategie
	 */
	public void setStrategies(final List<IStrategie> strategies) throws Exception{
		this.strategies = strategies;
		confrontations = new ArrayList<IConfrontation>();
		for(int j = 0; j < strategies.size(); j++) {
			for(int i = j; i < strategies.size(); i++) {
				int numConfron = (strategies.size()-1) * j + i;
				if(i == j) {confrontations.add(new Confrontation(Challenger(j), ClassHelper.clonebyReflection(Challenger(j)), numConfron));}
				else {confrontations.add(new Confrontation(Challenger(j), Challenger(i), numConfron));}
			}
		}
	}

	/**
	 * Return the number of round for each fight in the tournament
	 * @return int The number of round for a fight
	 */
	public final int NbTours() { return nbTours; }
}
