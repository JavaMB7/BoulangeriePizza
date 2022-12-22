package pizzeria;

import exception.*;
import maker.Composition;

public class Recette extends Composition {
	
    private int nbFrommage;
    private int nbChampignon;
    private int nbJambon;
    private int nbChorizo;

    public Recette() {
    	super();
    	this.nbFrommage = 0;
    	this.nbChampignon = 0;
    	this.nbJambon = 0;
    	this.nbChorizo = 0;
    }
    
    public int getNbChorizo() {
		return nbChorizo;
	}

    public void setNbChorizo(int chorizo) throws CompositionException {
		if (chorizo >= 0) {
			this.nbChorizo = chorizo;
		} else {
			paramInvalide();
		}
	}

    public int getNbFrommage() {
		return nbFrommage;
	}

    public void setNbFrommage(int frommage) throws CompositionException {
    	if (frommage >= 0) {
			this.nbFrommage = frommage;
		} else {
			paramInvalide();
		}
	}

    public int getNbChampignon() {
		return nbChampignon;
	}

    public void setNbChampignon(int champignon) throws CompositionException{
    	if (champignon >= 0) {
			this.nbChampignon = champignon;
		} else {
			paramInvalide();
		}
	}

    public int getNbJambon() {
		return nbJambon;
	}

    public void setNbJambon(int jambon) throws CompositionException {
    	if (jambon >= 0) {
			this.nbJambon = jambon;
		} else {
			paramInvalide();
		}
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
    
    public static void main(String[] args) throws CompositionException { 		
 		Recette r1;
 				r1 = new Recette();
 				r1.setNom("Pizza speciale");
 				r1.setNbFrommage(4);
 				r1.setNbChampignon(3);
 				r1.setNbJambon(6);
 				r1.setNbChorizo(0);
 				r1.setPrix(14);

 		System.out.println(r1.getNom());
 		System.out.println(r1.getPrix());
 		System.out.println(r1.getNbFrommage());
 		System.out.println(r1.getNbChampignon());
 		System.out.println(r1.getNbJambon());
 		System.out.println(r1.getNbChorizo());
 		
 	}
}
