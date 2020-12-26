package fr.uga.miage.pc.dilemme.back.strategie;

public class PerGentille extends Strategie{

	public PerGentille() {
		super("Periodique-Gentille", "Je joue cooperer, cooperer, trahir, cooperer, cooperer, trahir, ...");
	}

	/** {@inheritDoc} */
	@Override
	public void play() {
		setPlay(numTour % 3 == 0 ? "t" : "c");
		numTour++;
	}
}
