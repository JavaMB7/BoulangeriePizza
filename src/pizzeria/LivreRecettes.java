package pizzeria;

public class LivreRecettes {
	
	/** Array of recipes in coffee maker*/
	private Recette[] recipeArray;
	/** Number of recipes in coffee maker */
	private static final int NUM_RECIPES = 4;
	
	/**
	 * Default constructor for a RecipeBook.
	 */
	public LivreRecettes() {
		recipeArray = new Recette[NUM_RECIPES];
	}
	
	/**
	 * Returns the recipe array.
	 * @return Recipe[]
	 */
	public Recette[] getRecipes() {
		return recipeArray;
	}
	
	public boolean addRecipe(Recette r) {
		//Assume recipe doesn't exist in the array until 
		//find out otherwise
		boolean exists = false;
		//Check that recipe doesn't already exist in array
		for (int i = 0; i < recipeArray.length; i++ ) {
			if (r.equals(recipeArray[i])) {
				exists = true;
			}
		}
		//Assume recipe cannot be added until find an empty
		//spot
		boolean added = false;
		//Check for first empty spot in array
		if (!exists) {
			for (int i = 0; i < recipeArray.length && !added; i++) {
				if (recipeArray[i] == null) {
					recipeArray[i] = r;
					added = true;
				}
			}
		}
		return added;
	}

	/**
	 * Returns the name of the recipe deleted at the position specified
	 * and null if the recipe does not exist.
	 * @param recipeToDelete
	 * @return String
	 */
	public String deleteRecipe(int recipeToDelete) {
		if (recipeArray[recipeToDelete] != null) {
			String recipeName = recipeArray[recipeToDelete].getNom();
			recipeArray[recipeToDelete] = new Recette();
			return recipeName;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the name of the recipe edited at the position specified
	 * and null if the recipe does not exist.
	 * @param recipeToEdit
	 * @param newRecipe
	 * @return String
	 */
	public synchronized String editRecipe(int recipeToEdit, Recette newRecipe) {
		if (recipeArray[recipeToEdit] != null) {
			String recipeName = recipeArray[recipeToEdit].getNom();
			newRecipe.setNom("");
			recipeArray[recipeToEdit] = newRecipe;
			return recipeName;
		} else {
			return null;
		}
	}

}
