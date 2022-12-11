package fr.uga.miage.pc.dilemme.back.strategie.common;

import fr.uga.miage.pc.interfaces.Comportement;
import fr.uga.miage.pc.interfaces.IStrategie;

public abstract class StrategieBase implements IStrategie{
	private String name;
	private String description;
	protected Comportement play;
	
	protected StrategieBase(String name, String description, Comportement comportement) {
		this.name = name;
		this.description = description;
		play = comportement;
	}

	/** {@inheritDoc} */
	@Override
	public String getStrategyName() { return name; }

	/** {@inheritDoc} */
	@Override
	public String getDescription() { return description; }

	/** {@inheritDoc} */
	@Override
	public Comportement getComportement() { return play; }

	/** {@inheritDoc} */
	public abstract void setComportement(Comportement play);
	/** {@inheritDoc} */
	public abstract void clear();
	/** {@inheritDoc} */
	public abstract void compareComportements();
	/** {@inheritDoc} */
	public abstract void opponentComportement(Comportement value);

}
