package fr.uga.miage.pc.dilemme;

import java.util.ArrayList;

public class Main {
	
	private ArrayList<Strategie> s = new ArrayList<Strategie>();
	private Tournoi t;
	
	public void Launch() {
		for(Rencontre r: this.t.getConfrontations()) {
			System.out.println("Rencontre N°" + (this.t.getNumRencontre()+1) + " :");
			System.out.println(r.toString());
			System.out.println();
			this.t.rencontreIncrement();;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenue dans ce tournoi !");
		
		ArrayList<Strategie> s = new ArrayList<Strategie>();
		/*s.add(new Strategie("test", "test description"));
		s.add(new Strategie("test 2", "test description 2"));
		s.add(new Strategie("test 3", "test description 3"));
		s.add(new Strategie("test 4", "test description 4"));
		s.add(new Strategie("test 5", "test description 5"));
		s.add(new Strategie("test 6", "test description 6"));
		Tournoi t = new Tournoi(10, s);*/
		//System.out.println(t.toString());
	}
}
