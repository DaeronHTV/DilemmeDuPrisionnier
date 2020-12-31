package fr.uga.miage.pc.dilemme.back.strategie;

public class PerMechant extends Strategie{
	
	public PerMechant() {
		super("Periodique-Mechant", "Je joue trahir, trahir, cooperer, trahir, trahir, cooperer, ...");
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		setComportement(numTour % 3 == 0 ? "c" : "t");
		numTour++;
	}	
}
