package boulagerie;

import exception.StockException;

public class StockBoulangerie {
    
    private static int baguette;
    private static int painCampagne;
    private static int croissant;
    private static int painChocolat;
    
    public StockBoulangerie() {
    	setBaguette(15);
    	setPainCampagne(15);
    	setCroissant(15);
    	setPainChocolat(15);
    }
    
    public int getBaguette() {
        return baguette;
    }
    
    public int getPainCampagne() {
        return painCampagne;
    }
    
    public int getCroissant() {
        return croissant;
    }
    
    public int getPainChocolat() {
        return painChocolat;
    }

    public static void setBaguette(int baguette) {
    	if(baguette >= 0) {
    		StockBoulangerie.baguette = baguette;
    	}
    }

    public static void setPainCampagne(int painCampagne) {
    	if(painCampagne >= 0) {
    		StockBoulangerie.painCampagne = painCampagne;
    	}
    }
    
    public static void setCroissant(int croissant) {
    	if(croissant >= 0) {
    		StockBoulangerie.croissant = croissant;
    	}
    }
    
    public static void setPainChocolat(int painChocolat) {
    	if(painChocolat >= 0) {
    		StockBoulangerie.painChocolat = painChocolat;
    	}
        
    }
    
    public static void add(int quantite, String produit) throws StockException {
		if (quantite >= 0) {
			switch (produit) {
			case "baguette" :
				StockBoulangerie.baguette += quantite;
				break;
			case "pain campagne" :
				StockBoulangerie.painCampagne += quantite;
				break;
			case "croissant" :
				StockBoulangerie.croissant += quantite;
				break;
			case "pain chocolat" :
				StockBoulangerie.painChocolat += quantite;
				break;
			default :
				throw new StockException(produit+":ne fait pas partie des éléments à ajouter");
			}	
		} else {
			throw new StockException("La quantité de "+produit+" à ajouter doit avoir une valeur positive");
		}
    }
    
    
    public boolean assezDeProduit(Commande c) {
        boolean isEnough = true;
        if(StockBoulangerie.baguette < c.getNbBaguette()) {
            isEnough = false;
        }
        if(StockBoulangerie.painCampagne < c.getNbPainCampagne()) {
            isEnough = false;
        }
        if(StockBoulangerie.croissant < c.getNbCroissant()) {
            isEnough = false;
        }
        if(StockBoulangerie.painChocolat < c.getNbPainChocolat()) {
            isEnough = false;
        }
        return isEnough;
    }
    
    public synchronized boolean utiliserProduit(Commande c) {
    	if (assezDeProduit(c)) {
    		StockBoulangerie.baguette -= c.getNbBaguette();
	    	StockBoulangerie.painCampagne -= c.getNbPainCampagne();
	    	StockBoulangerie.croissant -= c.getNbCroissant();
	    	StockBoulangerie.painChocolat -= c.getNbPainChocolat();
	    	return true;
    	} else {
    		return false;
    	}
    }
    
    public String toString() {
    	StringBuilder buf = new StringBuilder();
    	buf.append("Baguette: ");
    	buf.append(getBaguette());
    	buf.append("\n");
    	buf.append("Pain Campagne: ");
    	buf.append(getPainCampagne());
    	buf.append("\n");
    	buf.append("Croissant: ");
    	buf.append(getCroissant());
    	buf.append("\n");
    	buf.append("Pain Chocolat: ");
    	buf.append(getPainChocolat());
    	buf.append("\n");
    	return buf.toString();
    }
}
