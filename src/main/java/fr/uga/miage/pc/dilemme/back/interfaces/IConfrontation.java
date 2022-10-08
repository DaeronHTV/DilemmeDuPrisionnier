package fr.uga.miage.pc.dilemme.back.interfaces;

import fr.uga.miage.pc.interfaces.IStrategie;

public interface IConfrontation {
	int Numero();
	
	void start(final int nbTours);
	
	IStrategie Strategie(final int numStrategie);
	
	int FinalScore(final int numStrategie);
}
