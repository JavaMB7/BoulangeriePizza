package pizzeria;

import exception.*;

public class Recette {
    private String nom;
    private int prix;
    private int nbFrommage;
    private int nbChampignon;
    private int nbJambon;
    private int nbChorizo;
    private static final String ENTIER_NEGATIF = "La quantité à affecter doit être positive";
    
    private void paramInvalide() throws RecetteException {
		throw new RecetteException(ENTIER_NEGATIF);
	}
    /**
     * Creer des pizzas par défault pour la machine a pizza
     */
    public Recette() {
    	this.nom = "";
    	this.prix = 0;
    	this.nbFrommage = 0;
    	this.nbChampignon = 0;
    	this.nbJambon = 0;
    	this.nbChorizo = 0;
    }
    
    public int getNbChorizo() {
		return nbChorizo;
	}

    public void setNbChorizo(int chorizo) throws RecetteException {
		if (chorizo >= 0) {
			this.nbChorizo = chorizo;
		} else {
			paramInvalide();
		}
	}

    public int getNbFrommage() {
		return nbFrommage;
	}

    public void setNbFrommage(int frommage) throws RecetteException {
    	if (frommage >= 0) {
			this.nbFrommage = frommage;
		} else {
			paramInvalide();
		}
	}

    public int getNbChampignon() {
		return nbChampignon;
	}

    public void setNbChampignon(int champignon) throws RecetteException{
    	if (champignon >= 0) {
			this.nbChampignon = champignon;
		} else {
			paramInvalide();
		}
	}

    public int getNbJambon() {
		return nbJambon;
	}

    public void setNbJambon(int jambon) throws RecetteException {
    	if (jambon >= 0) {
			this.nbJambon = jambon;
		} else {
			paramInvalide();
		}
	}

    public String getNom() {
		return nom;
	}

    public void setNom(String nom) {
    	if(nom != null) {
    		this.nom = nom;
    	}
	}

    public int getPrix() {
		return prix;
	}

    public void setPrix(int prix) throws RecetteException{
    	if (prix >= 0) {
			this.prix = prix;
		} else {
			paramInvalide();
		}
	} 
    
    public String toString() {
    	return nom;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Recette other = (Recette) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

}
