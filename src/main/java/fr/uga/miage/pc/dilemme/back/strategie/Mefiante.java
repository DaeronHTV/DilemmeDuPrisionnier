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
		super(StrategieConstHelper.MfName, StrategieConstHelper.MfDesc);
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
