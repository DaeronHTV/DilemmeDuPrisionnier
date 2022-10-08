package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class PerGentille extends Strategie{

	public PerGentille() {
		super(StrategieConstHelper.PerGName, StrategieConstHelper.PerGDesc);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		setComportement(numTour % 3 == 0 ? Comportement.TRAHIR : Comportement.COOPERER);
		numTour++;
	}
}
