package fr.uga.miage.pc.dilemme.back;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import fr.uga.miage.pc.dilemme.back.Confrontation.ConfrontationConstants;
import fr.uga.miage.pc.dilemme.back.strategie.Gentille;
import fr.uga.miage.pc.dilemme.back.strategie.IStrategie;
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
		assertFalse(t.hasMoreElements());
		assertEquals("Rencontre N°1 - Gentille VS Gentille\nLe score final est de :\nGentille : 30\nGentille : 30", 
		ApiDilemme.confrontationText(1, Result)); //LE TEST NE PASSE PAS ?????
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
		Tournoi t = new Tournoi(10, this.fillList());
		String test = t.toString();
		String result = ""; int i = 0;
		for(Confrontation confrontation: t.getConfrontations()) {
			result += "Rencontre " + i + " : " + confrontation.toString() + "\n";
			i++;
		}
		assertEquals(result, test);
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
