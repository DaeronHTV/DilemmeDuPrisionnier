package fr.uga.miage.pc.dilemme;

/**
 * @description This class implement all the features to describe a Rencontre
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public class Rencontre {
	private Strategie s1;
	private Strategie s2;
	private int[] scoresFinal;
	
	public Rencontre(Strategie s1, Strategie s2) {
		this.s1 = s1;
		this.s2 = s2;
		this.scoresFinal = new int[] {0, 0};
	}
	
	public Strategie getStrategie1() {
		return this.s1;
	}
	
	public Strategie getStrategie2() {
		return this.s2;
	}
	
	public void setStrategie1(Strategie s1) {
		this.s1 = s1;
	}
	
	public void setStrategie(Strategie s2) {
		this.s2 = s2;
	}
	
	public int[] getFinalScores() {
		return this.scoresFinal;
	}
	
	public int getFinalScoreS1() {
		return this.scoresFinal[0];
	}
	
	public int getFinalScoreS2() {
		return this.scoresFinal[1];
	}
	
	public String toString() {
		return "La rencontre oppose " + this.s1.getNomStrategie() + " et " + this.s2.getNomStrategie();
	}
	
	public void lauch(int nbTours) {
		this.s1.clear();
		this.s2.clear();
		for(int i = 0; i < nbTours; i++) {
			String ps1 = this.s1.play();
			String ps2 = this.s2.play();
			this.s1.setPlay(ps2);
			this.s2.setPlay(ps1);
			this.scoreTour(ps1, ps2);
		}
	}
	
	private void scoreTour(String ps1, String ps2) {
		if(ps1.equals("c") && ps2.equals("c")) {
			this.scoresFinal[0] += 3;
			this.scoresFinal[1] += 3;
		} else if (ps1.equals("t") && ps2.equals("t")) {
			this.scoresFinal[0]++;
			this.scoresFinal[1]++;
		} else if (ps1.equals("n") || ps2.equals("n")) {
			this.scoresFinal[0] += 2;
			this.scoresFinal[1] += 2;
		} else if ((ps1.equals("t") && ps2.equals("c")) || (ps1.equals("c") && ps2.equals("t"))) {
			if(ps1.equals("t")) {
				this.scoresFinal[0] += 5;
			} else {
				this.scoresFinal[1] += 5;
			}
		}
	}
}
