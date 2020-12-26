package fr.uga.miage.pc.dilemme.back.strategie;

public class DonnantDonnantDur extends Strategie{

	public DonnantDonnantDur() {
		super("Donnant-Donnant Dur", "Je coopere a la premiere partie, puis je coopere sauf si mon adversaire a trahi lors de l'une des deux parties precedentes.");
		setPlay("c");
	}

	/** {@inheritDoc} */
	@Override
	public void play() {
		if(numTour > 1) {
			setPlay(getOppPlay(sizeOppPlay() -1).equals("t") || (sizeOppPlay() > 1 && getOppPlay(sizeOppPlay() - 2).equals("t")) ? "t" : "c");
		}
		numTour++;
	}
}
