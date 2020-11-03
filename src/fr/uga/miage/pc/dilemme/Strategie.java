package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

/**
 * @description This class implement all the features to describe a Strategie
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public abstract class Strategie {
	
	private String nomStrategie;
	private String description;
	private boolean forfait;
	private int numTour;
	private ArrayList<String> listPlay;
	
	public Strategie(String nomStrategie, String description) {
		this.nomStrategie = nomStrategie;
		this.description = description;
		this.forfait = false;
		this.numTour = 1;
		this.listPlay = new ArrayList<String>();
	}
	
	public String getNomStrategie() { return this.nomStrategie; }
	
	public void setNomStrategie(String nomStrategie) { this.nomStrategie = nomStrategie; }
	
	public void setDescription(String description) { this.description = description; }
	
	public String getDescription() { return this.description; }

	public void setForfait(boolean forfait) {
		if(this.forfait == false) { this.forfait = forfait; } 
	}
	
	public boolean isForfait() { return this.forfait; }
	
	public void incrementNumTour() { this.numTour += 1; }
	
	public int getNumTour() { return this.numTour; }
	
	public boolean findValue(String value) { return this.listPlay.contains(value); }
	
	public void setPlay(String value) { this.listPlay.add(value); }
	
	public String getPlayValue(int index) { return this.listPlay.get(index); }
	
	public int sizeListPlay() { return this.listPlay.size(); }
	
	public void clear() { this.numTour = 1; this.listPlay.clear(); }
	
	@Override
	public String toString() {
		String isforfait = this.forfait ? "A déclaré forfait pour ce tournoi !" : "Est toujours dans la course !";
		return "Stratégie : " + this.getNomStrategie() + "\nDescription : " + this.getDescription() + "\n" + isforfait;
	}
	
	public abstract String play();
	
	public abstract Strategie clone();
}
