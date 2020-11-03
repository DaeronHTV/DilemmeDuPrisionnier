package fr.uga.miage.pc.dilemme.strategie;

import fr.uga.miage.pc.dilemme.Strategie;

public class Mefiante extends Strategie {

	public Mefiante() {
		super("Mefiante", "Je trahis a la première partie, puis je joue ce qu’a joue l’autre à la partie precedente.");
	}

	@Override
	public String play() {
		String result = this.getNumTour() != 1 ? this.getPlayValue(this.sizeListPlay() - 1) : "t";
		this.incrementNumTour();
		return result;
	}
	
	@Override
	public Strategie clone() {
		return new Mefiante();
	}
}
