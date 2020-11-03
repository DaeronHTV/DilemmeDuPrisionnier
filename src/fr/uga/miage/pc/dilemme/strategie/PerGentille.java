package fr.uga.miage.pc.dilemme.strategie;

import fr.uga.miage.pc.dilemme.Strategie;

public class PerGentille extends Strategie{

	public PerGentille() {
		super("Periodique-Gentille", "Je joue cooperer, cooperer, trahir, cooperer, cooperer, trahir, ...");
	}

	@Override
	public String play() {
		String result = "c";
		if(this.getNumTour() % 3 == 0) {
			result = "t";
		}
		this.incrementNumTour();
		return result;
	}
	
	@Override
	public Strategie clone() {
		return new PerGentille();
	}
}
