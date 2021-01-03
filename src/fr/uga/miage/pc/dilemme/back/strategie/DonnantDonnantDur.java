package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class DonnantDonnantDur extends Strategie{

	public DonnantDonnantDur() {
		super("Donnant-Donnant Dur", "Je coopere a la premiere partie, puis je coopere sauf si mon adversaire a trahi lors de l'une des deux parties precedentes.");
		setComportement(Comportement.COOPERER);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		if(numTour > 1) {
			setComportement(getOppPlay(sizeOppPlay() -1).equals(Comportement.TRAHIR) || (sizeOppPlay() > 1 && getOppPlay(sizeOppPlay() - 2).equals(Comportement.TRAHIR)) ? Comportement.TRAHIR : Comportement.COOPERER);
		}
		numTour++;
	}
}
