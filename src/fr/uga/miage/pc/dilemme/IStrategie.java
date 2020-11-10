package fr.uga.miage.pc.dilemme;

public interface IStrategie extends Cloneable {
	
	public Object clone();
	
	/**
	 * @description Return the name of the strategie
	 * @return String
	 */
	public String getNom();
	
	/**
	 * @description Change the name of the Strategie
	 */
	public void setNom(String nom);
	
	/**
	 * @description Return the description of the Strategie
	 * @return String
	 */
	public String getDescription();
	
	/**
	 * @description Change the description of the Strategie
	 */
	public void setDescription(String description);
	
	/**
	 * @description Says if the Strategie declare forfait or not
	 * @return boolean
	 */
	public void setForfait(boolean forfait);
	
	/**
	 * @description Says if the Strategie declare forfait or not
	 * @return boolean
	 */
	public boolean isForfait();
	
	/**
	 * @description Get the action played by the Strategie
	 */
	public void play();
	
	/**
	 * @description Get the action played by the Strategie
	 * @return String
	 */
	public String getPlay();
	
	public void setPlay(String play);
	
	/**
	 * @description Reset all the attributes of the object to the default value
	 */
	public void clear();
	
	/**
	 * @description return the number of action played by the ennemie in the memorie of the Strategie
	 * @see DonnantDonnantDur#play()
	 * @return int
	 */
	public int sizeOppPlay();
	
	/**
	 * @description Return the value at the index position of the list played by the ennemi
	 * @param int index
	 * @return String
	 */
	public String getOppPlay(int index);
	
	/**
	 * @description set the last value played byt the ennemi at the end of the list
	 * @param String value
	 */
	public void setOppPlay(String value);
	
	/**
	 * @description Return true if the value given in parameter exist in the list
	 * @param String value
	 * @return boolean
	 */
	public boolean findValue(String value);
}
