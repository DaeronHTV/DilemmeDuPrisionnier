package fr.uga.miage.pc.dilemme.back.interfaces;

import java.util.Collection;
import fr.uga.miage.pc.interfaces.IStrategie;

public interface ITournoi {
	int NbTours();
	
	int NbChallenger();
	
	Collection<IConfrontation> Confrontations();
	
	IStrategie Challenger(final int index);
}
