package boulagerie;

import exception.*;

public class BoulangerieMaker {
	/** Array of Recettes in coffee maker */
	private static LivreRecettes livreRecettes;
	/** stockIngPizza of the coffee maker */
	private static StockBoulangerie stockIngPizza;

	/**
	 * Constructor for the coffee maker
	 *
	 */
	public BoulangerieMaker() {
		livreRecettes = new LivreRecettes();
		stockIngPizza = new StockBoulangerie();
	}

	/**
	 * Returns true if the Recette is added to the list of Recettes in the CoffeeMaker
	 * and false otherwise.
	 * 
	 * @param r
	 * @return boolean
	 */
	public boolean addRecette(Recette r) {
		return livreRecettes.ajouterRecette(r);
	}

	/**
	 * Returns the name of the successfully deleted Recette or null if the Recette
	 * cannot be deleted.
	 * 
	 * @param recetteASuppr
	 * @return String
	 */
	public String deleteRecette(int recetteASuppr) {
		return livreRecettes.supprimerRecette(recetteASuppr);
	}

	/**
	 * Returns the name of the successfully edited Recette or null if the Recette
	 * cannot be edited.
	 * 
	 * @param recetteAModifier
	 * @param r
	 * @return String
	 */
	public String editRecette(int recetteAModifier, Recette r) {
		return livreRecettes.modifierRecette(recetteAModifier, r);
	}

	/**
	 * Returns true if stockIngPizza was successfully added
	 * 
	 * @param amtCoffee
	 * @param amtMilk
	 * @param amtSugar
	 * @param amtChocolate
	 * @return boolean
	 */
	public void ajouterStockIngPizza(int nbChorizo, int nbFrommage, int nbJambon, int nbChampignon)
			throws StockException {
		stockIngPizza.add(nbChorizo, "chorizo");
		stockIngPizza.add(nbFrommage, "frommage");
		stockIngPizza.add(nbJambon, "jambon");
		stockIngPizza.add(nbChampignon, "champignon");
	}

	/**
	 * Returns the stockIngPizza of the coffee maker
	 * 
	 * @return stockIngPizza
	 */
	public String verifierStockIngPizza() {
		return stockIngPizza.toString();
	}

	/**
	 * Returns the change of a user's beverage purchase, or the user's money if the
	 * beverage cannot be made
	 * 
	 * @param RecetteNb
	 * @param amtPaid
	 * @return int
	 */
	public int makeCoffee(int recetteNb, int montantPayer) {
		int monnaie = 0;

		final Recette recetteSelectionner = getToutesRecettes()[recetteNb];
		final int prixNourriture = recetteSelectionner != null
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

	/**
	 * Returns the list of Recettes in the livreRecettes.
	 * 
	 * @return Recette []
	 */
	public Recette[] getToutesRecettes() {
		return livreRecettes.getRecettes();
	}
}
