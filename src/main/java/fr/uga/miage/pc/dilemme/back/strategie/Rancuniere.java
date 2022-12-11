package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.dilemme.back.strategie.common.Strategie;
import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aur�lien - St�phanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class Rancuniere extends Strategie{
	private boolean isBetrayed;
	private Comportement baseComportement;
	private Comportement whenBetrayedComportement;

	public Rancuniere() {
		this(StrategieConstHelper.RNAME, StrategieConstHelper.RDESC, Comportement.COOPERER, Comportement.TRAHIR);
	}
	
	protected Rancuniere(String name, String description, Comportement baseComportement, Comportement whenBetrayedComportement) {
		super(name, description);
		this.baseComportement = baseComportement;
		this.whenBetrayedComportement = whenBetrayedComportement;
		setComportement(baseComportement);
		isBetrayed = false;
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		if(numTour == 1)
			setComportement(baseComportement);
		else {
			if(!isBetrayed)
				isBetrayed = findValue(Comportement.TRAHIR);
			setComportement(isBetrayed ? whenBetrayedComportement : baseComportement);
		}
		numTour++;
	}
	
	/** {@inheritDoc} */
	@Override
	public void clear() {
		super.clear();
		setComportement(baseComportement);
		isBetrayed = false;
	}
}
