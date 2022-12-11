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
public final class Gentille extends StrategieBase{
	
	public Gentille() { 
		super(StrategieConstHelper.GNNAME, StrategieConstHelper.GDESC, Comportement.COOPERER); 
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() { }

	@Override
	public void setComportement(Comportement play) { }

	@Override
	public void clear() { }

	@Override
	public void opponentComportement(Comportement value) { }
}
