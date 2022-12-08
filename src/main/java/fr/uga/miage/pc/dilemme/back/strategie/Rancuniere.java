package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aur�lien - St�phanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class Rancuniere extends Strategie{

	public Rancuniere() {
		super(StrategieConstHelper.RNAME, StrategieConstHelper.RDESC);
		setComportement(Comportement.COOPERER);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		setComportement(findValue(Comportement.TRAHIR) && numTour != 1 ? Comportement.TRAHIR : Comportement.COOPERER);
		numTour++;
	}
	
	/** {@inheritDoc} */
	@Override
	public void clear() {
		super.clear();
		setComportement(Comportement.COOPERER);
	}
}
