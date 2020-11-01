package fr.uga.miage.pc.dilemme;

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
	private boolean betrayed;
	
	public Strategie(String nomStrategie, String description) {
		this.nomStrategie = nomStrategie;
		this.description = description;
		this.forfait = false;
		this.numTour = 1;
		this.betrayed = false;
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
		if(!forfait) {
			this.forfait = !forfait;
		}else {
			throw new ForfaitException("Une strategie déclarant forfait ne peux plus participer au tournoi");
		}
	}
	
	public boolean isForfait() {
		return this.forfait;
	}
	
	public void incrementNumTour() {
		this.numTour = this.numTour++;
	}
	
	public int getNumTour() {
		return this.numTour;
	}
	
	public boolean hasBetrayed() {
		return this.betrayed;
	}
	
	public void setBetrayed(boolean betrayed) {
		this.betrayed = betrayed;
	}
	
	public void clear() {
		//this.forfait = false; Voir avec Steph
		this.numTour = 1;
		this.betrayed = false;
	}
	
	@Override
	public String toString() {
		String isforfait = this.forfait ? "A déclaré forfait pour ce tournoi !" : "Est toujours dans la course !";
		return "Stratégie : " + this.getNomStrategie() + "\nDescription : " + this.getDescription() + "\n" + isforfait;
	}
	
	public abstract String play();
	
	public abstract String play(String lastPlay);
	
	@Override
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
	}
}
