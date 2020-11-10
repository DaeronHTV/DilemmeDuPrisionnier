package fr.uga.miage.pc.dilemme.strategie;

import java.util.ArrayList;
import fr.uga.miage.pc.dilemme.IStrategie;

/**
 * @description This class implement all the features to describe a Strategie
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public abstract class Strategie implements IStrategie{
	
	private String nom;
	private String description;
	private String play;
	private boolean forfait;
	private int numTour;
	private ArrayList<String> listPlay;
	
	/**
	 * @description Construct a Strategie with it name and it description
	 * @param String nomStrategie
	 * @param String description
	 */
	public Strategie(String nom, String description) {
		this.play = null;
		this.nom = nom;
		this.description = description;
		this.forfait = false;
		this.numTour = 1;
		this.listPlay = new ArrayList<String>();
	}
	
	@Override
	public String getNom() { return this.nom; }
	
	@Override
	public void setNom(String nom) { this.nom = nom; }
	
	@Override
	public void setDescription(String description) { this.description = description; }
	
	@Override
	public String getDescription() { return description; }

	@Override
	public void setForfait(boolean forfait) {
		if(this.forfait == false) { this.forfait = forfait; } 
	}
	
	@Override
	public boolean isForfait() { return forfait; }
	
	public abstract void play();
	
	/**
	 * @see Cloneable#clone()
	 */
	@Override
	public abstract Object clone();
	
	@Override
	public String getPlay() { return play; }
	
	@Override
	public void setPlay(String play) { this.play = play; }
	
	@Override
	public void clear() { numTour = 1; listPlay.clear(); }
	
	@Override
	public int sizeOppPlay() { return listPlay.size(); }
	
	@Override
	public String getOppPlay(int index) { return listPlay.get(index); }
	
	@Override
	public void setOppPlay(String value) { listPlay.add(value); }
		
	@Override
	public boolean findValue(String value) { return listPlay.contains(value); }
	
	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		//String isforfait = this.forfait ? "A déclaré forfait pour ce tournoi !" : "Est toujours dans la course !";
		return getNom() + " - " + getDescription();
	}

	/**
	 * @description Increment by 1 the number of tour played
	 */
	public void incrementNumTour() { numTour += 1; }
	
	/**
	 * @description return the number of the current tour
	 * @return int
	 */
	public int getNumTour() { return numTour; }
}
