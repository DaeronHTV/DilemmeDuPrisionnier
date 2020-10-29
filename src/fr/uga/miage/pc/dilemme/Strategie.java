package fr.uga.miage.pc.dilemme;

public class Strategie {
	private String nomStrategie;
	private String description;
	
	public Strategie(String nomStrategie, String description) {
		this.nomStrategie = nomStrategie;
		this.description = description;
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
	
	@Override
	public String toString() {
		return "Stratégie : " + this.getNomStrategie() + "\nDescription : " + this.getDescription();
	}
}
