package fr.uga.miage.pc.dilemme.strategie;

public class Mechante extends Strategie{
	
	public Mechante() { 
		super("Mechante", "Je trahis toujours"); 
		setPlay("t");
	}

	@Override
	public void play() { this.incrementNumTour(); }
	
	@Override
	public Object clone() { return new Mechante(); }
}
