package fr.uga.miage.pc.dilemme.back.strategie;

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
	public String getNom();
	
	/**
	 * Rename the current object
	 * @param nom New name
	 */
	public void setNom(String nom);
	
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
	public void play();
	
	/**
	 * Give the action played at the current round
	 * @return String The action played by the strategie
	 */
	public String getPlay();
	
	/**
	 * Change the action played by the strategie
	 * @param play New action played
	 */
	public void setPlay(String play);
	
	/**
	 * Reset all the attributes of the strategie
	 */
	public void clear();
	
	/**
	 * Return the action played by the opponent
	 * @param index Position in the list
	 * @return String Action played at the index position
	 */
	public String getOppPlay(int index);
	
	/**
	 * Add the action played by the opponent at the current round
	 * @param value Action played by the opponent
	 */
	public void setOppPlay(String value);
	
	/**
	 * Return True if the value is in the list
	 * @param value Forfait status
	 * @return boolean The value is present or not
	 */
	public boolean findValue(String value);

	/*@Deprecated
	public int getNumTour();
	@Deprecated
	public void incrementTour();*/
}
