package test;

import pizza.*;
import machine.*;


public class Test {

	public static void main(String[] args) {
//		Ingredient[] ingredients = new Ingredient[] { Ingredient.OLIVE, Ingredient.JAMBON, Ingredient.FROMAGE };
//		Pizza pizzaTest = new Pizza(Pate.EPAISSE, Base.TOMATE, ingredients , 12.0);
//		pizzaTest.listerCompositionPizza();
		MachineAPizza machine = new MachineAPizza("test");
//		machine.remplirStockArgent();
//		machine.preparerPizzaOceane(11.0);
		machine.preparerPizzaChorizo(13.50);
		machine.getArgent();
	}

}
