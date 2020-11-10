package fr.uga.miage.pc.dilemme.strategie;

public class PerGentille extends Strategie{

	public PerGentille() {
		super("Periodique-Gentille", "Je joue cooperer, cooperer, trahir, cooperer, cooperer, trahir, ...");
	}

	@Override
	public void play() {
		setPlay(getNumTour() % 3 == 0 ? "t" : "c");
		incrementNumTour();
	}
	
	@Override
	public Object clone() { return new PerGentille(); }
}
