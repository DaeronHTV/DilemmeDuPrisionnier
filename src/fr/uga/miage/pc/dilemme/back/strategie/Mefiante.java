package fr.uga.miage.pc.dilemme.back.strategie;

public class Mefiante extends Strategie {

	public Mefiante() {
		super("Mefiante", "Je trahis a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.");
	}

	/** {@inheritDoc} */
	@Override
	public void play() {
		setPlay(numTour != 1 ? getOppPlay(sizeOppPlay() - 1) : "t");
		numTour++;
	}
}
