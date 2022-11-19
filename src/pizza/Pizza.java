package pizza;

public class Pizza {
	
	private Ingredient ingredients[];
	private Base base;
	private Pate pate;
	private int prix;
	
	public Pizza(Pate pate, Base base, Ingredient[] ingredients, int prix) {
		this.ingredients = ingredients;
		this.base = base;
		this.pate = pate;
		this.prix = prix;
	}
	
	public void listerCompositionPizza() {
		System.out.println("Composition de la pizza :\n Pate: " + pate + ",\n Base: " + base + ",\n Ingredients: ");
		for(int i = 0; i<ingredients.length; i++) {
			System.out.println(ingredients[i] + ",");
		}
	}
}
