package pizzeria;

import exception.StockException;

public class StockPizza {
    
    private static int frommage;
    private static int champignon;
    private static int jambon;
    private static int chorizo;
    
    public StockPizza() {
    	setFromage(15);
    	setChampignon(15);
    	setJambon(15);
    	setChorizo(15);
    }
    
    public int getChorizo() {
        return chorizo;
    }
    
    public synchronized int getFromage() {
        return frommage;
    }
    
    public int getChampignon() {
        return champignon;
    }
    
    public int getJambon() {
        return jambon;
    }

    public static void setJambon(int jambon) {
    	if(jambon >= 0) {
    		StockPizza.jambon = jambon;
    	}
    }

    public static void setChampignon(int champignon) {
    	if(champignon >= 0) {
    		StockPizza.champignon = champignon;
    	}
    }
    
    public synchronized void setFromage(int fromage) {
    	if(fromage >= 0) {
    		StockPizza.frommage = fromage;
    	}
    }
    
    public static void setChorizo(int chorizo) {
    	if(chorizo >= 0) {
    		StockPizza.chorizo = chorizo;
    	}
        
    }
    
//    public static void addChorizo(int chorizo) throws IllegalArgumentException {
//		if (chorizo >= 0) {
//			StockPizza.chorizo += chorizo;
//		} else {
//			throw new IllegalArgumentException("Units of chocolate must be a positive integer");
//		}
//    }
    
    public static void add(int quantite, String produit) throws StockException {
		if (quantite >= 0) {
			switch (produit) {
			case "cheese" :
				StockPizza.frommage += quantite;
				break;
			case "chorizo" :
				StockPizza.chorizo += quantite;
				break;
			case "mushroom" :
				StockPizza.champignon += quantite;
				break;
			case "ham" :
				StockPizza.jambon += quantite;
				break;
			default :
				throw new StockException(produit+":ne fait pas partie des éléments à ajouter");
			}	
		} else {
			throw new StockException("La quantité de "+produit+" à ajouter doit avoir une valeur positive");
		}
    }
    
//    public static void addMushroom(int mushroom) throws IllegalArgumentException {
//		if (mushroom >= 0) {
//			StockPizza.mushroom += mushroom;
//		} else {
//			throw new IllegalArgumentException("Units of milk must be a positive integer");
//		}
//    }
//    
//    public static void addHam(int ham) throws IllegalArgumentException {
//		if (ham <= 0) {
//			StockPizza.ham += ham;
//		} else {
//			throw new IllegalArgumentException("Units of sugar must be a positive integer");
//		}
//    }
    
    public boolean assezdIngredients(Recette r) {
        boolean isEnough = true;
        if(StockPizza.frommage < r.getNbFrommage()) {
            isEnough = false;
        }
        if(StockPizza.champignon < r.getNbChampignon()) {
            isEnough = false;
        }
        if(StockPizza.jambon < r.getNbJambon()) {
            isEnough = false;
        }
        if(StockPizza.chorizo < r.getNbChorizo()) {
            isEnough = false;
        }
        return isEnough;
    }
    
    public synchronized void utiliserIngredients(Recette r) {
    	if (assezdIngredients(r)) {
	    	StockPizza.frommage -= r.getNbFrommage();
	    	StockPizza.champignon -= r.getNbChampignon();
	    	StockPizza.jambon -= r.getNbJambon();
	    	StockPizza.chorizo -= r.getNbChorizo();
    	}
    }
    
    public String toString() {
    	StringBuilder buf = new StringBuilder();
    	buf.append("Frommage: ");
    	buf.append(getFromage());
    	buf.append("\n");
    	buf.append("Champignon: ");
    	buf.append(getChampignon());
    	buf.append("\n");
    	buf.append("Jambon: ");
    	buf.append(getJambon());
    	buf.append("\n");
    	buf.append("Chorizo: ");
    	buf.append(getChorizo());
    	buf.append("\n");
    	return buf.toString();
    }
}
