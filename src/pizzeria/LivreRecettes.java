package pizzeria;

public class LivreRecettes {
	
	/** Array of recipes in coffee maker*/
	private Recette[] tabRecette;
	/** Number of recipes in coffee maker */
	private static final int NB_RECETTES = 4;
	
	/**
	 * Default constructor for a RecipeBook.
	 */
	public LivreRecettes() {
		tabRecette = new Recette[NB_RECETTES];
	}
	
	/**
	 * Returns the recipe array.
	 * @return Recipe[]
	 */
	public Recette[] getRecettes() {
		return tabRecette;
	}
	
	public boolean ajouterRecette(Recette r) {
		//Assume recipe doesn't exist in the array until 
		//find out otherwise
		boolean exists = false;
		//Check that recipe doesn't already exist in array
		for (int i = 0; i < tabRecette.length; i++ ) {
			if (r.equals(tabRecette[i])) {
				exists = true;
			}
		}
		//Assume recipe cannot be added until find an empty
		//spot
		boolean added = false;
		//Check for first empty spot in array
		if (!exists) {
			for (int i = 0; i < tabRecette.length && !added; i++) {
				if (tabRecette[i] == null) {
					tabRecette[i] = r;
					added = true;
				}
			}
		}
		return added;
	}

	/**
	 * Returns the name of the recipe deleted at the position specified
	 * and null if the recipe does not exist.
	 * @param recetteASupprimer
	 * @return String
	 */
	public String supprimerRecette(int recetteASupprimer) {
		if (tabRecette[recetteASupprimer] != null) {
			String recipeName = tabRecette[recetteASupprimer].getNom();
			tabRecette[recetteASupprimer] = new Recette();
			return recipeName;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the name of the recipe edited at the position specified
	 * and null if the recipe does not exist.
	 * @param recetteAModifier
	 * @param nvRecette
	 * @return String
	 */
	public synchronized String modifierRecette(int recetteAModifier, Recette nvRecette) {
		if (tabRecette[recetteAModifier] != null) {
			String recipeName = tabRecette[recetteAModifier].getNom();
			nvRecette.setNom("");
			tabRecette[recetteAModifier] = nvRecette;
			return recipeName;
		} else {
			return null;
		}
	}

}
