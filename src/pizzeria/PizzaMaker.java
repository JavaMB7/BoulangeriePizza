package pizzeria;

import exception.*;

public class PizzaMaker {

	private LivreRecettes livreRecettes;
	private StockIngPizza stockIngPizza;

	public PizzaMaker() {
		livreRecettes = new LivreRecettes();
		stockIngPizza = new StockIngPizza();
	}

	public boolean ajoutRecette(Recette r) {
		return livreRecettes.ajouterRecette(r);
	}

	public String supprRecette(int recetteASuppr) {
		return livreRecettes.supprimerRecette(recetteASuppr);
	}

	public String modifRecette(int recetteAModifier, Recette r) {
		return livreRecettes.modifierRecette(recetteAModifier, r);
	}

	public synchronized void ajouterStockIngPizza(int nbChorizo, int nbFrommage, int nbJambon, int nbChampignon)
			throws StockException {
		stockIngPizza.ajouter(nbChorizo, "chorizo");
		stockIngPizza.ajouter(nbFrommage, "frommage");
		stockIngPizza.ajouter(nbJambon, "jambon");
		stockIngPizza.ajouter(nbChampignon, "champignon");
	}

	// Maybe
	public String verifierStockIngPizza() {
		return stockIngPizza.toString();
	}

	public double fairePizza(int recetteNb, int montantPayer) {
		double monnaie = 0;

		final Recette recetteSelectionner = getToutesRecettes()[recetteNb];
		final double prixNourriture = recetteSelectionner != null
				? recetteSelectionner.getPrix()
				: null;
		if ((recetteSelectionner != null) 
				&& (prixNourriture <= montantPayer) 
				&& (stockIngPizza.utiliserIngredients(recetteSelectionner))) {
			monnaie = montantPayer - prixNourriture;
		} else {
			monnaie = montantPayer;
		}

		return monnaie;
	}

	public Recette[] getToutesRecettes() {
		return livreRecettes.getRecettes();
	}
}
