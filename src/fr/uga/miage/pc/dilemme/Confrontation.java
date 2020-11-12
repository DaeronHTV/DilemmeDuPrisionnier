package fr.uga.miage.pc.dilemme;

/**
 * This class allows to construct a object fight. This object describes all the features of a fight, the opponent, name and others.
 * This class was created for a french university project
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @since 1.0
 * @version 1.1
 */

public class Confrontation {
	private IStrategie strategie1;
	private IStrategie strategie2;
	private int[] scoresFinal;
	
	/**
	 * Constructs the fight with the two opponents given in parameter
	 * @param s1 The first opponent
	 * @param s2 The second opponnent
	 * @see IStrategie
	 */
	public Confrontation(IStrategie s1, IStrategie s2) {
		this.strategie1 = s1;
		this.strategie2 = s2;
		this.scoresFinal = new int[] {0, 0};
	}
	
	/**
	 * Give the object which represents the first opponent
	 * @see IStrategie
	 * @return IStrategie First opponent
	 */
	public IStrategie getStrategie1() { return strategie1; }
	
	/**
	 * Give the object which represents the first opponent
	 * @see IStrategie
	 * @return IStrategie First opponent
	 */
	public IStrategie getStrategie2() { return strategie2; }
	
	/**
	 * Change the first opponent of the fight
	 * @param strategie1 The first opponent
	 * @see IStrategie
	 */
	public void setStrategie1(IStrategie strategie1) { this.strategie1 = strategie1; }
	
	/**
	 * Change the second opponent of the fight
	 * @param strategie2 The second opponent
	 * @see IStrategie
	 */
	public void setStrategie2(IStrategie strategie2) { this.strategie2 = strategie2; }
	
	/**
	 * Return the final score of the fight for the first Opponent
	 * @return int Final score for the first opponent
	 */
	public int getFinalScoreS1() { return scoresFinal[0]; }
	
	/**
	 * Return the final score of the fight for the second Opponent
	 * @return int Final score for the second opponent
	 */
	public int getFinalScoreS2() { return scoresFinal[1]; }
	
	/**
	 * Give the final score of the fight
	 * @see IStrategie#getNom()
	 * @return String Final score of the fight at the end
	 */
	public String scoreFinalToString() {
		return "Le score final est de :\n" + strategie1.getNom() + " : " + scoresFinal[0] + "\n" + strategie2.getNom() + " : " + scoresFinal[1];
	}
	
	/**
	 * Give a brief description of the fight
	 * @see IStrategie#getNom()
	 * @return String The versus of this fight
	 */
	public String toString() { return strategie1.getNom() + " VS " + strategie2.getNom(); }
	
	/**
	 * Start the fight between the two opponents
	 * @see IStrategie#clear()
	 * @see IStrategie#setOppPlay(String)
	 * @param nbTours Number of round in this fight
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
	 * Give the point for the different opponnent in function of what they played
	 * @param ps1 Choice played by the first opponent
	 * @param ps2 Choice played by the second opponent
	 * @see Confrontation#start(int)
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
