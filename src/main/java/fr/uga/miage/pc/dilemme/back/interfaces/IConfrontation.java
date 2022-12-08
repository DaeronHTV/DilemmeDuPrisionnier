package fr.uga.miage.pc.dilemme.back.interfaces;

import fr.uga.miage.pc.interfaces.IStrategie;

public interface IConfrontation {
	int numero();
	
	void start(final int nbTours);
	
	IStrategie strategie(final int numStrategie);
	
	int finalScore(final int numStrategie);
}
