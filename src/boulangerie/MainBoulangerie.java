package boulangerie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exception.*;

public class MainBoulangerie {
    private static BoulangerieMaker boulangerieMaker;
    
    private static double prixBaguette = 1.2;
    private static double prixPainCampagne = 1.3;
    private static double prixCroissant = 1.5;
    private static double prixPainChocolat = 1.4;
    
    private static final String NB_COMMANDE_SUPPR = "Merci de rentrer le numero de la commande à supprimer";
    private static final String NB_COMMANDE_MODIF = "Merci de rentrer le numero de la commande à modifier";
    private static final String NB_COMMANDE_ACHETER = "Merci de rentrer le numero de la commande à acheter";
    
    private static final String ENTREE_NOM = "\nVeuillez entrer le nom de la commande : ";
    private static final String ENTREE_BAGUETTE = "\nVeuillez entrer la quantite de baguette souhaité :";
    private static final String ENTREE_PAIN_CAMPAGNE = "\nVeuillez entrer la quantite de pain campagne souhaité :";
    private static final String ENTREE_CROISSANT = "\nVeuillez entrer la quantite de croissant souhaité :";
    private static final String ENTREE_PAIN_CHOCOLAT = "\nVeuillez entrer la quantite de pain au chocolat souhaité :";

    public static void mainMenu() {
        System.out.println("1. Ajouter une commande");
        System.out.println("2. Supprimer une commande");
        System.out.println("3. Modifier une commande");
        System.out.println("4. Ajouter au stock");
        System.out.println("5. Verifier stock");
        System.out.println("6. Acheter dans la boulangerie");
        System.out.println("0. Quitter\n");
        
        try {
        	int entreeUtilisateur = Integer.parseInt(inputOutput("Merci d'appuyer sur la touche correspondante à ce que vous voulez que la machine fasse :"));
        	
        	if (entreeUtilisateur >= 0 && entreeUtilisateur <=6) {
		        if (entreeUtilisateur == 1) ajouterCommande();
		        if (entreeUtilisateur == 2) supprimerCommande();
		        if (entreeUtilisateur == 3) modifierCommande();
		        if (entreeUtilisateur == 4) ajouterStock();
		        if (entreeUtilisateur == 5) verifierStock();
		        if (entreeUtilisateur == 6) vendrePain();
		        if (entreeUtilisateur == 0) System.exit(0);
        	} else {
        		System.out.println("Entrer un numéro entre 0 - 6");
            	mainMenu();
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Entrer un numéro entre 0 - 6");
        	mainMenu();
        }
    }
    
	public static void ajouterCommande() {
		
	    String nom = inputOutput(ENTREE_NOM);
	    	    
	    String baguetteEntre = inputOutput(ENTREE_BAGUETTE);
	    	    
	    String painCampagneEntre = inputOutput(ENTREE_PAIN_CAMPAGNE);
	    	    
	    String croissantEntre = inputOutput(ENTREE_CROISSANT);
	    	    
	    String painChocolatEntre = inputOutput(ENTREE_PAIN_CHOCOLAT);
	    	    
		Commande c = new Commande();
		try {
			c.setNom(nom);
			c.setNbBaguette(Integer.parseInt(baguetteEntre));
			c.setNbPainCampagne(Integer.parseInt(painCampagneEntre));
			c.setNbCroissant(Integer.parseInt(croissantEntre));
			c.setNbPainChocolat(Integer.parseInt(painChocolatEntre));
			c.setPrix(calculPrix(c));
			
			boolean commandeAjoutee = boulangerieMaker.ajoutCommande(c);
		    
		    if(commandeAjoutee) {
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
    
    private static double calculPrix(Commande c) {
		return c.getNbBaguette()*prixBaguette + c.getNbPainCampagne()*prixPainCampagne
				+ c.getNbCroissant()*prixCroissant + c.getNbPainChocolat()*prixPainChocolat;
	}

	public static void supprimerCommande() {
        int commandeASupprimer = recupererDansListeCommandes(NB_COMMANDE_SUPPR);
	    
        String commandeSuppr = boulangerieMaker.supprCommande(commandeASupprimer);
        
        if (commandeSuppr != null) {
        	System.out.println(commandeSuppr + " supprimée avec succès.\n");
        } else {
	        System.out.println("La commande selectionnée n'existe pas et n'a pas pu être supprimer\n");
        }
        mainMenu();
    }

    private static int recupererDansListeCommandes(String message) {
		Commande [] commandes = boulangerieMaker.getToutesCommandes();
        for(int i = 0; i < commandes.length; i++) {
        	if (commandes[i] != null) {
        		System.out.println((i+1) + ". " + commandes[i].getNom());
        	}
        }
        int commandeNb = selectionListeCommande(message);
        
	    if(commandeNb < 0) {
	    	mainMenu();
	    }
		return commandeNb;
	}
    
    public static void modifierCommande() {
    	int commandeAModifier = recupererDansListeCommandes(NB_COMMANDE_MODIF);
	    
    	String baguetteEntre = inputOutput(ENTREE_BAGUETTE);
	    
	    String painCampagneEntre = inputOutput(ENTREE_PAIN_CAMPAGNE);
	    	    
	    String croissantEntre = inputOutput(ENTREE_CROISSANT);
	    	    
	    String painChocolatEntre = inputOutput(ENTREE_PAIN_CHOCOLAT);
	    
	    Commande nvCommande = new Commande();
	    try {
	    	nvCommande.setNbBaguette(Integer.parseInt(baguetteEntre));
	    	nvCommande.setNbPainCampagne(Integer.parseInt(painCampagneEntre));
	    	nvCommande.setNbCroissant(Integer.parseInt(croissantEntre));
	    	nvCommande.setNbPainChocolat(Integer.parseInt(painChocolatEntre));
	    	nvCommande.setPrix(calculPrix(nvCommande));
			
			String commandeModifier = boulangerieMaker.modifCommande(commandeAModifier, nvCommande);
	        
	        if (commandeModifier != null) {
	        	System.out.println(commandeModifier + " modifier avec succès.\n");
	        }
		    else {
		    	System.out.println(commandeModifier + " n'a pas pu être modifier.\n");
		    }
		} catch (CompositionException e) {
			System.out.println(e.getMessage());
		} finally {
			mainMenu();
		}
    }
    
    public static void ajouterStock() {
    	String baguetteEntre = inputOutput(ENTREE_BAGUETTE);
	    
	    String painCampagneEntre = inputOutput(ENTREE_PAIN_CAMPAGNE);
	    	    
	    String croissantEntre = inputOutput(ENTREE_CROISSANT);
	    	    
	    String painChocolatEntre = inputOutput(ENTREE_PAIN_CHOCOLAT);
	    	    
        try {
        	boulangerieMaker.ajouterStockBoulangerie(Integer.parseInt(baguetteEntre), Integer.parseInt(painCampagneEntre)
        			, Integer.parseInt(croissantEntre), Integer.parseInt(painChocolatEntre));
        	System.out.println("Produits ajoutés au stock avec succès");
        } catch (StockException e) {
        	System.out.println("Produits non ajouté");
        } finally {
        	mainMenu();
        }
    }
    
    public static void verifierStock() {
    	System.out.println(boulangerieMaker.verifierStockBoulangerie());
    	mainMenu();
    }
    
    public static void vendrePain() {
        int commandeAAcheter = recupererDansListeCommandes(NB_COMMANDE_ACHETER);
        
        String montantPayer = inputOutput("Merci de rentrer le montant à payer :");
        int mntPayer = 0;
        try {
        	mntPayer = Integer.parseInt(montantPayer);
        } catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un entier positif");
        	mainMenu();
        }
        
        double change = boulangerieMaker.vendrePain(commandeAAcheter, mntPayer);
        
        if (change == mntPayer) {
        	System.out.println("Fonds insuffisants.");
        } else {
        	System.out.println("Merci d'avoir acheter " + boulangerieMaker.getToutesCommandes()[commandeAAcheter].getNom());
        }
        System.out.println("Votre change est de : " + change + "\n");
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
    
    public static int selectionListeCommande(String message) {
		String selectionUtilisateur = inputOutput(message);
		int commande = 0;
	    try {
	    	commande = Integer.parseInt(selectionUtilisateur) - 1;
	    	if (commande >= 0 && commande <=2) {
	    		//ne rien faire
	    	} else {
	    		commande = -1;
	    	}
	    } catch (NumberFormatException e) {
	    	System.out.println("Entrer un numéro entre 1-3.");
	    	commande = -1;
	    }
	    return commande;
	}
    
    public static void main(String[] args) {
	    boulangerieMaker = new BoulangerieMaker();
	    System.out.println("Bienvenue à BoulangerieMaker !\n");
	    mainMenu();
	}
}

