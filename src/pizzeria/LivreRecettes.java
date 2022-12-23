package pizzeria;

public class LivreRecettes {
	
	private Recette[] tabRecette;
	private static final int NB_RECETTES = 4;
	
	public LivreRecettes() {
		tabRecette = new Recette[NB_RECETTES];
	}
	
	public Recette[] getRecettes() {
		return tabRecette;
	}
	
	public boolean ajouterRecette(Recette r) {
		boolean exists = false;
		for (int i = 0; i < tabRecette.length; i++ ) {
			if (r.equals(tabRecette[i])) {
				exists = true;
			}
		}
		boolean added = false;
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

	public String supprimerRecette(int recetteASupprimer) {
		if (tabRecette[recetteASupprimer] != null) {
			String recipeName = tabRecette[recetteASupprimer].getNom();
			tabRecette[recetteASupprimer] = null;
			return recipeName;
		} else {
			return null;
		}
	}
	
	public synchronized String modifierRecette(int recetteAModifier, Recette nvRecette) {
		if (tabRecette[recetteAModifier] != null) {
			String recipeName = tabRecette[recetteAModifier].getNom();
			nvRecette.setNom(recipeName);
			tabRecette[recetteAModifier] = nvRecette;
			return recipeName;
		} else {
			return null;
		}
	}

}
