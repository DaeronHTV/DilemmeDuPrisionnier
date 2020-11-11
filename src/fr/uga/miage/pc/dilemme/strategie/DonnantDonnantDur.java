package fr.uga.miage.pc.dilemme.strategie;

public class DonnantDonnantDur extends Strategie{

	public DonnantDonnantDur() {
		super("Donnant-Donnant Dur", "Je coopere à la premiere partie, puis je coopère sauf si mon adversaire a trahi lors de l’une des deux parties precedentes.");
		setPlay("c");
	}

	@Override
	public void play() {
		if(this.getNumTour() > 1) {
			setPlay(getOppPlay(sizeOppPlay() -1).equals("t") || (sizeOppPlay() > 1 && getOppPlay(sizeOppPlay() - 2).equals("t")) ? "t" : "c");
		}
		incrementNumTour();
	}

	@Override
	public Object clone() { return new DonnantDonnantDur(); }
}
