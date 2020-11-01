package fr.uga.miage.pc.dilemme;
import java.util.*;

/**
 * @description This class implement all the features to describe a Rencontre
 * @author Avanzino Aurélien - Gourdon Stéphanie
 * @version 1.0
 */

public class Rencontre {
	Strategie s1;
	Strategie s2;
	ArrayList<Tour> rounds;
	
	public Rencontre(Strategie s1, Strategie s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public Strategie getStrategie1() {
		return this.s1;
	}
	
	public Strategie getStrategie2() {
		return this.s2;
	}
	
	public void setStrategie1(Strategie s1) {
		this.s1 = s1;
	}
	
	public void setStrategie(Strategie s2) {
		this.s2 = s2;
	}
	
	public String toString() {
		return "La rencontre oppose " + this.s1.getNomStrategie() + " et " + this.s2.getNomStrategie();
	}
	
	public void lauch() {
		
	}
}
