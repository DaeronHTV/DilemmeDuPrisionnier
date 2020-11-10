package fr.uga.miage.pc.dilemme.strategie;

public class Gentille extends Strategie{
	
	public Gentille() { 
		super("Gentille", "Je coopere toujours."); 
		setPlay("c");
	}

	@Override
	public void play() { this.incrementNumTour(); }
	
	@Override
	public Object clone() { return new Gentille(); }
}
