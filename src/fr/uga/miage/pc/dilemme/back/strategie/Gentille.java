package fr.uga.miage.pc.dilemme.back.strategie;

public class Gentille extends Strategie{
	
	public Gentille() { 
		super("Gentille", "Je coopere toujours."); 
		setPlay("c");
	}

	/** {@inheritDoc} */
	@Override
	public void play() { numTour++; }
}
