package fr.uga.miage.pc.dilemme.back.strategie;

public class DonnantDonnant extends Strategie{
	
	public DonnantDonnant() {
		super("Donnant-Donnant", "Je coopere a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.");
	}

	/** {@inheritDoc} */
	@Override
	public void play() {
		setPlay(numTour > 1 ? getOppPlay(sizeOppPlay() - 1) : "c");
		numTour++;
	}
}
