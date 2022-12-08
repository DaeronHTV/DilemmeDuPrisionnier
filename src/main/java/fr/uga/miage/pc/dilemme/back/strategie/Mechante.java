package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aur�lien - St�phanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class Mechante extends Strategie{
	
	public Mechante() { 
		super(StrategieConstHelper.MNNAME, StrategieConstHelper.MDESC); 
		setComportement(Comportement.TRAHIR);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() { numTour++;}
}
