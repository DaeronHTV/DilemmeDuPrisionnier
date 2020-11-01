package fr.uga.miage.pc.dilemme.strategie;
import fr.uga.miage.pc.dilemme.Strategie;

public class Rancuniere extends Strategie{

	public Rancuniere(String nomStrategie, String description) {
		super(nomStrategie, description);
	}

	@Override
	public String play() {
		return this.play("");
	}

	@Override
	public String play(String lastPlay) {
		if(lastPlay.equals("t") && !this.hasBetrayed()) {
			this.setBetrayed(true);
		}
		return this.hasBetrayed() && this.getNumTour() != 1 ? "t" : "c";
	}

}
