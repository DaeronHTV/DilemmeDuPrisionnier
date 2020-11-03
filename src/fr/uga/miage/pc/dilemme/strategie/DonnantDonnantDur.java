package fr.uga.miage.pc.dilemme.strategie;

import java.util.ArrayList;

import fr.uga.miage.pc.dilemme.Strategie;

public class DonnantDonnantDur extends Strategie{

	public DonnantDonnantDur() {
		super("Donnant-Donnat Dur", "Je coopere à la premiere partie, puis je coopère sauf si mon adversaire a trahi lors de l’une des deux parties precedentes.");
	}

	@Override
	public String play() {
		String result = "c";
		if(this.getNumTour() != 1) {
			ArrayList<String> test = this.getPlayValue(this.sizeListPlay() - 1, this.sizeListPlay() - 2);
			result = test.get(0).equals("t") || test.get(1).equals("t") ? "t" : "c";
		}
		this.incrementNumTour();
		return result;
	}

	@Override
	public Strategie clone() {
		return new DonnantDonnantDur();
	}
}
