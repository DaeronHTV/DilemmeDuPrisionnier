package fr.uga.miage.pc.interfaces;

/**
 * This interface allows to create object which can represent a players or others in a tournament or during games.
 * This interface was created for a french university project in order to respect the Design Pattern Strategy.
 * @author Avanzino Aur�lien - Gourdon St�phanie
 * @since 2.0
 * @see Cloneable
 */
public interface IStrategie {
	
	/**
	 * Return the name of the strategie
	 * @return String Name of strategie
	 */
	public String getStrategyName();

	
	/**
	 * Give the description
	 * @see IStrategie
	 * @return String Description of the strategie
	 */
	public String getDescription();
	
	/**
	 * Change the description of the strategie
	 * @param description New description
	 */
	public void setDescription(String description);
	
	/**
	 * Launch and save the action played by the strategie
	 */
	public void compareComportements();
	
	/**
	 * Give the action played at the current round
	 * @return String The action played by the strategie
	 */
	public Comportement getComportement();
	
	/**
	 * Change the action played by the strategie
	 * @param play New action played
	 */
	public void setComportement(Comportement play);
	
	/**
	 * Reset all the attributes of the strategie
	 */
	public void clear();
	
	/**
	 * Add the action played by the opponent at the current round
	 * @param value Action played by the opponent
	 */
	public void opponentComportement(Comportement value); //opponentComportement
}
