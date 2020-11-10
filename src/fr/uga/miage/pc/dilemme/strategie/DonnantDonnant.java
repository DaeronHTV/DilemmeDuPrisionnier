package fr.uga.miage.pc.dilemme.strategie;

public class DonnantDonnant extends Strategie{
	
	public DonnantDonnant() {
		super("Donnant-Donnant", "Je coopere � la premi�re partie, puis je joue ce qu�a joue l�autre � la partie precedente.");
	}

	@Override
	public void play() {
		setPlay(getNumTour() > 1 ? getOppPlay(sizeOppPlay() - 1) : "c");
		incrementNumTour();
	}

	@Override
	public Object clone() { return new DonnantDonnant(); }

}
