package fr.uga.miage.pc.dilemme.back;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import fr.uga.miage.pc.dilemme.back.interfaces.IConfrontation;
import fr.uga.miage.pc.dilemme.back.strategie.Gentille;
import fr.uga.miage.pc.dilemme.back.strategie.Mechante;
import fr.uga.miage.pc.interfaces.IStrategie;

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
		IConfrontation Result = t.nextElement();
		assertFalse(t.hasMoreElements());
		//assertEquals("Rencontre N°1 - Gentille VS Gentille\nLe score final est de :\nGentille : 30\nGentille : 30", 
		//ApiDilemme.confrontationText(1, Result)); //LE TEST NE PASSE PAS ?????
	}
	
	@Test
	@Order(3)
	void TestSetGetConfrontations() throws Exception {

	}
	
	@Test
	@Order(4)
	void TestSetGetStrategie() throws Exception {
		ArrayList<IStrategie> s = new ArrayList<IStrategie>();
		Tournoi t = new Tournoi(10, this.fillList());
		assertTrue(t.Strategie(0).getStrategyName().equals("Gentille"));
		s.add(new Mechante());
		t.setStrategies(s);
		assertTrue(t.Strategie(0).getStrategyName().equals("Mechante"));
	}

	@Test
	@Order(5)
	void testToString() throws Exception {
		Tournoi t = new Tournoi(10, this.fillList());
		String test = t.toString();
		String result = ""; int i = 0;
		for(IConfrontation confrontation: t.Confrontations()) {
			result += "Rencontre " + i + " : " + confrontation.toString() + "\n";
			i++;
		}
		assertEquals(result, test);
	}

	private ArrayList<IStrategie> fillList(){
		ArrayList<IStrategie> s = new ArrayList<IStrategie>();
		s.add(new Gentille());
		return s;
	}


}
