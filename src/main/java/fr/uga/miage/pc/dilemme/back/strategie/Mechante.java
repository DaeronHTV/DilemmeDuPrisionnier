package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aurélien - Stéphanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class Mechante extends Strategie{
	
	public Mechante() { 
		super(StrategieConstHelper.MName, StrategieConstHelper.MDesc); 
		setComportement(Comportement.TRAHIR);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() { numTour++;}
}
