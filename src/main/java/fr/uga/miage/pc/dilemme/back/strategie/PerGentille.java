package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.dilemme.back.strategie.common.Strategie;
import fr.uga.miage.pc.interfaces.Comportement;

/**
 * 
 * @author Avanzino Aur�lien - St�phanie Gourdon
 * @since 1.0
 * @version 3.0
 */
public class PerGentille extends Strategie{
	protected Comportement majComportement;
	protected Comportement minComportement;

	public PerGentille() {
		super(StrategieConstHelper.PERGNAME, StrategieConstHelper.PERGDESC);
		majComportement = Comportement.COOPERER;
		minComportement = Comportement.TRAHIR;
	}
	
	protected PerGentille(String name, String description, Comportement majComportement, Comportement minComportement) {
		super(name, description);
		this.majComportement = majComportement;
		this.minComportement = minComportement;
	}

	/** {@inheritDoc} */
	@Override
	public void compareComportements() {
		setComportement(numTour % 3 == 0 ? minComportement : majComportement);
		numTour++;
	}
}
