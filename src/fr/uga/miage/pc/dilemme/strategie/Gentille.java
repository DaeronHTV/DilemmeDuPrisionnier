package fr.uga.miage.pc.dilemme.strategie;

import fr.uga.miage.pc.dilemme.Strategie;

public class Gentille extends Strategie{
	
	public Gentille() {
		super("Gentille", "Je coopere toujours.");
	}

	@Override
	public String play() {
		return this.play("");
	}

	@Override
	public String play(String lastPlay) {
		this.incrementNumTour();
		return "c";
	}
}
