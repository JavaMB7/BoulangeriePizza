package boulangerie;

import exception.*;

public class BoulangerieMaker {
	
	private ListeCommandes commandes;
	private StockBoulangerie stockBoulangerie;

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

	
	public synchronized void ajouterStockBoulangerie(int nbBaguette, int nbPainCampagne, int nbCroissant, int nbPainChocolat)
			throws StockException {
		stockBoulangerie.ajouter(nbBaguette, "baguette");
		stockBoulangerie.ajouter(nbPainCampagne, "pain campagne");
		stockBoulangerie.ajouter(nbCroissant, "croissant");
		stockBoulangerie.ajouter(nbPainChocolat, "pain chocolat");
	}

	public String verifierStockBoulangerie() {
		return stockBoulangerie.toString();
	}

	public double vendrePain(int commandeNb, int montantPayer) {
		double monnaie = 0;

		final Commande recetteSelectionner = getToutesCommandes()[commandeNb];
		final double prixNourriture = recetteSelectionner != null
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
