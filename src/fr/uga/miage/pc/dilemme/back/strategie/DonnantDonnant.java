package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class DonnantDonnant extends Strategie{
	
	public DonnantDonnant() {
		super("Donnant-Donnant", "Je coopere a la premiere partie, puis je joue ce qu'a joue l'autre a la partie precedente.");
		setComportement(Comportement.COOPERER);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		setComportement(numTour > 1 ? getOppPlay(sizeOppPlay() - 1) : Comportement.COOPERER);
		numTour++;
	}
	
	/** {@inheritDoc} */
	@Override
	public void clear() {
		super.clear();
		setComportement(Comportement.COOPERER);
	}
}
