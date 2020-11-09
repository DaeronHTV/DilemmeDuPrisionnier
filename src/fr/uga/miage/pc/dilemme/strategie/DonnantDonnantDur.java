package fr.uga.miage.pc.dilemme.strategie;

import fr.uga.miage.pc.dilemme.Strategie;

public class DonnantDonnantDur extends Strategie{

	public DonnantDonnantDur() {
		super("Donnant-Donnant Dur", "Je coopere à la premiere partie, puis je coopère sauf si mon adversaire a trahi lors de l’une des deux parties precedentes.");
	}

	@Override
	public String play() {
		String result = "c";
		if(this.getNumTour() < 1) {
			String test1 = getPlayValue(sizeListPlay() - 1);
			String test2 = getPlayValue(sizeListPlay() - 2);
			result = test1.equals("t") || test2.equals("t") ? "t" : "c";
		}
		incrementNumTour();
		return result;
	}

	@Override
	public Strategie clone() { return new DonnantDonnantDur(); }
}
