package pizza;

public class Pizza {
	
	private Ingredient[] ingredients;
	private Base base;
	private Pate pate;
	private int prix;
	
	public Pizza(Ingredient[] ingredients, Base base, Pate pate, int prix) {
		this.ingredients = ingredients;
		this.base = base;
		this.pate = pate;
		this.prix = prix;
	}
}
