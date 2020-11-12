package fr.uga.miage.pc.dilemme.strategie;

import java.util.ArrayList;
import fr.uga.miage.pc.dilemme.IStrategie;

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
	private String play;
	private boolean forfait;
	private int numTour;
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
		forfait = false;
		numTour = 1;
		listOppPlay = new ArrayList<String>();
	}
	
	/**
	 * Return the name of the strategie
	 * @see IStrategie#getNom()
	 * @return String Name of strategie
	 */
	@Override
	public String getNom() { return nom; }
	
	/**
	 * Rename the current strategie
	 * @param nom New name
	 * @see IStrategie#setNom(String)
	 */
	@Override
	public void setNom(String nom) { this.nom = nom; }
	
	/**
	 * Change the description of the strategie
	 * @param description New description
	 * @see IStrategie#setDescription(String)
	 */
	@Override
	public void setDescription(String description) { this.description = description; }
	
	/**
	 * Give the description
	 * @see IStrategie#getDescription()
	 * @return String Description of the strategie
	 */
	@Override
	public String getDescription() { return description; }

	/**
	 * Change the situation of forfait for the strategie
	 * @see IStrategie#setForfait(boolean)
	 * @param forfait Statut of forfait
	 */
	@Override
	public void setForfait(boolean forfait) {
		if(this.forfait == false) { this.forfait = forfait; } 
	}
	
	/**
	 * Says if the strategie is forfait or not
	 * @see IStrategie#isForfait()
	 * @return boolean Statut of forfait
	 */
	@Override
	public boolean isForfait() { return forfait; }

	/**
	 * Launch and save the action played by the strategie
	 * @see IStrategie#play()
	 */
	public abstract void play();
	
	/**
	 * Create a clone of the strategie with the same configuration
	 * @see Cloneable#clone()
	 * @see IStrategie#clone()
	 * @return Object Clone of the strategie
	 */
	@Override
	public abstract Object clone();
	
	/**
	 * Give the action played at the current round
	 * @see IStrategie#getPlay()
	 * @return String The action played by the strategie
	 */
	@Override
	public String getPlay() { return play; }
	
	/**
	 * Change the action played by the strategie
	 * @see IStrategie#setPlay(String)
	 * @param play New action played
	 */
	@Override
	public void setPlay(String play) { this.play = play; }
	
	/**
	 * Reset all the attributes of the strategie
	 * @see IStrategie#clear()
	 */
	@Override
	public void clear() { numTour = 1; listOppPlay.clear(); }
	
	/**
	 * Return the number of action played by the opponent in the memory of the Strategie
	 * @see IStrategie#sizeOppPlay()
	 * @return int The size of the list
	 */
	@Override
	public int sizeOppPlay() { return listOppPlay.size(); }
	
	/**
	 * Return the action played by the opponent
	 * @see IStrategie#getOppPlay()
	 * @param index Position in the list
	 * @return String Action played at the index position
	 */
	@Override
	public String getOppPlay(int index) { return listOppPlay.get(index); }
	
	/**
	 * Add the action played by the opponent at the current round
	 * @see IStrategie#setOppPlay(String)
	 * @param value Action played by the opponent
	 */
	@Override
	public void setOppPlay(String value) { listOppPlay.add(value); }
		
	/**
	 * Return True if the value is in the list
	 * @see IStrategie#findValue(String)
	 * @return boolean The value is present or not
	 */
	@Override
	public boolean findValue(String value) { return listOppPlay.contains(value); }
	
	/**
	 * Give the name and a description of the Strategie
	 * @see Object#toString()
	 * @return String Complete description
	 */
	@Override
	public String toString() {
		//String isforfait = this.forfait ? "A déclaré forfait pour ce tournoi !" : "Est toujours dans la course !";
		return getNom() + " - " + getDescription();
	}

	/**
	 * Increment by 1 the number of round played
	 */
	public void incrementNumTour() { numTour += 1; }
	
	/**
	 * Return the number of the current round
	 * @return int Current round of the fight
	 */
	public int getNumTour() { return numTour; }
}
