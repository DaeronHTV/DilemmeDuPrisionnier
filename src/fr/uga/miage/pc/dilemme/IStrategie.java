package fr.uga.miage.pc.dilemme;

/**
 * This interface allows to create object which can represent a players or others in a tournament or during games.
 * This interface was created for a french university project in order to respect the Design Pattern Strategy.
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @since 2.0
 * @see Cloneable
 */

public interface IStrategie extends Cloneable {
	
	/**
	 * Create a clone of the strategie with the same configuration
	 * @see Cloneable#clone()
	 * @return Object Clone of the strategie
	 */
	public Object clone();
	
	/**
	 * Return the name
	 * @return String Name
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
	 * Change the situation of forfait for the strategie
	 * @param forfait Statut of forfait
	 */
	public void setForfait(boolean forfait);
	
	/**
	 * Says if the strategie is forfait or not
	 * @return boolean Statut of forfait
	 */
	public boolean isForfait();
	
	/**
	 * Launch and save the action played by the strategie
	 */
	public void play();
	
	/**
	 * Get the action played by the Strategie
	 * @return String
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
	 * Return the number of action played by the opponent in the memory of the Strategie
	 * @return int The size of the list
	 */
	public int sizeOppPlay();
	
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
}
