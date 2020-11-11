package test.fr.uga.miage.pc.dilemme;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.Confrontation;
import fr.uga.miage.pc.dilemme.IStrategie;
import fr.uga.miage.pc.dilemme.Tournoi;
import fr.uga.miage.pc.dilemme.strategie.Gentille;
import fr.uga.miage.pc.dilemme.strategie.Mechante;

class TestTournoi {
	
	@Test
	void testConstructeur() {
		assertThrows(Exception.class, () -> {
			Tournoi t = new Tournoi(10, new ArrayList<IStrategie>());
		});
	}
	
	@Test
	void testElements() throws Exception {
		Tournoi t;
		t = new Tournoi(10, fillList());
		assertTrue(t.hasMoreElements());
		String Result = t.nextElement();
		assertEquals("Rencontre N°1\nGentille VS Gentille\nLe score final est de :\nGentille : 30\nGentille : 30\n", Result);
		assertFalse(t.hasMoreElements());
	}
	
	@Test
	void TestSetGetConfrontations() throws Exception {
		Tournoi t = new Tournoi(10, this.fillList());
		List<Confrontation> list = t.getConfrontations();
		IStrategie s1 = t.getConfrontation(0).getStrategie1();
		IStrategie s2 = t.getConfrontation(0).getStrategie2();
		assertEquals("Gentille", s1.getNom());
		assertEquals("Gentille", s2.getNom());
		assertEquals(1, list.size());
	}
	
	@Test
	void TestSetGetStrategie() throws Exception {
		ArrayList<IStrategie> s = new ArrayList<IStrategie>();
		Tournoi t = new Tournoi(10, this.fillList());
		assertTrue(t.getStrategie(0).getNom().equals("Gentille"));
		s.add(new Mechante());
		t.setStrategies(s);
		assertTrue(t.getStrategie(0).getNom().equals("Mechante"));
	}

	@Test
	void testToString() throws Exception {
		Tournoi t = new Tournoi(10, this.fillList());
		String test = t.toString();
		String test2 = "Voici la configuration du tournoi actuelle : \n\nNombre de rencontre : " + t.getConfrontations().size() + "\n" +
				"Nombre de Tours par rencontre : " + t.getNbTours() + "\n\n" + t.strategiesToString() + "\n" 
				+ t.confrontationsToString();
	}
	
	/*@Test
	void testresumeTournoi() {
		Tournoi t = new Tournoi(10, this.fillList());
		t.start();
		String result = t.resumeTournoi();
		String test = "Resume du Tournoi : \r\n"
		+ "	|Gentille|TOTAL	|\r\n"
		+ "--------------------------------------------------------------------------\r\n"
		+ "Gentille|30	|30	|\r\n"
		+ "--------------------------------------------------------------------------";
		assertEquals(test, result);
	}*/
	
	@Test
	void testConfrontationsToString() throws Exception {
		Gentille g = new Gentille();
		Tournoi t = new Tournoi(10, this.fillList());
		assertEquals("Voici les differentes rencontres du tournoi : \nRencontre 0 : " + g.getNom() + " VS " + g.getNom() + "\n", t.confrontationsToString());
	}
	
	@Test
	void testStrategieToString() throws Exception {
		Gentille g = new Gentille();
		Tournoi t = new Tournoi(10, this.fillList());
		assertEquals("Ce tournoi opposera les strategies suivantes : \n" + g.getNom() + " - " + g.getDescription() + "\n", t.strategiesToString());
	}

	@Test
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
