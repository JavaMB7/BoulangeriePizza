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

	public synchronized void ajouterStockIngPizza(int nbFrommage, int nbChampignon, int nbJambon, int nbChorizo)
			throws StockException {
		stockIngPizza.ajouter(nbFrommage, "frommage");
		stockIngPizza.ajouter(nbChampignon, "champignon");
		stockIngPizza.ajouter(nbJambon, "jambon");
		stockIngPizza.ajouter(nbChorizo, "chorizo");
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
