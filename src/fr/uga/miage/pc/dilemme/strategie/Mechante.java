package fr.uga.miage.pc.dilemme.strategie;

import fr.uga.miage.pc.dilemme.Strategie;

public class Mechante extends Strategie{
	
	public Mechante() {
		super("Mechante", "Je trahis toujours");
	}

	@Override
	public String play() {
		this.incrementNumTour();
		return "t";
	}
}
