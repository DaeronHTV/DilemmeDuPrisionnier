package fr.uga.miage.pc.dilemme.back.strategie.common;

import fr.uga.miage.pc.interfaces.Comportement;

public abstract class StrategieLastMove extends StrategieBase{

	protected StrategieLastMove(String name, String description, Comportement comportement) {
		super(name, description, comportement);
	}
	
	/** {@inheritDoc} */
	@Override
	public void opponentComportement(Comportement play) { this.play = play; }
}
