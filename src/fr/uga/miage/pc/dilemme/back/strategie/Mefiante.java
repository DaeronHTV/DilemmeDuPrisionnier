package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class Mefiante extends Strategie {

	public Mefiante() {
		super("Mefiante", "Je trahis a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.");
		setComportement(Comportement.TRAHIR);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		setComportement(numTour != 1 ? getOppPlay(sizeOppPlay() - 1) : Comportement.TRAHIR);
		numTour++;
	}
	
	/** {@inheritDoc} */
	@Override
	public void clear() {
		super.clear();
		setComportement(Comportement.TRAHIR);
	}
}
