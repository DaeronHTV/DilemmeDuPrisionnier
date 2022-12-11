package fr.uga.miage.pc.dilemme.back.strategie.lastMove;

import fr.uga.miage.pc.dilemme.back.strategie.StrategieConstHelper;
import fr.uga.miage.pc.dilemme.back.strategie.common.StrategieLastMove;
import fr.uga.miage.pc.interfaces.Comportement;

public final class DonnantDonnant extends StrategieLastMove{	
	public DonnantDonnant() {
		super(StrategieConstHelper.DDNAME, StrategieConstHelper.DDDESC, Comportement.COOPERER);
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() { }
	/** {@inheritDoc} */
	@Override
	public void clear() { play = Comportement.COOPERER; }
	/** {@inheritDoc} */
	@Override
	public void setComportement(Comportement play) { }
}
