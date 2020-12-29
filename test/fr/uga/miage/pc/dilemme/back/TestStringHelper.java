package fr.uga.miage.pc.dilemme.back;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import fr.uga.miage.pc.dilemme.back.strategie.Gentille;
import fr.uga.miage.pc.dilemme.back.strategie.IStrategie;

public class TestStringHelper {

    @Test
    @Order(1)
    public void testTournoi() throws NullPointerException, Exception {
        Tournoi t = new Tournoi(20, fillList());
        String actual = StringHelper.tournoi(t);
        String expected = "Voici la configuration du tournoi actuelle :\nNombre de rencontre : " 
		    + t.getConfrontations().size() + "\nNombre de Tours par rencontre : " + t.getNbTours() + "\n" +
		    "\nCe Tournoi opposera les strategies suivantes :\n";
		for(IStrategie strategie: t.getStrategies()) { expected += strategie.toString() + "\n"; }
		expected += "\nVoici les differentes rencontres du tournoi : \n" + t.toString();
        assertEquals(expected, actual);
    }

    //TODO TERMINER LE TEST
    @Test
    @Order(2)
    public void testSumUpTournoi() throws NullPointerException, Exception {
        Tournoi t = new Tournoi(20, fillList());
        String actual = StringHelper.sumUpTournoi(t);
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @Order(3)
    public void testSumUpConfrontation(){
        Confrontation confrontation = new Confrontation(new Gentille(), new Gentille());
        confrontation.start(20);
        String expected = "Rencontre N°1 - Gentille VS Gentille\nLe score final est de : \nGentille : 60\nGentille : 60";
        String actual = StringHelper.sumUpConfrontation(1, confrontation);
        assertEquals(expected, actual);
    }

    private ArrayList<IStrategie> fillList(){
		ArrayList<IStrategie> s = new ArrayList<IStrategie>();
		s.add(new Gentille());
		return s;
	}
}
