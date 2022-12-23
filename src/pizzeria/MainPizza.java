package pizzeria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

import exception.*;

public class MainPizza {
    private static PizzaMaker pizzaMaker;
    
    private static double prixFrommage = 1.2;
    private static double prixChampignon = 1.3;
    private static double prixJambon = 1.5;
    private static double prixChorizo = 1.4;
    
    private static final String NB_RECETTE_SUPPR = "Merci de rentrer le numero de la recette à supprimer";
    private static final String NB_RECETTE_MODIF = "Merci de rentrer le numero de la recette à modifier";
    private static final String NB_RECETTE_ACHETER = "Merci de rentrer le numero de la recette à acheter";
    
    private static final String ENTREE_FROMMAGE = "\nVeuillez entrer la quantite de frommage souhaité :";
    private static final String ENTREE_CHAMPIGNON = "\nVeuillez entrer la quantite de champignon souhaité :";
    private static final String ENTREE_JAMBON = "\nVeuillez entrer la quantite de jambon souhaité :";
    private static final String ENTREE_CHORIZO = "\nVeuillez entrer la quantite de chorizo souhaité :";

    public static void mainMenu() {
        System.out.println("\n1. Ajouter une recette");
        System.out.println("2. Supprimer une recette");
        System.out.println("3. Modifier une recette");
        System.out.println("4. Ajouter au stock");
        System.out.println("5. Verifier stock");
        System.out.println("6. Faire une pizza");
        System.out.println("0. Quitter\n");
        
        //Get user input
        try {
        	int userInput = Integer.parseInt(inputOutput("Merci d'appuyer sur la touche correspondante à ce que vous voulez que la machine fasse :"));
        	
        	if (userInput >= 0 && userInput <=6) {
		        if (userInput == 1) ajouterRecette();
		        if (userInput == 2) supprimerRecette();
		        if (userInput == 3) modifierRecette();
		        if (userInput == 4) ajouterStock();
		        if (userInput == 5) verifierStock();
		        if (userInput == 6) fairePizza();
		        if (userInput == 0) System.exit(0);
        	} else {
        		System.out.println("Entrer un numéro entre 0 - 6");
            	mainMenu();
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Entrer un numéro entre 0 - 6");
        	mainMenu();
        }
    }
    
    /**
     * The add recipe user interface that process user input.
     */
	public static void ajouterRecette() {
		
	    String nom = inputOutput("\nVeuillez entrer le nom de la recette : ");
	    	    
	    String frommageEntre = inputOutput(ENTREE_FROMMAGE);
	    	    
	    String champignonEntre = inputOutput(ENTREE_CHAMPIGNON);
	    	    
	    String jambonEntre = inputOutput(ENTREE_JAMBON);
	    	    
	    String chorizoEntre = inputOutput(ENTREE_CHORIZO);
	    	    
		Recette r = new Recette();
		try {
			r.setNom(nom);
			r.setNbFrommage(Integer.parseInt(frommageEntre));
			r.setNbChampignon(Integer.parseInt(champignonEntre));
			r.setNbJambon(Integer.parseInt(jambonEntre));
			r.setNbChorizo(Integer.parseInt(chorizoEntre));
			r.setPrix(calculPrix(r));
			
			boolean recipeAdded = pizzaMaker.ajoutRecette(r);
		    
		    if(recipeAdded) {
		    	System.out.println(nom + " ajouté avec succès.\n");
		    } else {
		    	System.out.println(nom + " n'a pas pu être ajouté.\n");
		    }
		} catch (CompositionException e) {
			System.out.println(e.getMessage());
		} finally {
			mainMenu();
		}
    }
    
    private static double calculPrix(Recette r) {
    	return r.getNbFrommage()*prixFrommage + r.getNbChampignon()*prixChampignon + r.getNbJambon()*prixJambon + r.getNbChorizo()*prixChorizo;
		 
	}

	public static void supprimerRecette() {
        int recetteASupprimer = recupererListeRecettes(NB_RECETTE_SUPPR);
	    
        String recetteSuppr = pizzaMaker.supprRecettes(recetteASupprimer);
        
        if (recetteSuppr != null) {
        	System.out.println(recetteSuppr + " supprimée avec succès.\n");
        } else {
	        System.out.println("La recette selectionnée n'existe pas et n'a pas pu être supprimer.\n");
        }
        mainMenu();
    }

    private static int recupererListeRecettes(String message) {
		Recette [] recettes = pizzaMaker.getToutesRecettes();
        for(int i = 0; i < recettes.length; i++) {
        	if (recettes[i] != null) {
        		System.out.println((i+1) + ". " + recettes[i].getNom());
        	}
        }
        int recetteNb = recipeListSelection(message);
        
	    if(recetteNb < 0) {
	    	mainMenu();
	    }
		return recetteNb;
	}
    
    public static void modifierRecette() {
    	int recetteAModifier = recupererListeRecettes(NB_RECETTE_MODIF);
	    
    	String frommageEntre = inputOutput(ENTREE_FROMMAGE);
	    
	    String champignonEntre = inputOutput(ENTREE_CHAMPIGNON);
	    	    
	    String jambonEntre = inputOutput(ENTREE_JAMBON);
	    	    
	    String chorizoEntre = inputOutput(ENTREE_CHORIZO);
	    
	    Recette nvRecette = new Recette();
	    try {
	    	nvRecette.setNbFrommage(Integer.parseInt(frommageEntre));
	    	nvRecette.setNbChampignon(Integer.parseInt(champignonEntre));
	    	nvRecette.setNbJambon(Integer.parseInt(jambonEntre));
	    	nvRecette.setNbChorizo(Integer.parseInt(chorizoEntre));
	    	nvRecette.setPrix(calculPrix(nvRecette));
			
			String recetteModifier = pizzaMaker.modifRecettes(recetteAModifier, nvRecette);
	        
	        if (recetteModifier != null) {
	        	System.out.println(recetteModifier + " modifier avec succès.\n");
	        }
		    else {
		    	System.out.println(recetteModifier + " n'a pas pu être modifier.\n");
		    }
		} catch (CompositionException e) {
			System.out.println(e.getMessage());
		} finally {
			mainMenu();
		}
    }
    
    public static void ajouterStock() {
    	String frommageEntre = inputOutput(ENTREE_FROMMAGE);
	    
	    String champignonEntre = inputOutput(ENTREE_CHAMPIGNON);
	    	    
	    String jambonEntre = inputOutput(ENTREE_JAMBON);
	    	    
	    String chorizoEntre = inputOutput(ENTREE_CHORIZO);
	    	    
        try {
        	pizzaMaker.ajouterStockIngPizza(Integer.parseInt(frommageEntre), Integer.parseInt(champignonEntre)
        			, Integer.parseInt(jambonEntre), Integer.parseInt(chorizoEntre));
        	System.out.println("Ingrédients ajoutés au stock avec succès");
        } catch (StockException e) {
        	System.out.println("Ingrédients non ajoutés");
        } finally {
        	mainMenu();
        }
    }
    
    public static void verifierStock() {
    	System.out.println(pizzaMaker.verifierStockIngPizza());
    	mainMenu();
    }
    
    public static void fairePizza() {
        int recetteAAcheter = recupererListeRecettes(NB_RECETTE_ACHETER);
        
        String montantPayer = inputOutput("Merci de rentrer le montant à payer :");
        int mntPayer = 0;
        try {
        	mntPayer = Integer.parseInt(montantPayer);
        } catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un entier positif");
        	mainMenu();
        }
        
        double change = pizzaMaker.fairePizza(recetteAAcheter, mntPayer);
        
        if (change == mntPayer) {
        	System.out.println("Fonds insuffisants.");
        } else {
        	System.out.println("Merci d'avoir acheter " + pizzaMaker.getToutesRecettes()[recetteAAcheter].getNom());
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Votre change est de :  "+ df.format(change) + " € \n");
        mainMenu();
    }
    
    public static String inputOutput(String message) {
	    System.out.println(message);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String chaineRetourner = "";
	    try {
	    	chaineRetourner = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Erreur de lecture");
	        mainMenu();
	    }
	    return chaineRetourner;
	}
    
    public static int recipeListSelection(String message) {
		String selectionUtilisateur = inputOutput(message);
		int recette = 0;
	    try {
	    	recette = Integer.parseInt(selectionUtilisateur) - 1;
	    	if (recette >= 0 && recette <=2) {
	    		//ne rien faire
	    	} else {
	    		recette = -1;
	    	}
	    } catch (NumberFormatException e) {
	    	System.out.println("Entrer un numéro entre 1-3.");
	    	recette = -1;
	    }
	    return recette;
	}
    
    public static void main(String[] args) {
	    pizzaMaker = new PizzaMaker();
	    System.out.println("Bienvenue à PizzaMaker !\n");
	    mainMenu();
	}
}

