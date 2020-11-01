package fr.uga.miage.pc.dilemme.strategie;
import fr.uga.miage.pc.dilemme.Strategie;

public class Rancuniere extends Strategie{

	public Rancuniere() {
		super("Rancuniere", "Je coopere à la première partie, mais des que mon adversaire trahit, je trahis toujours.");
	}

	@Override
	public String play() {
		String result = this.findValue("t") && this.getNumTour() != 1 ? "t" : "c";
		this.incrementNumTour();
		return result;
	}
}
