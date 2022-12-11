package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

public final class Dur extends Rancuniere{
	public Dur() {
		super(StrategieConstHelper.DURNAME, StrategieConstHelper.DURDESC, Comportement.TRAHIR, Comportement.RENONCER);
	}
}
