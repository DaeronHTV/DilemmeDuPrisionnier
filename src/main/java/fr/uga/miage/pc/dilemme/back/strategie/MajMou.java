package fr.uga.miage.pc.dilemme.back.strategie;

import fr.uga.miage.pc.dilemme.back.strategie.common.Strategie;
import fr.uga.miage.pc.interfaces.Comportement;

public class MajMou extends Strategie{
	protected int nbOpponentTrahi;
	protected int nbOpponentRenoncer;
	protected int nbOpponentCooperer;
	protected Comportement defaultComportement;
	
	public MajMou() {
		this(StrategieConstHelper.MAJMOUNAME, StrategieConstHelper.MAJMOUDESC, Comportement.COOPERER);
	}
	
	protected MajMou(String name, String description, Comportement defaultComportement) {
		super(name, description);
		this.defaultComportement = defaultComportement;
		initStrategie();
	}

	@Override
	public void compareComportements() {
		if(numTour == 1 || (nbOpponentTrahi == nbOpponentRenoncer && nbOpponentRenoncer == nbOpponentCooperer)) {
			setComportement(Comportement.COOPERER);
			numTour++;
		}

	}
	
	@Override
	public void opponentComportement(Comportement value) {
		super.opponentComportement(value);
		switch(value) {
			case COOPERER:
				nbOpponentCooperer++;
				break;
			case TRAHIR:
				nbOpponentTrahi++;
				break;
			case RENONCER:
				nbOpponentRenoncer++;
				break;
			default: break;
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public void clear() {
		super.clear();
		initStrategie();
	}
	
	private void initStrategie() {
		setComportement(defaultComportement);
		nbOpponentTrahi = 0;
		nbOpponentRenoncer = 0;
		nbOpponentCooperer = 0;
	}
}
