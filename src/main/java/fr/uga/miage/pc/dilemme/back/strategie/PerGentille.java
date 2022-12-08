package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aur�lien - St�phanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class PerGentille extends Strategie{

	public PerGentille() {
		super(StrategieConstHelper.PERGNAME, StrategieConstHelper.PERGDESC);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		setComportement(numTour % 3 == 0 ? Comportement.TRAHIR : Comportement.COOPERER);
		numTour++;
	}
}
