package fr.uga.miage.pc.dilemme.back;

import java.util.ArrayList;
import java.util.List;
import fr.uga.miage.pc.dilemme.back.strategie.*;

/**
 * 
 * @author Aurélien Avanzino - Stéphanie Gourdon
 * @implSpec This is static final class
 * @version 1.0
 * @since 3.0
 */

public final class ApiDilemme {
    private static Tournoi instance = null;

    //TODO faire en sorte que l'ApiDilemme ne retourne qu'une seule instance à chaque fois tant qu'elle n'est
    //pas terminé (priorité faible)
    public static Tournoi createTournoi(List<IStrategie> strategies, int nbTours) throws Exception {
        instance = new Tournoi(nbTours, strategies);
        return instance;
    }

    public static String tournoiText(){ return StringHelper.tournoi(instance);}

    public static String confrontationText(int num, Confrontation confrontation){return StringHelper.sumUpConfrontation(num, confrontation);}

    public static String sumUpTournoiText(){return StringHelper.sumUpTournoi(instance);}

    public static List<IStrategie> createListStrategie(int... choices){
        ArrayList<Integer> copyChoices = new ArrayList<Integer>();
        for(Integer choice: choices){ copyChoices.add(choice);}
        return createListStrategie(copyChoices);
    }

    public static List<IStrategie> createListStrategie(List<Integer> choices){
        ArrayList<IStrategie> strategies = new ArrayList<IStrategie>();
        for(int choice: choices){
            switch(choice) {
				case 1: strategies.add(createGentille()); break;
				case 2: strategies.add(createMechante()); break;
				case 3: strategies.add(createDonnantDonnant()); break;
				case 4: strategies.add(createDonnantDonnantDur()); break;
				case 5: strategies.add(createMefiante()); break;
				case 6: strategies.add(createRancuniere()); break;
				case 7: strategies.add(createPerGentille()); break;
				case 8: strategies.add(createPerMechante()); break;
				default: break;
			}
        }
        return strategies;
    }

    public static Gentille createGentille(){ return new Gentille(); }

    public static Mechante createMechante(){ return new Mechante(); }

    public static DonnantDonnant createDonnantDonnant(){ return new DonnantDonnant(); }

    public static DonnantDonnantDur createDonnantDonnantDur(){ return new DonnantDonnantDur(); }

    public static Mefiante createMefiante(){ return new Mefiante(); }

    public static PerGentille createPerGentille(){ return new PerGentille(); }

    public static PerMechant createPerMechante(){ return new PerMechant(); }

    public static Rancuniere createRancuniere(){ return new Rancuniere(); }

    public static Confrontation createConfrontation(IStrategie s1, IStrategie s2){ return new Confrontation(s1, s2); }
}
