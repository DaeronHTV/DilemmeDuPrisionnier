package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

import fr.uga.miage.exception.LengthException;

public class Main {
	public static void main(String[] args) {
		ArrayList<Strategie> s = new ArrayList<Strategie>();
		s.add(new Strategie("test", "test description"));
		s.add(new Strategie("test 2", "test description 2"));
		try {
			Tournoi t = new Tournoi(10, s);
			System.out.println("Nombre de tours par rencontre : " + t.getNbTours());
			System.out.println(t.strategiesToString());
			System.out.println(t.confrontationsToString());
		}catch(LengthException le) {
			System.out.print("Error : ");
			le.printStackTrace();
		}
	}
}
