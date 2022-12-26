package boulangerie;

import composition.Composition;
import exception.*;

public class Commande extends Composition {
    
	private int nbBaguette;
    private int nbPainCampagne;
    private int nbCroissant;
    private int nbPainChocolat;

    public Commande() {
    	super();
    	this.nbBaguette = 0;
    	this.nbPainCampagne = 0;
    	this.nbCroissant = 0;
    	this.nbPainChocolat = 0;
    }
    
    public int getNbBaguette() {
		return nbBaguette;
	}

    public void setNbBaguette(int baguette) throws CompositionException {
		if (baguette >= 0) {
			this.nbBaguette = baguette;
		} else {
			paramInvalide();
		}
	}

    public int getNbPainCampagne() {
		return nbPainCampagne;
	}

    public void setNbPainCampagne(int painCampagne) throws CompositionException {
    	if (painCampagne >= 0) {
			this.nbPainCampagne = painCampagne;
		} else {
			paramInvalide();
		}
	}

    public int getNbCroissant() {
		return nbCroissant;
	}

    public void setNbCroissant(int croissant) throws CompositionException{
    	if (croissant >= 0) {
			this.nbCroissant = croissant;
		} else {
			paramInvalide();
		}
	}

    public int getNbPainChocolat() {
		return nbPainChocolat;
	}

    public void setNbPainChocolat(int painChocolat) throws CompositionException {
    	if (painChocolat >= 0) {
			this.nbPainChocolat = painChocolat;
		} else {
			paramInvalide();
		}
	}
        
    public static void main(String[] args) throws CompositionException { 		
 		Commande c1;
 				c1 = new Commande();
 				c1.setNom("Commande speciale");
 				c1.setNbBaguette(4);
 				c1.setNbCroissant(3);
 				c1.setNbPainCampagne(6);
 				c1.setNbPainChocolat(0);
 				c1.setPrix(14);

 		System.out.println(c1.getNom());
 		System.out.println(c1.getPrix());
 		System.out.println(c1.getNbBaguette());
 		System.out.println(c1.getNbCroissant());
 		System.out.println(c1.getNbPainCampagne());
 		System.out.println(c1.getNbPainChocolat());
 		
 	}

}
