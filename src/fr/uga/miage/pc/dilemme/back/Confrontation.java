package fr.uga.miage.pc.dilemme.back;

import fr.uga.miage.pc.dilemme.back.strategie.IStrategie;

/**
 * This class allows to construct a object fight. This object describes all the features of a fight, the opponent, name and others.
 * This class was created for a french university project
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @since 1.0
 * @version 2.0
 */

public class Confrontation {
	private IStrategie strategie1;
	private IStrategie strategie2;
	private int[] scoresFinal;

	/**
	 * This is interface is here to define all the constants associated 
	 * to the class Confrontation
	 * @author Avanzino Aurélien - Stéphanie Gourdon
	 * @implNote The interface give just two constants for now
	 * but it possible to add some more if it's necessary.
	 * We can also extend the interface to add more constants 
	 * @since 3.0
	 * @version 1.0
	 */
	public interface ConfrontationConstants{
		public static final int STRATEGIE_1 = 1;
		public static final int STRATEGIE_2 = 2;
	}
	
	/**
	 * Constructs the fight with the two opponents given in parameter
	 * @param s1 The first opponent
	 * @param s2 The second opponnent
	 * @see IStrategie
	 * @since 1.0
	 */
	public Confrontation(IStrategie s1, IStrategie s2) {
		this.strategie1 = s1;
		this.strategie2 = s2;
		this.scoresFinal = new int[] {0, 0};
	}

	/**
	 * Give the first or the second strategie in function
	 * of the number given in parameter
	 * @implSpec Create in order to have a generic Confrontation
	 * @implNote Replace {@link Confrontation#getStrategie1()} and 
	 * {@link Confrontation#getFinalScoreS2()}
	 * @param numStrategie The number of the Strategie to return
	 * @since 3.0
	 * @see ConfrontationConstants
	 */
	public IStrategie getStrategie(int numStrategie){
		switch(numStrategie){
			case 1: return strategie1;
			case 2: return strategie2;
			default: return null;
		}
	}

	/**
	 * Set the first or second Strategie of the confrontation
	 * @implSpec Create in order to have a generic Confrontation
	 * @implNote Replace {@link Confrontation#setStrategie2(IStrategie)} and 
	 * {@link Confrontation#setStrategie1(IStrategie)}
	 * @param numStrategie The number of the Strategie to return
	 * @since 3.0
	 * @see ConfrontationConstants
	 */
	public void setStrategie(int numStrategie, IStrategie strategie){
		switch(numStrategie){
			case 1: strategie1 = strategie; break;
			case 2: strategie2 = strategie; break;
			default:break;
		}
	}

	/**
	 * Give the final score of the first or second strategie
	 * @implSpec Create in order to have a generic Confrontation
	 * @implNote Replace {@link Confrontation#getFinalScoreS1()} and
	 * {@link Confrontation#getFinalScoreS2()}
	 * @param numStrategie The strategie that we want the final score
	 * @since 3.0
	 * @see ConfrontationConstants
	 */
	public int getFinalScore(int numStrategie){
		int result = -1;
		switch(numStrategie){
			case 1: result = scoresFinal[0]; break;
			case 2: result = scoresFinal[1]; break;
			default: break;
		}
		return result;
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
