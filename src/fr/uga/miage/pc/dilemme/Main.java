package fr.uga.miage.pc.dilemme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import fr.uga.miage.pc.dilemme.strategie.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Tournoi t = init();
		System.out.println("\nLe tournoi est initialisé !\n");
		System.out.println(t.strategiesToString());
		System.out.println(t.confrontationsToString());
	}
	
	/*public static void clearScreen() throws IOException {
		Runtime runtime = Runtime.getRuntime ();
		  String[] args = {"cmd.exe","/c","cls"};
		  final Process p = runtime.exec(args);
	}*/
	
	public static Tournoi init() throws IOException {
		System.out.println("Bienvenue dans ce tournoi !\n");
		ArrayList<Strategie> list = initList();
 		int nbTours = initTour();
		return new Tournoi(nbTours, list);
	}
	
	public static ArrayList<Strategie> initList() throws IOException {
		String[] result = null;
		ArrayList<Strategie> list = null;
		boolean confirm = false;
		while(!confirm) {
			System.out.println("Avant de commencer veuillez choisir les Strategies qui vont s'affronter :");
			afficheListStrategie();
			System.out.print("Separe les numéros par un '-' : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				result = br.readLine().split("-");
				list = fillListStrategie(result);
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			System.out.println("\n\n");
			afficherChoix(list);
			System.out.print("Est-ce bien la liste désirée ? (y/n) : ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String choice = br.readLine();
			confirm = choice.equals("y") || choice.equals("Y") ? true : false;
		}
		return list;
	}
	
	public static int initTour() throws NumberFormatException, IOException {
		boolean confirm = false;
		int result = 0;
		while(!confirm) {
			System.out.print("Veuillez maintenant indiquer le nombre de tours par Rencontre : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			result = Integer.parseInt(br.readLine());
			System.out.print("(" + result + ") est bien le nombre de tour voulu ? (y/n) : ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String choice = br.readLine();
			confirm = choice.equals("y") || choice.equals("Y") ? true : false;
		}
		return result;
	}
	
	public static void afficheListStrategie() {
		System.out.println("1. Gentille");
		System.out.println("2. Mechante");
		System.out.println("3. Donnant-Donant");
		System.out.println("4. Donnant-Donnant Dur");
		System.out.println("5. Mefiante");
		System.out.println("6. Rancunière");
		System.out.println("7. Periodique-Gentille");
		System.out.println("8. Periodique-Mechante\n");
	}
	
	public static void afficherChoix(ArrayList<Strategie> list) {
		for(Strategie s : list) {
			System.out.println(s.getNomStrategie());
		}
	}
	
	public static ArrayList<Strategie> fillListStrategie(String[] choice){
		ArrayList<Strategie> list = new ArrayList<Strategie>();
		for(String s: choice) {
			switch(s) {
				case "1":
					list.add(new Gentille());
					break;
				case "2":
					list.add(new Mechante());
					break;
				case "3":
					list.add(new DonnantDonnant());
					break;
				case "4":
					list.add(new DonnantDonnantDur());
					break;
				case "5":
					list.add(new Mefiante());
					break;
				case "6":
					list.add(new Rancuniere());
					break;
				case "7":
					list.add(new PerGentille());
					break;
				case "8":
					list.add(new PerMechant());
					break;
				default:
					System.out.println("Ce choix ("+ s + ") n'existe pas");
					break;
			}
		}
		return list;
	}
}
