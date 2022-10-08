package fr.uga.miage.pc.dilemme.back;

import fr.uga.miage.pc.dilemme.back.interfaces.IConfrontation;
import fr.uga.miage.pc.interfaces.Comportement;
import fr.uga.miage.pc.interfaces.IStrategie;

/**
 * This class allows to construct a object fight. This object describes all the features of a fight, the opponent, name and others.
 * This class was created for a french university project
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @since 1.0
 * @version 2.0
 */
public final class Confrontation implements IConfrontation{
	private int[] scoresFinal = new int[] {0, 0};
	private int numeroConfrontation;
	private IStrategie strategie1;
	private IStrategie strategie2;
	

	/**
	 * This is interface is here to define all the constants associated 
	 * to the class Confrontation
	 * @author Avanzino AurÃ©lien - StÃ©phanie Gourdon
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
	public Confrontation(final IStrategie s1, final IStrategie s2, final int numeroConfrontation) {
		this.strategie1 = s1;
		this.strategie2 = s2;
		this.numeroConfrontation = numeroConfrontation;
	}
	
	public int Numero() { return numeroConfrontation; }

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
	public IStrategie Strategie(final int numStrategie){
		return numStrategie == 1 ? strategie1 : strategie2;
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
	public void setStrategie(final int numStrategie, final IStrategie strategie){
		if(numStrategie == 1) {
			strategie1 = strategie;
			return;
		}
		strategie2 = strategie;
	}

	/**
	 * Give the final score of the first or second strategie
	 * @implSpec Create in order to have a generic Confrontation
	 * @implNote Replace {@link Confrontation#getFinalScoreS1()} and
	 * {@link Confrontation#getFinalScoreS2()}
	 * @param numStrategie The strategie that we want the final score
	 * @since 3.0
	 * @see ConfrontationConstants
	 * @return the final of a strategie
	 */
	public int FinalScore(final int numStrategie){
		return scoresFinal[numStrategie-1];
	}
	
	/**
	 * Give a brief description of the fight
	 * @see IStrategie#getNom()
	 * @return String The versus of this fight
	 */
	public String toString() { return strategie1.getStrategyName() + " VS " + strategie2.getStrategyName(); }
	
	/**
	 * Start the fight between the two opponents
	 * @see IStrategie#clear()
	 * @see IStrategie#setOppPlay(String)
	 * @param nbTours Number of round in this fight
	 */
	public void start(final int nbTours) {
		strategie1.clear(); strategie2.clear();
		for(int i = 1; i <= nbTours; i++) {
			strategie1.compareComportements();
			strategie2.compareComportements();
			Comportement ps1 = strategie1.getComportement();
			Comportement ps2 = strategie2.getComportement();
			strategie1.opponentComportement(ps2);
			strategie2.opponentComportement(ps1);
			scoreTour(ps1, ps2);
		}
	}
	
	/**
	 * Give the point for the different opponnent in function of what they played
	 * @param ps1 Choice played by the first opponent
	 * @param ps2 Choice played by the second opponent
	 * @see Confrontation#start(int)
	 */
	private void scoreTour(final Comportement ps1, final Comportement ps2) {
		if(ps1 == Comportement.COOPERER && ps2 == Comportement.COOPERER) {
			scoresFinal[ConstHelper.ZERO] += 3;
			scoresFinal[ConstHelper.ONE] += 3;
		} else if (ps1 == Comportement.TRAHIR && ps2 == Comportement.TRAHIR) {
			scoresFinal[ConstHelper.ZERO]++;
			scoresFinal[ConstHelper.ONE]++;
		} else if (ps1 == Comportement.RENONCER || ps2 == Comportement.RENONCER) {
			scoresFinal[ConstHelper.ZERO] += 2;
			scoresFinal[ConstHelper.ONE] += 2;
		} else if (((ps1 == Comportement.TRAHIR) && ps2 == Comportement.COOPERER) || (ps1.equals(Comportement.COOPERER) && ps2.equals(Comportement.TRAHIR))) {
			if(ps1 == Comportement.TRAHIR) { scoresFinal[ConstHelper.ZERO] += 5; } 
			else { scoresFinal[ConstHelper.ONE] += 5; }
		}
	}
}
