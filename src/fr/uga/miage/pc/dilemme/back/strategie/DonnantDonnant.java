package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public final class DonnantDonnant extends Strategie{
	
	public DonnantDonnant() {
		super(StrategieConstHelper.DDName, StrategieConstHelper.DDDesc);
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
