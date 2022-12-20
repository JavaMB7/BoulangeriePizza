package boulagerie;

import exception.*;
import pizzeria.Recette;

public class BoulangerieMaker {
	
	private static ListeCommandes commandes;
	private static StockBoulangerie stockBoulangerie;

	public BoulangerieMaker() {
		commandes = new ListeCommandes();
		stockBoulangerie = new StockBoulangerie();
	}

	public boolean ajoutCommande(Commande c) {
		return commandes.ajouterCommande(c);
	}
	
	public String supprCommande(int commandeASuppr) {
		return commandes.supprimerCommande(commandeASuppr);
	}

	public String modifCommande(int commandeAModif, Commande c) {
		return commandes.modifierCommande(commandeAModif, c);
	}

	
	public void ajouterstockBoulangerie(int nbBaguette, int nbPainCampagne, int nbCroissant, int nbPainChocolat)
			throws StockException {
		StockBoulangerie.add(nbBaguette, "chorizo");
		StockBoulangerie.add(nbPainCampagne, "frommage");
		StockBoulangerie.add(nbCroissant, "jambon");
		StockBoulangerie.add(nbPainChocolat, "champignon");
	}

	public String verifierstockBoulangerie() {
		return stockBoulangerie.toString();
	}

	public int makeCoffee(int commandeNb, int montantPayer) {
		int monnaie = 0;

		final Commande recetteSelectionner = getToutesCommandes()[commandeNb];
		final int prixNourriture = recetteSelectionner != null
				? recetteSelectionner.getPrix()
				: null;
		if ((recetteSelectionner != null) 
				&& (prixNourriture <= montantPayer) 
				&& (stockBoulangerie.utiliserProduit(recetteSelectionner))) {
			monnaie = montantPayer - prixNourriture;
		} else {
			monnaie = montantPayer;
		}

		return monnaie;
	}

	public Commande[] getToutesCommandes() {
		return commandes.getCommandes();
	}
}
