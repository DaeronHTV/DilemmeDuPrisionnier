package fr.uga.miage.pc.dilemme.back;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import fr.uga.miage.pc.core.ClassHelper;
import fr.uga.miage.pc.dilemme.back.interfaces.IConfrontation;
import fr.uga.miage.pc.dilemme.back.interfaces.ITournoi;
import fr.uga.miage.pc.interfaces.IStrategie;

public final class Tournoi implements ITournoi{
	private int nbTours;
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
	public Tournoi(final int nbTours, final List<IStrategie> strategies) throws NullPointerException, Exception {
		if(strategies.isEmpty()) {
			this.nbTours = nbTours;
			setStrategies(strategies);
		} 
		else{
			throw new Exception("EmptyException : An tournament with nobody is impossible\n.at Tournoi(int nbTours, List<IStrategie> strategies) - Tournoi:line.47"); 
		}
	}
	
	public Collection<IConfrontation> confrontations() { return confrontations; }
	
	public IStrategie challenger(final int index) { return strategies.get(index); }
	
	public int nbChallenger() { return strategies.size(); }

	public void setStrategies(final List<IStrategie> strategies) throws Exception{
		this.strategies = strategies;
		confrontations = new ArrayList<>();
		for(int j = 0; j < strategies.size(); j++) {
			for(int i = j; i < strategies.size(); i++) {
				int numConfron = (strategies.size()-1) * j + i;
				if(i == j) {confrontations.add(new Confrontation(challenger(j), ClassHelper.clonebyReflection(challenger(j)), numConfron));}
				else {confrontations.add(new Confrontation(challenger(j), challenger(i), numConfron));}
			}
		}
	}

	public int nbTours() { return nbTours; }
}
