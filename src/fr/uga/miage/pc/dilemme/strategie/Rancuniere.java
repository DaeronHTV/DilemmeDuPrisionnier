package fr.uga.miage.pc.dilemme.strategie;

public class Rancuniere extends Strategie{

	public Rancuniere() {
		super("Rancuniere", "Je coopere à la première partie, mais des que mon adversaire trahit, je trahis toujours.");
	}

	@Override
	public void play() {
		setPlay(findValue("t") && getNumTour() != 1 ? "t" : "c");
		incrementNumTour();
	}
	
	@Override
	public Object clone() { return new Rancuniere(); }
}
