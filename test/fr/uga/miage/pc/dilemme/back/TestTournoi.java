package fr.uga.miage.pc.dilemme.back;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.back.Confrontation;
import fr.uga.miage.pc.dilemme.back.strategie.IStrategie;
import fr.uga.miage.pc.dilemme.back.Tournoi;
import fr.uga.miage.pc.dilemme.back.Confrontation.ConfrontationConstants;
import fr.uga.miage.pc.dilemme.exception.EmptyException;
import fr.uga.miage.pc.dilemme.back.strategie.Gentille;
import fr.uga.miage.pc.dilemme.back.strategie.Mechante;

class TestTournoi {

	@Test
	@Order(1)
	@SuppressWarnings("unused")
	void testConstructeur() {
		assertThrows(Exception.class, () -> {
			Tournoi t = new Tournoi(10, new ArrayList<IStrategie>());
		});
	}

	@Test
	@Order(2)
	void testElements() throws Exception {
		Tournoi t;
		t = new Tournoi(10, fillList());
		assertTrue(t.hasMoreElements());
		Confrontation Result = t.nextElement();
		assertEquals("Rencontre N�1\nGentille VS Gentille\nLe score final est de :\nGentille : 30\nGentille : 30\n", Result);
		assertFalse(t.hasMoreElements());
	}
	
	@Test
	@Order(3)
	void TestSetGetConfrontations() throws Exception {
		Tournoi t = new Tournoi(10, this.fillList());
		List<Confrontation> list = t.getConfrontations();
		IStrategie s1 = t.getConfrontation(0).getStrategie(ConfrontationConstants.STRATEGIE_1);
		IStrategie s2 = t.getConfrontation(0).getStrategie(ConfrontationConstants.STRATEGIE_2);
		assertEquals("Gentille", s1.getNom());
		assertEquals("Gentille", s2.getNom());
		assertEquals(1, list.size());
	}
	
	@Test
	@Order(4)
	void TestSetGetStrategie() throws Exception {
		ArrayList<IStrategie> s = new ArrayList<IStrategie>();
		Tournoi t = new Tournoi(10, this.fillList());
		assertTrue(t.getStrategie(0).getNom().equals("Gentille"));
		s.add(new Mechante());
		t.setStrategies(s);
		assertTrue(t.getStrategie(0).getNom().equals("Mechante"));
	}

	@Test
	@Order(5)
	void testToString() throws Exception {
		//TODO Attendre l'envoie du formattage dans l'ApiDilemme pour faire le test (priorité haute)
		Tournoi t = new Tournoi(10, this.fillList());
		String test = t.toString();
		String test2 = "Voici la configuration du tournoi actuelle : \n\nNombre de rencontre : " + t.getConfrontations().size() + "\n" +
				"Nombre de Tours par rencontre : " + t.getNbTours() + "\n\n" + t.strategiesToString() + "\n" 
				+ t.confrontationsToString();
		assertEquals(test2, test);
	}

	@Test
	@Order(6)
	void testNbTours() throws Exception {
		Tournoi t = new Tournoi(10, this.fillList());
		assertEquals(10, t.getNbTours());
		t.setNbTours(30);
		assertEquals(30, t.getNbTours());
	}

	private ArrayList<IStrategie> fillList(){
		ArrayList<IStrategie> s = new ArrayList<IStrategie>();
		s.add(new Gentille());
		return s;
	}

}
