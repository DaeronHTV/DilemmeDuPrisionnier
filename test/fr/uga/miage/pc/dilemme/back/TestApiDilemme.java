package fr.uga.miage.pc.dilemme.back;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import fr.uga.miage.pc.dilemme.back.strategie.Gentille;
import fr.uga.miage.pc.dilemme.back.strategie.IStrategie;

public class TestApiDilemme {

    @Test
    @Order(1)
    public void testCreateTournoi() throws Exception {
        Tournoi t = ApiDilemme.createTournoi(fillList(), 20);
        assertEquals(20, t.getNbTours());
        assertEquals(1, t.getStrategies().size());
    } 

    //TODO FAIRE LE TEST
    @Test
    @Order(2)
    public void testCreateListStrategie1(){
        List<IStrategie> strategies = ApiDilemme.createListStrategie(1,2,3,4,5);
        
    }

    //TODO FAIRE LE TEST
    @Test
    @Order(3)
    public void testCreateListStrategie2(){
        List<IStrategie> strategies = ApiDilemme.createListStrategie(1,2,3,4,5);
        
    }

    //TODO Faire le test
    @Test
    @Order(12)
    public void testCreateConfrontation(){

    }

    @Test
    @Order(4)
    public void testCreateGentille(){
        IStrategie s = ApiDilemme.createGentille();
        assertEquals("Gentille", s.getNom());
    }

    @Test
    @Order(5)
    public void testCreateMechante(){
        IStrategie s = ApiDilemme.createMechante();
        assertEquals("Mechante", s.getNom());
    }

    @Test
    @Order(6)
    public void testCreateDonnantDonnant(){
        IStrategie s = ApiDilemme.createDonnantDonnant();
        assertEquals("Donnant-Donnant", s.getNom());
    }

    @Test
    @Order(7)
    public void testCreateDonnantDonnantDur(){
        IStrategie s = ApiDilemme.createDonnantDonnantDur();
        assertEquals("Donnant-Donnant Dur", s.getNom());
    }

    @Test
    @Order(8)
    public void testCreateMefiante(){
        IStrategie s = ApiDilemme.createMefiante();
        assertEquals("Mefiante", s.getNom());
    }

    @Test
    @Order(9)
    public void testCreatePerGentille(){
        IStrategie s = ApiDilemme.createPerGentille();
        assertEquals("Periodique-Gentille", s.getNom());
    }

    @Test
    @Order(10)
    public void testCreatePerMechante(){
        IStrategie s = ApiDilemme.createPerMechante();
        assertEquals("Periodique-Mechante", s.getNom());
    }

    @Test
    @Order(11)
    public void testCreateRancuniere(){
        IStrategie s = ApiDilemme.createRancuniere();
        assertEquals("Rancuniere", s.getNom());
    }

    private ArrayList<IStrategie> fillList(){
		ArrayList<IStrategie> s = new ArrayList<IStrategie>();
		s.add(new Gentille());
		return s;
	}
}
