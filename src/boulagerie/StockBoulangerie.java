package boulagerie;

import exception.RecetteException;
import exception.StockException;

public class StockBoulangerie {
    
    private static int frommage;
    private static int champignon;
    private static int jambon;
    private static int chorizo;
    
    public StockBoulangerie() {
    	setBaguette(15);
    	setPainCampagne(15);
    	setCroissant(15);
    	setPainChocolat(15);
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
    		StockBoulangerie.jambon = jambon;
    	}
    }

    public static void setChampignon(int champignon) {
    	if(champignon >= 0) {
    		StockBoulangerie.champignon = champignon;
    	}
    }
    
    public synchronized void setFromage(int fromage) {
    	if(fromage >= 0) {
    		StockBoulangerie.frommage = fromage;
    	}
    }
    
    public static void setChorizo(int chorizo) {
    	if(chorizo >= 0) {
    		StockBoulangerie.chorizo = chorizo;
    	}
        
    }
    
    public void add(int quantite, String produit) throws StockException {
		if (quantite >= 0) {
			switch (produit) {
			case "frommage" :
				StockBoulangerie.frommage += quantite;
				break;
			case "chorizo" :
				StockBoulangerie.chorizo += quantite;
				break;
			case "champignon" :
				StockBoulangerie.champignon += quantite;
				break;
			case "jambon" :
				StockBoulangerie.jambon += quantite;
				break;
			default :
				throw new StockException(produit+":ne fait pas partie des éléments à ajouter");
			}	
		} else {
			throw new StockException("La quantité de "+produit+" à ajouter doit avoir une valeur positive");
		}
    }
    
    
//    public boolean assezdIngredients(Recette r) {
//        boolean isEnough = true;
//        if(StockIngPizza.frommage < r.getNbFrommage()) {
//            isEnough = false;
//        }
//        if(StockIngPizza.champignon < r.getNbChampignon()) {
//            isEnough = false;
//        }
//        if(StockIngPizza.jambon < r.getNbJambon()) {
//            isEnough = false;
//        }
//        if(StockIngPizza.chorizo < r.getNbChorizo()) {
//            isEnough = false;
//        }
//        return isEnough;
//    }
//    
//    public synchronized boolean utiliserIngredients(Recette r) {
//    	if (assezdIngredients(r)) {
//	    	StockIngPizza.frommage -= r.getNbFrommage();
//	    	StockIngPizza.champignon -= r.getNbChampignon();
//	    	StockIngPizza.jambon -= r.getNbJambon();
//	    	StockIngPizza.chorizo -= r.getNbChorizo();
//	    	return true;
//    	} else {
//    		return false;
//    	}
//    }
    
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
    
//    public static void main(String[] args) throws StockException, RecetteException {
//		StockIngPizza stock = new StockIngPizza();
//		System.out.println(stock.toString());
//		
//		Recette r1;
//		// Set up for r1
//				r1 = new Recette();
//				r1.setNom("Coffee");
//				r1.setNbChorizo(4);
//				r1.setNbChampignon(3);
//				r1.setNbFrommage(6);
//				r1.setNbJambon(0);
//				r1.setPrix(14);
//		try {
//			stock.add(5, "frommage");
//			stock.add(5, "champignon");
//			stock.add(5, "jambon");
//			stock.add(5, "chorizo");
//		} catch (StockException e) {
//			throw new StockException("Erreur");
//		}
//		System.out.println(stock.toString());
//		System.out.println(stock.assezdIngredients(r1));
//		stock.utiliserIngredients(r1);
//		System.out.println(stock.toString());
//	}
}
