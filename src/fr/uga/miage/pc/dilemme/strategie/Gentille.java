package fr.uga.miage.pc.dilemme.strategie;

import fr.uga.miage.pc.dilemme.Strategie;

public class Gentille extends Strategie{
	
	public Gentille() {
		super("Gentille", "Je coopere toujours.");
	}

	@Override
	public String play() {
		this.incrementNumTour();
		return "c";
	}
	
	@Override
	public Strategie clone() {
		return new Gentille();
	}
}
