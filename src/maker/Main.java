package maker;

import pizzeria.MainPizza;
import java.util.Scanner;
import boulangerie.MainBoulangerie;

public class Main {
	
	private MainPizza mp;
	private MainBoulangerie mb;
	

	
	public static void main(String[] args) {
		MainPizza mp = new MainPizza();
		MainBoulangerie mb = new MainBoulangerie();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("1. Acceder Pizzeria");
			System.out.println("2. Acceder Boulangerie");
			System.out.println("0. Quitter");
			try {
				System.out.println("\nEcrire un nombre : ");
				int entreeUtilisateur = scanner.nextInt();

				if (entreeUtilisateur >= 0 && entreeUtilisateur <= 2) {
					if (entreeUtilisateur == 1) mp.mainMenu();
					if (entreeUtilisateur == 2)	mb.mainMenu();
					if (entreeUtilisateur == 0) System.exit(0);
						
				} else {
					System.out.println("Entrer un numéro entre 0 - 2");

				}
			} catch (NumberFormatException e) {
				System.out.println("Entrer un numéro entre 0 - 2");
			}
		}
	}

}
