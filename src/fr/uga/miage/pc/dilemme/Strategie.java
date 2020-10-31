package fr.uga.miage.pc.dilemme;
import java.util.ArrayList;
import fr.uga.miage.exception.ForfaitException;

/**
 * @description This class implement all the features to describe a Strategie
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public class Strategie {
	
	/**
	 * @description The name of the strategie
	 * @see Strategie#Strategie(String, String)
	 * @see Strategie#getNomStrategie()
	 */
	private String nomStrategie;
	
	/**
	 * @description A text which describe the strategie
	 * @see Strategie#Strategie(String, String)
	 * @see Tournoi#Tournoi(int, ArrayList)
	 */
	//J'ai rajouté ça mais ce n'est une chose obligatoire
	private String description;
	
	/**
	 * @description Say is the strategie declare forfeit or not
	 * @see Strategie#setForfait(boolean)
	 * @see Strategie#isForfait()
	 */
	//Je rajoute ce booléen car l'utilisateur peut décider si une strategie déclare forfait
	private boolean forfait;
	
	/**
	 * @description Construct a new Strategie with the name and description given
	 * @param String nomStrategie
	 * @param String description
	 * @version 1.0.0
	 * @see Strategie#score
	 */
	public Strategie(String nomStrategie, String description) {
		this.nomStrategie = nomStrategie;
		this.description = description;
		this.forfait = false;
	}
	
	/**
	 * @description Get the name of the Strategie
	 * @version 1.0.0
	 * @see Strategie#nomStrategie
	 * @return String
	 */
	public String getNomStrategie() {
		return this.nomStrategie;
	}
	
	/**
	 * @description change te name of the Strategie
	 * @param String nomStrategie
	 * @version 1.0.0
	 * @see Strategie#nomStrategie
	 */
	public void setNomStrategie(String nomStrategie) {
		this.nomStrategie = nomStrategie;
	}
	
	/**
	 * @description change the description of the Strategie
	 * @param String description
	 * @version 1.0.0
	 * @see Strategie#description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @description get the description of the Strategie
	 * @version 1.0.0
	 * @see Strategie#description
	 * @return String
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @description change if the Strategie declare forfeit or not
	 * @param boolean forfait
	 * @throws ForfaitException
	 * @version 1.0.0
	 * @see Strategie#forfait
	 */
	//Est-ce qu'on considère qu'une strategies une fois qu'elle déclare forfait
	//ne plus participer à aucune rencontre du tournoi ou le forfait ne s'applique
	//qu'à la rencontre actuelle ?
	public void setForfait(boolean forfait) throws ForfaitException{
		if(!forfait) {
			this.forfait = !forfait;
		} else {
			throw new ForfaitException("Un forfait est définitif lors du tournoi");
		}
	}
	
	/**
	 * @description Say if the Strategie declared forfeit or not
	 * @version 1.0.0
	 * @see Strategie#forfait
	 * @return boolean
	 */
	public boolean isForfait() {
		return this.forfait;
	}
	
	/**
	 * @description Return a String with all the information about the Strategie
	 * @version 1.0.0
	 * @see Strategie#description
	 * @see Strategie#forfait
	 * @see Strategie#nomStrategie
	 * @return String
	 */
	@Override
	public String toString() {
		String isforfait = this.forfait ? "A déclaré forfait pour ce tournoi !" : "Est toujours dans la course !";
		return "Stratégie : " + this.getNomStrategie() + "\nDescription : " + this.getDescription() + "\n" + isforfait;
	}
}
