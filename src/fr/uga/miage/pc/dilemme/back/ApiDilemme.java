package fr.uga.miage.pc.dilemme.back;

import java.util.ArrayList;
import java.util.List;

import fr.uga.miage.pc.dilemme.back.helper.ClassHelper;
import fr.uga.miage.pc.dilemme.back.helper.StringHelper;
import fr.uga.miage.pc.dilemme.back.interfaces.IConfrontation;
import fr.uga.miage.pc.dilemme.back.strategie.*;
import fr.uga.miage.pc.interfaces.IStrategie;

/**
 * This class is used like an API, it give the possibilty to the front class to
 * call the method of the back-end
 * 
 * @author Aurélien Avanzino - Stéphanie Gourdon
 * @implNote This is a static class
 * @implSpec This class is here to respect the design pattern Facade. This class
 *           is used to hide and simplify all the calls made by the front
 * @version 1.0
 * @since 3.0
 */
public final class ApiDilemme {
    private static Tournoi instance = null;

    // TODO faire en sorte que l'ApiDilemme ne retourne qu'une seule instance Ã 
    // chaque fois tant qu'elle n'est
    // pas terminÃ© (prioritÃ© faible)
    /**
     * 
     * @param strategies List of strategies for the tournament
     * @param nbTours    Number of round per Confrontation
     * @return Tournoi - The tournament created
     * @throws NullPointerException if the list of strategies is null
     * @throws Exception            If the user doesn't give at least one Strategie
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
    public static String tournoiHtml() {return StringHelper.tournoi(instance);}

    /**
     * Return a sum up of the confrontation given in parameter in HTML
     * @param num           The number of the confrontation
     * @param confrontation The confrontation for the sum up
     * @return String - A sum up of the confrontation
     * @see StringHelper#sumUpConfrontation(boolean, int, Confrontation)
     * @since 3.0
     */
    public static String confrontationHtml(int num, IConfrontation confrontation) {return StringHelper.sumUpConfrontation(true, confrontation);}

    /**
     * Return a sum up of the score of the tournament in HTML
     * @return String - A sum up of the score of the tournament
     * @see StringHelper#sumUpTournoi(boolean, Tournoi)
     * @since 3.0
     */
    public static String sumUpTournoiHtml() {return StringHelper.sumUpTournoiWithHtml(instance);}

        /**
     * Create a list of the Strategie in function of the choice made by the user
     * @param choices List of choice made by the user
     * @return The list of strategies created
     * @since 3.0
     * @see Strategie#Strategie(String, String)
     */
    public final static List<IStrategie> createListStrategie(List<Class<? extends IStrategie>> choices) {
        ArrayList<IStrategie> strategies = new ArrayList<IStrategie>();
        for (Class<? extends IStrategie> strategie : choices) {
            try {
            	IStrategie objet = ClassHelper.create(strategie);
            	strategies.add(objet);
            }
            catch(Exception e){
            	e.printStackTrace();
            }
        }
        return strategies;
    }
}
