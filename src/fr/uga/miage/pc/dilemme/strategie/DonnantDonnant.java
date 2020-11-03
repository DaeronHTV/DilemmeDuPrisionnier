package fr.uga.miage.pc.dilemme.strategie;

import fr.uga.miage.pc.dilemme.Strategie;

public class DonnantDonnant extends Strategie{
	
	public DonnantDonnant() {
		super("Donnant-Donnant", "Je coopere à la première partie, puis je joue ce qu’a joue l’autre à la partie precedente.");
	}

	@Override
	public String play() {
		String result = this.getNumTour() > 1 ? this.getPlayValue(this.sizeListPlay() - 1) : "c";
		this.incrementNumTour();
		return result;
	}

	@Override
	public Strategie clone() {
		return new DonnantDonnant();
	}
}
