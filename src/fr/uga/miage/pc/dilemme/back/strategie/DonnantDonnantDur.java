package fr.uga.miage.pc.dilemme.back.strategie;

public class DonnantDonnantDur extends Strategie{

	public DonnantDonnantDur() {
		super("Donnant-Donnant Dur", "Je coopere a la premiere partie, puis je coopere sauf si mon adversaire a trahi lors de l'une des deux parties precedentes.");
		setComportement("c");
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		if(numTour > 1) {
			setComportement(getOppPlay(sizeOppPlay() -1).equals("t") || (sizeOppPlay() > 1 && getOppPlay(sizeOppPlay() - 2).equals("t")) ? "t" : "c");
		}
		numTour++;
	}
}
