package fr.uga.miage.pc.dilemme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import fr.uga.miage.pc.dilemme.strategie.DonnantDonnant;
import fr.uga.miage.pc.dilemme.strategie.DonnantDonnantDur;
import fr.uga.miage.pc.dilemme.strategie.Gentille;
import fr.uga.miage.pc.dilemme.strategie.Mechante;
import fr.uga.miage.pc.dilemme.strategie.Mefiante;
import fr.uga.miage.pc.dilemme.strategie.PerGentille;
import fr.uga.miage.pc.dilemme.strategie.PerMechant;
import fr.uga.miage.pc.dilemme.strategie.Rancuniere;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Tournoi t = init();
		System.out.println(t);
		while(t.hasMoreElements()) {
			System.out.println(t.nextElement());
		}
		System.out.println("Fin du Tournoi !\nResume du Tournoi : \n" + t.sumUpTournoi());
	}
	
	public static Tournoi init() throws Exception {
		ArrayList<IStrategie> list = initList();
 		int nbTours = initTour();
		return new Tournoi(nbTours, list);
	}
	
	public static ArrayList<IStrategie> initList() throws IOException {
		ArrayList<IStrategie> list = null;
		boolean confirm = false;
		while(!confirm) {
			System.out.println("Veuillez choisir les Strategies qui vont s'affronter :\n1. Gentille\n2. Mechante\n3. Donnant-Donant\n"
					+ "4. Donnant-Donnant Dur\n5. Mefiante\n6. Rancunière\n7. Periodique-Gentille\n8. Periodique-Mechante\n");
			System.out.print("Separe les numéros par un '-' : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String[] result = br.readLine().split("-");
				list = fillListStrategie(result);
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			list.forEach(System.out::println);
			System.out.print("Confirmez le choix ? (y/n) : ");
			br = new BufferedReader(new InputStreamReader(System.in));
			confirm = br.readLine().equals("y") || br.readLine().equals("Y") ? true : false;
		}
		return list;
	}
	
	public static int initTour() throws NumberFormatException, IOException {
		boolean confirm = false; int result = 0;
		while(!confirm) {
			System.out.print("Veuillez maintenant indiquer le nombre de tours par Rencontre : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			result = Integer.parseInt(br.readLine());
			System.out.print("Confirmez le choix ? (y/n) : ");
			br = new BufferedReader(new InputStreamReader(System.in));
			confirm = br.readLine().equals("y") || br.readLine().equals("Y") ? true : false;
		}
		return result;
	}
	
	/**
	 * 
	 * @param choice
	 * @return The List of IStrategie that the user given
	 */
	public static ArrayList<IStrategie> fillListStrategie(String[] choice){
		ArrayList<IStrategie> list = new ArrayList<IStrategie>();
		for(String s: choice) {
			switch(s) {
				case "1": list.add(new Gentille()); break;
				case "2": list.add(new Mechante()); break;
				case "3": list.add(new DonnantDonnant()); break;
				case "4": list.add(new DonnantDonnantDur()); break;
				case "5": list.add(new Mefiante()); break;
				case "6": list.add(new Rancuniere()); break;
				case "7": list.add(new PerGentille()); break;
				case "8": list.add(new PerMechant()); break;
				default: break;
			}
		}
		return list;
	}
}
