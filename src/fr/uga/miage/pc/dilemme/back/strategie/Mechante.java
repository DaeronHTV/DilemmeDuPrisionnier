package fr.uga.miage.pc.dilemme.back.strategie;

public class Mechante extends Strategie{
	
	public Mechante() { 
		super("Mechante", "Je trahis toujours"); 
		setComportement("t");
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() { numTour++;}
}
