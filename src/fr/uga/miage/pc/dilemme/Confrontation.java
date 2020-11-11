package fr.uga.miage.pc.dilemme;

import fr.uga.miage.pc.dilemme.strategie.Strategie;

/**
 * This class implement all the features to describe a Rencontre
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public class Confrontation {
	private IStrategie strategie1;
	private IStrategie strategie2;
	private int[] scoresFinal;
	
	/**
	 * Construct the Renncontre with the two opponents
	 * @param Strategie s1
	 * @param Strategie s2
	 */
	public Confrontation(IStrategie s1, IStrategie s2) {
		this.strategie1 = s1;
		this.strategie2 = s2;
		this.scoresFinal = new int[] {0, 0};
	}
	
	/**
	 * Return the first opponent of the Rencontre
	 * @return Strategie
	 */
	public IStrategie getStrategie1() { return strategie1; }
	
	/**
	 * Return the second opponent of the Rencontre
	 * @return Strategie
	 */
	public IStrategie getStrategie2() { return strategie2; }
	
	/**
	 * @description Change the first opponent of the Rencontre
	 */
	public void setStrategie1(Strategie strategie1) { this.strategie1 = strategie1; }
	
	/**
	 * Change the second opponent of the Rencontre
	 */
	public void setStrategie2(Strategie strategie2) { this.strategie2 = strategie2; }
	
	/**
	 * Return the final score of the Rencontre for the first Opponent
	 * @return int
	 */
	public int getFinalScoreS1() { return scoresFinal[0]; }
	
	/**
	 * Return the final score of the Rencontre for the second Opponent
	 * @return int
	 */
	public int getFinalScoreS2() { return scoresFinal[1]; }
	
	/**
	 * Return a String which resume the Rencontre
	 * @return String
	 */
	public String scoreFinalToString() {
		return "Le score final est de :\n" + strategie1.getNom() + " : " + scoresFinal[0] + "\n" + strategie2.getNom() + " : " + scoresFinal[1];
	}
	
	/**
	 * Give a brief description of the Rencontre
	 * @return String
	 */
	public String toString() { return strategie1.getNom() + " VS " + strategie2.getNom(); }
	
	/**
	 * Launch the Rencontre
	 * @param int nbTours
	 */
	public void start(int nbTours) {
		strategie1.clear(); strategie2.clear();
		for(int i = 1; i <= nbTours; i++) {
			strategie1.play();
			strategie2.play();
			String ps1 = strategie1.getPlay();
			String ps2 = strategie2.getPlay();
			strategie1.setOppPlay(ps2);
			strategie2.setOppPlay(ps1);
			scoreTour(ps1, ps2);
		}
	}
	
	/**
	 * Give the point for the different opponnet in function of what they played
	 * @param String ps1
	 * @param String ps2
	 */
	private void scoreTour(String ps1, String ps2) {
		if(ps1.equals("c") && ps2.equals("c")) {
			scoresFinal[0] += 3;
			scoresFinal[1] += 3;
		} else if (ps1.equals("t") && ps2.equals("t")) {
			scoresFinal[0]++;
			scoresFinal[1]++;
		} else if (ps1.equals("n") || ps2.equals("n")) {
			scoresFinal[0] += 2;
			scoresFinal[1] += 2;
		} else if ((ps1.equals("t") && ps2.equals("c")) || (ps1.equals("c") && ps2.equals("t"))) {
			if(ps1.equals("t")) { scoresFinal[0] += 5; } 
			else { scoresFinal[1] += 5; }
		}
	}
}
