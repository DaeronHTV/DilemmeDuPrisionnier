package fr.uga.miage.pc.dilemme.strategie;

public class Mefiante extends Strategie {

	public Mefiante() {
		super("Mefiante", "Je trahis a la première partie, puis je joue ce qu’a joue l’autre à la partie precedente.");
	}

	@Override
	public void play() {
		setPlay(getNumTour() != 1 ? getOppPlay(sizeOppPlay() - 1) : "t");
		this.incrementNumTour();
	}
	
	@Override
	public Object clone() { return new Mefiante(); }
}
