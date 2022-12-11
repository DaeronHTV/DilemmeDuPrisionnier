package fr.uga.miage.pc.dilemme.back.strategie.lastMove;

import fr.uga.miage.pc.dilemme.back.strategie.StrategieConstHelper;
import fr.uga.miage.pc.dilemme.back.strategie.common.StrategieLastMove;
import fr.uga.miage.pc.interfaces.Comportement;

public final class Mefiante extends StrategieLastMove {
	public Mefiante() {
		super(StrategieConstHelper.MFNAME, StrategieConstHelper.MFDESC, Comportement.TRAHIR);
	}

	/** {@inheritDoc} */
	@Override
	public void setComportement(Comportement play) { }
	/** {@inheritDoc} */
	@Override
	public void clear() { play = Comportement.TRAHIR; }
	/** {@inheritDoc} */
	@Override
	public void compareComportements() { }
}
