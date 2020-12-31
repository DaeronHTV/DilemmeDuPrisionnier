package fr.uga.miage.pc.dilemme.back.strategie;

public class Rancuniere extends Strategie{

	public Rancuniere() {
		super("Rancuniere", "Je coopere a la premiere partie, mais des que mon adversaire trahit, je trahis toujours.");
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		setComportement(findValue("t") && numTour != 1 ? "t" : "c");
		numTour++;
	}
}
