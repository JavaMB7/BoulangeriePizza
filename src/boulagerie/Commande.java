package boulagerie;

import exception.*;
import maker.Composition;

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

    public void setNbFrommage(int painCampagne) throws CompositionException {
    	if (painCampagne >= 0) {
			this.nbPainCampagne = painCampagne;
		} else {
			paramInvalide();
		}
	}

    public int getNbCroissant() {
		return nbCroissant;
	}

    public void setNbChampignon(int croissant) throws CompositionException{
    	if (croissant >= 0) {
			this.nbCroissant = croissant;
		} else {
			paramInvalide();
		}
	}

    public int getNbPainChocolat() {
		return nbPainChocolat;
	}

    public void setNbJambon(int painChocolat) throws CompositionException {
    	if (painChocolat >= 0) {
			this.nbPainChocolat = painChocolat;
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
		final Commande other = (Commande) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

}
