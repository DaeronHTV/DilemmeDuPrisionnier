package fr.uga.miage.pc.dilemme.strategie;

import fr.uga.miage.pc.dilemme.Strategie;

public class PerMechant extends Strategie{
	
	public PerMechant() {
		super("Periodique-Mechant", "Je joue trahir, trahir, coopérer, trahir, trahir, coopérer, ...");
	}

	@Override
	public String play() {
		String result = "t";
		if(this.getNumTour() % 3 == 0) {
			result = "c";
		}
		this.incrementNumTour();
		return result;
	}	
	
	@Override
	public Strategie clone() { return new PerMechant(); }
}
