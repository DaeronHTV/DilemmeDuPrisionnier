package fr.uga.miage.pc.dilemme.back;

import java.util.ArrayList;
import java.util.List;

import fr.uga.miage.pc.dilemme.back.strategie.*;

/**
 * This class is used like an API, it give the possibilty to the front
 * class to call the method of the back-end
 * @author Aurélien Avanzino - Stéphanie Gourdon
 * @implNote This is a static class
 * @implSpec This class is here to respect the design pattern Facade.
 * This class is used to hide and simplify all the calls made by the front
 * @version 1.0
 * @since 3.0
 */
public final class ApiDilemme {
    private static Tournoi instance = null;

    //TODO faire en sorte que l'ApiDilemme ne retourne qu'une seule instance à chaque fois tant qu'elle n'est
    //pas terminé (priorité faible)
    /**
     * 
     * @param strategies List of strategies for the tournament
     * @param nbTours Number of round per Confrontation
     * @return Tournoi - The tournament created
     * @throws NullPointerException if the list of strategies is null
     * @throws Exception If the user doesn't give at least one Strategie
     * @see Tournoi#Tournoi(int, List)
     * @since 3.0
     */
    public static Tournoi createTournoi(List<IStrategie> strategies, int nbTours) throws NullPointerException, Exception {
        instance = new Tournoi(nbTours, strategies);
        return instance;
    }

    /**
     * Return a sum up of the configuration of the tournament in HTML
     * @return String - A sum up of the configuration of the tournament
     * @see StringHelper#tournoi(boolean, Tournoi)
     * @since 3.0
     */
    public static String tournoiHtml(){ return StringHelper.tournoi(true, instance);}

    /**
     * Return a sum up of the configuration of the tournament
     * @return String - A sum up of the configuration of the tournament
     * @see StringHelper#tournoi(boolean, Tournoi)
     * @since 3.0
     */
    public static String tournoiText(){ return StringHelper.tournoi(false, instance);}

    /**
     * Return a sum up of the confrontation given in parameter in HTML
     * @param num The number of the confrontation
     * @param confrontation The confrontation for the sum up
     * @return String - A sum up of the confrontation
     * @see StringHelper#sumUpConfrontation(boolean, int, Confrontation)
     * @since 3.0
     */
    public static String confrontationHtml(int num, Confrontation confrontation){return StringHelper.sumUpConfrontation(true, num, confrontation);}

    /**
     * Return a sum up of the confrontation given in parameter
     * @param num The number of the confrontation
     * @param confrontation The confrontation for the sum up
     * @return String - A sum up of the confrontation
     * @see StringHelper#sumUpConfrontation(boolean, int, Confrontation)
     * @since 3.0
     */
    public static String confrontationText(int num, Confrontation confrontation){return StringHelper.sumUpConfrontation(false, num, confrontation);}

    /**
     * Return a sum up of the score of the tournament in HTML
     * @return String - A sum up of the score of the tournament
     * @see StringHelper#sumUpTournoi(boolean, Tournoi)
     * @since 3.0
     */
    public static String sumUpTournoiHtml(){return StringHelper.sumUpTournoi(true, instance);}

    /**
     * Return a sum up of the score of the tournament
     * @return String - A sum up of the score of the tournament
     * @see StringHelper#sumUpTournoi(boolean, Tournoi)
     * @since 3.0
     */
    public static String sumUpTournoiText(){return StringHelper.sumUpTournoi(false, instance);}

    /**
     * Create a list of the Strategie in function of the choice
     * made by the user
     * @param choices List of choice made by the user
     * @return The list of strategies created
     * @since 3.0
     * @see ApiDilemme#createListStrategie(List)
     * @see Strategie#Strategie(String, String)
     */
    public static List<IStrategie> createListStrategie(int... choices){
        ArrayList<Integer> copyChoices = new ArrayList<Integer>();
        for(Integer choice: choices){ copyChoices.add(choice);}
        return createListStrategie(copyChoices);
    }

    /**
     * Create a list of the Strategie in function of the choice
     * made by the user
     * @param choices List of choice made by the user
     * @return The list of strategies created
     * @since 3.0
     * @see Strategie#Strategie(String, String)
     */
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

    /**
     * Create a new instance of Gentille
     * @return Gentille The gentille strategie
     * @since 3.0
     * @see Gentille#Gentille()
     */
    public static Gentille createGentille(){ return new Gentille(); }

    /**
     * Create a new instance of Mechante
     * @return Mechante The "mechante" strategie
     * @since 3.0
     * @see Mechante#Mechante()
     */
    public static Mechante createMechante(){ return new Mechante(); }

    /**
     * Create a new instance of DonnantDonnant
     * @return DonnantDonnant The "donnant-donnant" strategie
     * @since 3.0
     * @see DonnantDonnant#DonnantDonnant()
     */
    public static DonnantDonnant createDonnantDonnant(){ return new DonnantDonnant(); }

    /**
     * Create a new instance of DonnantDonnantDur
     * @return DonnantDonnantDur The "donnant-donnant dur" strategie
     * @since 3.0
     * @see DonnantDonnantDur#DonnantDonnantDur()
     */
    public static DonnantDonnantDur createDonnantDonnantDur(){ return new DonnantDonnantDur(); }

    /**
     * Create a new instance of Mefiante
     * @return Mefiante The "mefiante" strategie
     * @since 3.0
     * @see Mefiante#Mefiante()
     */
    public static Mefiante createMefiante(){ return new Mefiante(); }

    /**
     * Create a new instance of PerGentille
     * @return PerGentille The "periodique-gentille" strategie
     * @since 3.0
     * @see PerGentille#PerGentille()
     */
    public static PerGentille createPerGentille(){ return new PerGentille(); }

    /**
     * Create a new instance of PerMechant
     * @return PerMechant The "periodique-mechante" strategie
     * @since 3.0
     * @see PerMechant#PerMechant()
     */
    public static PerMechant createPerMechante(){ return new PerMechant(); }

    /**
     * Create a new instance of Rancuniere
     * @return Rancuniere The "rancuniere" strategie
     * @since 3.0
     * @see Rancuniere#Rancuniere()
     */
    public static Rancuniere createRancuniere(){ return new Rancuniere(); }

    /**
     * Create a confrontation between two Strategies
     * @return Confrontation
     * @since 3.0
     * @see Confrontation#Confrontation(IStrategie, IStrategie)
     */
    public static Confrontation createConfrontation(IStrategie s1, IStrategie s2){ return new Confrontation(s1, s2); }
}
