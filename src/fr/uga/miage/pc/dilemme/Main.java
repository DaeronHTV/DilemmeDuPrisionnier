package fr.uga.miage.pc.dilemme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import fr.uga.miage.pc.dilemme.strategie.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		boolean confirm = false;
		ArrayList<Strategie> list = null;
		while(!confirm){
			list = init();
		}
		
	}
	
	public static ArrayList<Strategie> init() throws IOException {
		String[] result = null;
		ArrayList<Strategie> list = new ArrayList<Strategie>();
		System.out.println("Bienvenue dans ce tournoi !\n");
		System.out.println("Avant de commencer veuillez choisir les Strategies qui vont s'affronter :");
		afficheStrategie();
		System.out.print("Separe les numéros par un '-' : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			result = br.readLine().split("-");
			list = initListStrategie(result);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}
	
	public static void afficheStrategie() {
		System.out.println("1. Gentille");
		System.out.println("2. Mechante");
		System.out.println("3. Donnant-Donant");
		System.out.println("4. Donnant-Donnant Dur");
		System.out.println("5. Mefiante");
		System.out.println("6. Rancunière");
		System.out.println("7. Periodique-Gentille");
		System.out.println("8. Periodique-Mechante\n");
	}
	
	public static ArrayList<Strategie> initListStrategie(String[] choice){
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
					break;
			}
		}
		return list;
	}
}
