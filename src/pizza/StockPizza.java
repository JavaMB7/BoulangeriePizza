package pizza;


public class StockPizza {
    
    private static int fromage;
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
    
    public int getFromage() {
        return fromage;
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
    
    public static void setFromage(int fromage) {
    	if(fromage >= 0) {
    		StockPizza.fromage = fromage;
    	}
    }
    
    public static void setChorizo(int chorizo) {
    	if(chorizo >= 0) {
    		StockPizza.chorizo = chorizo;
    	}
        
    }
    
//    public static void addChorizo(int chorizo) throws IllegalArgumentException {
//		if (chorizo >= 0) {
//			Inventory.chorizo += chorizo;
//		} else {
//			throw new IllegalArgumentException("Units of chocolate must be a positive integer");
//		}
//    }
    
    public static void add(int quantite, String produit) throws IllegalArgumentException {
		if (quantite >= 0) {
			switch (produit) {
			case "cheese" :
				StockPizza.fromage += quantite;
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
				throw new IllegalArgumentException(produit+":ne fait pas partie des éléments à ajouter");
			}	
		} else {
			throw new IllegalArgumentException("La quantité de "+produit+" à ajouter doit avoir une valeur positive");
		}
    }
    
//    public static void addMushroom(int mushroom) throws IllegalArgumentException {
//		if (mushroom >= 0) {
//			Inventory.mushroom += mushroom;
//		} else {
//			throw new IllegalArgumentException("Units of milk must be a positive integer");
//		}
//    }
//    
//    public static void addHam(int ham) throws IllegalArgumentException {
//		if (ham <= 0) {
//			Inventory.ham += ham;
//		} else {
//			throw new IllegalArgumentException("Units of sugar must be a positive integer");
//		}
//    }
    
//    public boolean enoughIngredients(Recipe r) {
//        boolean isEnough = true;
//        if(Inventory.coffee < r.getAmtCoffee()) {
//            isEnough = false;
//        }
//        if(Inventory.milk < r.getAmtMilk()) {
//            isEnough = false;
//        }
//        if(Inventory.sugar < r.getAmtSugar()) {
//            isEnough = false;
//        }
//        if(Inventory.chocolate < r.getAmtChocolate()) {
//            isEnough = false;
//        }
//        return isEnough;
//    }
    
//    public boolean useIngredients(Recipe r) {
//    	if (enoughIngredients(r)) {
//	    	Inventory.coffee -= r.getAmtCoffee();
//	    	Inventory.milk -= r.getAmtMilk();
//	    	Inventory.sugar -= r.getAmtSugar();
//	    	Inventory.chocolate -= r.getAmtChocolate();
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
}
