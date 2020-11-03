package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

import fr.uga.miage.exception.ForfaitException;

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
	
	public String getNomStrategie() {
		return this.nomStrategie;
	}
	
	public void setNomStrategie(String nomStrategie) {
		this.nomStrategie = nomStrategie;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setForfait(boolean forfait) throws ForfaitException{
		if(this.forfait == false) {
			this.forfait = forfait;
		}else {
			throw new ForfaitException("Une strategie déclarant forfait ne peux plus participer au tournoi");
		}
	}
	
	public boolean isForfait() {
		return this.forfait;
	}
	
	public void incrementNumTour() {
		this.numTour = this.numTour + 1;
	}
	
	public int getNumTour() {
		return this.numTour;
	}
	
	public boolean findValue(String value) {
		return this.listPlay.contains(value);
	}
	
	public void setPlay(String value) {
		this.listPlay.add(value);
	}
	
	public String getPlayValue(int index) { return this.listPlay.get(index); }
	
	public ArrayList<String> getPlayValue(int... index) {
		int j = 0;
		ArrayList<String> result = new ArrayList<String>();
		for(int i: index) {
			if(j < this.listPlay.size()) {
				result.add(this.listPlay.get(i));
				j++;
			} else {
				result.add(null);
			}
		}
		return result;
	}
	
	public int sizeListPlay() { return this.listPlay.size(); }
	
	public void clear() {
		//this.forfait = false; Voir avec Steph
		this.numTour = 1;
		this.listPlay.clear();
	}
	
	public abstract String play();
	
	@Override
	public String toString() {
		String isforfait = this.forfait ? "A déclaré forfait pour ce tournoi !" : "Est toujours dans la course !";
		return "Stratégie : " + this.getNomStrategie() + "\nDescription : " + this.getDescription() + "\n" + isforfait;
	}
	
	/*@Override
	public int hashCode() { 
		return this.nomStrategie.hashCode() ^ this.description.hashCode(); 
	}

	@Override //Voir si on rajoute forfait et numtour dans le test
	public boolean equals(Object o) {
		boolean result = false;
		if(o instanceof Strategie) {
			Strategie test = (Strategie) o;
			result = this.nomStrategie.equals(test.getNomStrategie()) && this.description.equals(test.getDescription());
		}
		return result;
	}*/
	
	public abstract Strategie clone();
}
