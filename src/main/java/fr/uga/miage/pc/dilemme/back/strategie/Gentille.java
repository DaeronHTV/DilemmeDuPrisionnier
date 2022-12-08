package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aur�lien - St�phanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class Gentille extends Strategie{
	
	public Gentille() { 
		super(StrategieConstHelper.GNNAME, StrategieConstHelper.GDESC); 
		setComportement(Comportement.COOPERER);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() { numTour++; }
}
