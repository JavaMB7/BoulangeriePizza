package maker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boulangerie.BoulangerieMaker;
import exception.StockException;
import boulangerie.Commande;

public class BoulangerieMakerTest {

	private BoulangerieMaker pm;
	private Commande c1;
	private Commande c2;


	@BeforeEach
	public void setUp() throws Exception {
		pm = new BoulangerieMaker();
		
		c1 = new Commande();
		c1.setNom("Baguette x2");
		c1.setNbBaguette(2);
		c1.setNbPainCampagne(0);
		c1.setNbCroissant(0);
		c1.setNbPainChocolat(0);
		c1.setPrix(2.4);
		
		c2 = new Commande();
		c2.setNom("Special Noel");
		c2.setNbBaguette(1);
		c2.setNbPainCampagne(1);
		c2.setNbCroissant(1);
		c2.setNbPainChocolat(16);
		c2.setPrix(4.5);
		
	}

	@Test
	public void testAjoutIngStockValeurErrone() throws StockException {
		assertThrows(StockException.class, () -> { pm.ajouterstockBoulangerie(4, -1, 3, 2); });
	}
	
	@Test
	public void testVendrePain() {
		pm.ajoutCommande(c1);
		assertEquals(2.6, pm.vendrePain(0, 5));
	}
	
	@Test
	public void testFairePizzaAvecArgentPasAssezEleve() {
		pm.ajoutCommande(c1);
		final int moneyAmount = 2;
		assertTrue(moneyAmount < pm.getToutesCommandes()[0].getPrix());
		assertEquals(moneyAmount, pm.vendrePain(0, moneyAmount));
	}
	
	@Test
	public void testFairePizzaAvecPasAssezIngredients() {
		pm.ajoutCommande(c2);
		assertEquals(5, pm.vendrePain(0, 5));
		
	}
	
	@Test
	public void testFaireDesPizzasJusquaIncapaciteStock() {
		pm.ajoutCommande(c1);
		assertEquals(2.6,pm.vendrePain(0, 5));
		assertEquals(2.6,pm.vendrePain(0, 5));
		assertEquals(2.6,pm.vendrePain(0, 5));
		assertEquals(2.6,pm.vendrePain(0, 5));
		assertEquals(2.6,pm.vendrePain(0, 5));
		assertEquals(2.6,pm.vendrePain(0, 5));
		assertEquals(2.6,pm.vendrePain(0, 5));
		assertEquals(5,pm.vendrePain(0, 5));
		System.out.println(pm.verifierstockBoulangerie());
	}
}
