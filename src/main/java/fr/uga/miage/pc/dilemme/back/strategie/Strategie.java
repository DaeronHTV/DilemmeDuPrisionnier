package fr.uga.miage.pc.dilemme.back.strategie;

import java.util.ArrayList;

import fr.uga.miage.pc.interfaces.Comportement;
import fr.uga.miage.pc.interfaces.IStrategie;

/**
 * This class constructs a object Strategie which implements the interface IStrategie.
 * A Strategie represents a way of thinking for a certain situation, a certain context.
 * Example : A Strategie "Good" could represent a person who always cooperate.
 * This class was created for a french university project
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @since 1.0
 * @version 1.5
 * @see IStrategie
 */
public abstract class Strategie implements IStrategie{
	private String nom;
	private String description;
	private Comportement play;
	protected int numTour;
	private ArrayList<Comportement> listOppPlay;
	
	/**
	 * Constructs a Strategie with it name and it description
	 * @param nom Name of the strategie
	 * @param description Description of the strategie
	 */
	public Strategie(String nom, String description) {
		play = null;
		this.nom = nom;
		this.description = description;
		numTour = 1;
		listOppPlay = new ArrayList<Comportement>();
	}
	
	/** {@inheritDoc} */
	public String getStrategyName() { return nom; }
	
	/** {@inheritDoc} */
	public void setDescription(String description) { this.description = description; }
	
	/** {@inheritDoc} */
	public String getDescription() { return description; }

	/** {@inheritDoc} */
	public abstract void compareComportements();
	
	/** {@inheritDoc} */
	public Comportement getComportement() { return play; }
	
	/** {@inheritDoc} */
	public void setComportement(Comportement play) { this.play = play; } //CrÃ©er une Ã©numÃ©ration
	
	/** {@inheritDoc} */
	public void clear() { numTour = 1; listOppPlay.clear(); }
	
	/**
	 * Return the number of action played by the opponent in the memory of the Strategie
	 * @return int The size of the list
	 */
	public int sizeOppPlay() { return listOppPlay.size(); }
	
	/**
	 * Return the action played by the opponent
	 * @param index Position in the list
	 * @return String Action played at the index position
	 */
	public Comportement getOppPlay(int index) { return listOppPlay.get(index); }
	
	/** {@inheritDoc} */
	public void opponentComportement(Comportement value) { listOppPlay.add(value); }
		
	/**
	 * Return True if the value is in the list
	 * @param value Forfait status
	 * @return boolean The value is present or not
	 */
	public boolean findValue(Comportement value) { return listOppPlay.contains(value); }
	
	/**
	 * Give the name and a description of the Strategie
	 * @see Object#toString()
	 * @return String Complete description
	 */
	@Override
	public String toString() {
		return getStrategyName()+ " - " + getDescription();
	}

	/****************************DEPRECATED METHOD****************************/
	@Deprecated
	public int getNumTour(){ return numTour;}

	@Deprecated
	public void incrementTour() { numTour++; }
}
