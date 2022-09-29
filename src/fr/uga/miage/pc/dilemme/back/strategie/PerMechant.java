package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class PerMechant extends Strategie{
	
	public PerMechant() {
		super(StrategieConstHelper.PerMName, StrategieConstHelper.PerMDesc);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		setComportement(numTour % 3 == 0 ? Comportement.COOPERER : Comportement.TRAHIR);
		numTour++;
	}	
}
