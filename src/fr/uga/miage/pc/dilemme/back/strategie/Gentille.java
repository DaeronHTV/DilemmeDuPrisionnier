package fr.uga.miage.pc.dilemme.back.strategie;

public class Gentille extends Strategie{
	
	public Gentille() { 
		super("Gentille", "Je coopere toujours."); 
		setComportement("c");
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() { numTour++; }
}
