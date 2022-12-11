package fr.uga.miage.pc.dilemme.back.strategie.base;

import fr.uga.miage.pc.dilemme.back.strategie.StrategieConstHelper;
import fr.uga.miage.pc.dilemme.back.strategie.common.StrategieBase;
import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aur�lien - St�phanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public final class Mechante extends StrategieBase{
	
	public Mechante() { 
		super(StrategieConstHelper.MNNAME, StrategieConstHelper.MDESC, Comportement.TRAHIR); 
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() { }
	/** {@inheritDoc} */
	@Override
	public void setComportement(Comportement play) {}
	/** {@inheritDoc} */
	@Override
	public void clear() { }
	/** {@inheritDoc} */
	@Override
	public void opponentComportement(Comportement value) { }
}
