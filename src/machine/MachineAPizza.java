package machine;

import pizza.*;

public class MachineAPizza {
	
	private double stockArgent = 0.0;
	private Ingredient[] stockIngredients = new Ingredient[50];
	private Pate[] stockPates = new Pate[50];
	private Base[] stockBases = new Base[50];
	private int nbIngredients = 0;
	private int nbPates = 0;
	private int nbBases = 0;
	private String nom;
	
	public MachineAPizza(String nom) {
		this.nom = nom;
	}
	
	public void remplirStockArgent() {
		if (stockArgent == 0) {
			stockArgent = 25.0;
		} else {
			System.out.println("La machine possède encore " + stockArgent + "euros, il n'y a pas besoin de le remplir");
		}
	}
	
	public void preparerPizzaOceane(double montant) {
		Ingredient[] ingredient = { Ingredient.OLIVE, Ingredient.SAUMON, Ingredient.FROMAGE };
		Pizza oceane = new Pizza(Pate.FINE, Base.TOMATE, ingredient , 12.0); 
		if(verifierMontant(oceane, montant)) {
			System.out.println("Voici votre pizza oceane !");
		}
	}
	
	public void preparerPizzaChorizo(double montant) {
		assert (montant > 0);
		Ingredient[] ingredient = { Ingredient.CHORIZO, Ingredient.FROMAGE };
		Pizza chorizo = new Pizza(Pate.FINE, Base.TOMATE, ingredient , 12.0); 
		if(verifierMontant(chorizo, montant)) {
			System.out.println("Voici votre pizza chorizo !");
		}
	}

	private boolean verifierMontant(Pizza pizza, double montant) {
		boolean verif = false;
		if (montant > pizza.getPrix() && stockArgent > montant-pizza.getPrix()) {
			stockArgent += montant - (montant-pizza.getPrix());
			System.out.println("Voici votre monnaie : " + (montant-pizza.getPrix()) + " euros");
			verif = true;
		} else if (montant < pizza.getPrix()) {
			System.out.println("Le montant que vous avez donné est insuffisant");
		} else if (stockArgent < montant-pizza.getPrix()) {
			System.out.println("Nous avons pas assez de monnaie. Voici donc votre argent : " + montant + " euros" );
		} else {
			stockArgent = stockArgent + montant;
			verif = true;
		}
		return verif;
	}
	
	public void getArgent() {
		System.out.println(stockArgent);
	}
}
