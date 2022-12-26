package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.StockException;
import pizzeria.PizzaMaker;
import pizzeria.Recette;

public class PizzaMakerTest {

	private PizzaMaker pm;
	private Recette r1;
	private Recette r2;


	@BeforeEach
	public void setUp() throws Exception {
		pm = new PizzaMaker();
		
		r1 = new Recette();
		r1.setNom("Pizza Chorizo");
		r1.setNbFrommage(2);
		r1.setNbChampignon(3);
		r1.setNbJambon(0);
		r1.setNbChorizo(4);
		r1.setPrix(11.9);
		
		r2 = new Recette();
		r2.setNom("Pizza Jambon");
		r2.setNbFrommage(2);
		r2.setNbChampignon(3);
		r2.setNbJambon(4);
		r2.setNbChorizo(20);
		r2.setPrix(12.3);
		
	}

	@Test
	public void testAjoutIngStockValeurErrone() throws StockException {
		assertThrows(StockException.class, () -> { pm.ajouterStockIngPizza(4, -1, 3, 5); });
	}
	
	@Test
	public void testFairePizza() {
		pm.ajoutRecette(r1);
		assertEquals(8.1, pm.fairePizza(0, 20));
	}
	
	@Test
	public void testFairePizzaAvecArgentPasAssezEleve() {
		pm.ajoutRecette(r1);
		final int moneyAmount = 5;
		assertTrue(moneyAmount < pm.getToutesRecettes()[0].getPrix());
		assertEquals(moneyAmount, pm.fairePizza(0, moneyAmount));
	}
	
	@Test
	public void testFairePizzaAvecPasAssezIngredients() {
		pm.ajoutRecette(r2);
		assertEquals(20, pm.fairePizza(0, 20));
		
	}
	
	@Test
	public void testFaireDesPizzasJusquaIncapaciteStock() {
		pm.ajoutRecette(r1);
		assertEquals(8.1,pm.fairePizza(0, 20));
		assertEquals(8.1,pm.fairePizza(0, 20));
		assertEquals(8.1,pm.fairePizza(0, 20));
		assertEquals(20,pm.fairePizza(0, 20));
		System.out.println(pm.verifierStockIngPizza());
	}
}
