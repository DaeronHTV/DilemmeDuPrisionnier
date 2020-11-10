package fr.uga.miage.pc.dilemme.strategie;

public class PerMechant extends Strategie{
	
	public PerMechant() {
		super("Periodique-Mechant", "Je joue trahir, trahir, coopérer, trahir, trahir, coopérer, ...");
	}

	@Override
	public void play() {
		setPlay(getNumTour() % 3 == 0 ? "c" : "t");
		incrementNumTour();
	}	
	
	@Override
	public Object clone() { return new PerMechant(); }
}
