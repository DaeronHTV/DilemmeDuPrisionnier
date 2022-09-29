package fr.uga.miage.pc.dilemme.back.interfaces;

import java.util.Collection;
import java.util.Enumeration;
import fr.uga.miage.pc.interfaces.IStrategie;

public interface ITournoi extends Enumeration<IConfrontation>{
	int NbTours();
	
	int NbChallenger();
	
	Collection<IConfrontation> Confrontations();
	
	IStrategie Challenger(int index);
}
