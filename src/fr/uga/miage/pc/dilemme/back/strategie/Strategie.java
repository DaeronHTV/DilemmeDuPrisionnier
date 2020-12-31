package fr.uga.miage.pc.dilemme.back.strategie;

import java.util.ArrayList;

/**
 * This class constructs a object Strategie which implements the interface IStrategie.
 * A Strategie represents a way of thinking for a certain situation, a certain context.
 * Example : A Strategie "Good" could represent a person who always cooperate.
 * This class was created for a french university project
 * @author Avanzino Aur�lien - Gourdon St�phanie
 * @since 1.0
 * @version 1.5
 * @see IStrategie
 */

public abstract class Strategie implements IStrategie{
	
	private String nom;
	private String description;
	private String play;
	protected int numTour;
	private ArrayList<String> listOppPlay;
	
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
		listOppPlay = new ArrayList<String>();
	}
	
	/** {@inheritDoc} */
	@Override
	public String getStrategyName() { return nom; }
	
	/** {@inheritDoc} */
	@Override
	public void setDescription(String description) { this.description = description; }
	
	/** {@inheritDoc} */
	@Override
	public String getDescription() { return description; }

	/** {@inheritDoc} */
	public abstract void compareComportements();
	
	/** {@inheritDoc} */
	@Override
	public String getComportement() { return play; }
	
	/** {@inheritDoc} */
	@Override
	public void setComportement(String play) { this.play = play; } //Créer une énumération
	
	/** {@inheritDoc} */
	@Override
	public void clear() { numTour = 1; listOppPlay.clear(); }
	
	/**
	 * Return the number of action played by the opponent in the memory of the Strategie
	 * @see IStrategie#sizeOppPlay()
	 * @return int The size of the list
	 */
	public int sizeOppPlay() { return listOppPlay.size(); }
	
	/** {@inheritDoc} */
	@Override
	public String getOppPlay(int index) { return listOppPlay.get(index); }
	
	/** {@inheritDoc} */
	@Override
	public void opponentComportement(String value) { listOppPlay.add(value); }
		
	/** {@inheritDoc} */
	public boolean findValue(String value) { return listOppPlay.contains(value); }
	
	/**
	 * Give the name and a description of the Strategie
	 * @see Object#toString()
	 * @return String Complete description
	 */
	@Override
	public String toString() {
		return getStrategyName()+ " - " + getDescription();
	}

	/*@Override
	@Deprecated
	public int getNumTour(){ return numTour;}

	@Override
	@Deprecated
	public void incrementTour() { numTour++; }*/
}
