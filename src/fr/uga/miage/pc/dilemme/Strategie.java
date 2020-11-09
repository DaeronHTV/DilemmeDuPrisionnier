package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

/**
 * @description This class implement all the features to describe a Strategie
 * @author Avanzino Aur�lien - Gourdon St�phanie
 * @version 1.0
 */

public abstract class Strategie {
	
	private String nom;
	private String description;
	private boolean forfait;
	private int numTour;
	private ArrayList<String> listPlay;
	
	/**
	 * @description Construct a Strategie with it name and it description
	 * @param String nomStrategie
	 * @param String description
	 */
	public Strategie(String nom, String description) {
		this.nom = nom;
		this.description = description;
		this.forfait = false;
		this.numTour = 1;
		this.listPlay = new ArrayList<String>();
	}
	
	/**
	 * @description Return the name of the strategie
	 * @return String
	 */
	public String getNom() { return this.nom; }
	
	/**
	 * @description Change the name of the Strategie
	 */
	public void setNom(String nom) { this.nom = nom; }
	
	/**
	 * @description Change the description of the Strategie
	 */
	public void setDescription(String description) { this.description = description; }
	
	/**
	 * @description Return the description of the Strategie
	 * @return String
	 */
	public String getDescription() { return description; }

	/**
	 * @description Says if the Strategie declare forfait or not
	 * @return boolean
	 */
	public void setForfait(boolean forfait) {
		if(this.forfait == false) { this.forfait = forfait; } 
	}
	
	/**
	 * @description Says if the Strategie declare forfait or not
	 * @return boolean
	 */
	public boolean isForfait() { return forfait; }
	
	/**
	 * @description Increment by 1 the number of tour played
	 */
	public void incrementNumTour() { numTour += 1; }
	
	/**
	 * @description return the number of the current tour
	 * @return int
	 */
	public int getNumTour() { return numTour; }
	
	/**
	 * @description Return true if the value given in parameter exist in the list
	 * @param String value
	 * @return boolean
	 */
	public boolean findValue(String value) { return listPlay.contains(value); }
	
	/**
	 * @description set the last value played byt the ennemi at the end of the list
	 * @param String value
	 */
	public void setPlay(String value) { listPlay.add(value); }
	
	/**
	 * @description Return the value at the index position of the list played by the ennemi
	 * @param int index
	 * @return String
	 */
	public String getPlayValue(int index) { return listPlay.get(index); }
	
	/**
	 * @description return the number of action played by the ennemie in the memorie of the Strategie
	 * @see DonnantDonnantDur#play()
	 * @return int
	 */
	public int sizeListPlay() { return listPlay.size(); }
	
	/**
	 * @description Reset all the attributes of the object to the default value
	 * @see Confrontation#start(int)
	 */
	public void clear() { numTour = 1; listPlay.clear(); }
	
	/**
	 * @description Shown the name and a brief description of the current Strategie
	 * @see Tournoi#strategiesToString()
	 * @return String
	 */
	@Override
	public String toString() {
		//String isforfait = this.forfait ? "A d�clar� forfait pour ce tournoi !" : "Est toujours dans la course !";
		return getNom() + " - " + getDescription();
	}
	
	/**
	 * @description Get the action played by the Strategie
	 * @see Gentille#play()
	 * @return String
	 */
	public abstract String play();
	
	/**
	 * @description Allows to get an instance of the Strategie which the perfect clone of this last
	 * @see Gentille#clone()
	 */
	public abstract Strategie clone();
}
