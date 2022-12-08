package fr.uga.miage.pc.dilemme.back.interfaces;

import java.util.Collection;
import fr.uga.miage.pc.interfaces.IStrategie;

public interface ITournoi {
	int nbTours();
	
	int nbChallenger();
	
	Collection<IConfrontation> confrontations();
	
	IStrategie challenger(final int index);
}
