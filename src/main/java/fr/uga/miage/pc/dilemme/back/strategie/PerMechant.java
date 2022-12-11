package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aur�lien - St�phanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public final class PerMechant extends PerGentille{
	
	public PerMechant() {
		super(StrategieConstHelper.PERMNAME, StrategieConstHelper.PERMDESC, Comportement.TRAHIR, Comportement.COOPERER);
	}
}
