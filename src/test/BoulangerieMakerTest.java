package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boulangerie.BoulangerieMaker;
import exception.StockException;
import boulangerie.Commande;

public class BoulangerieMakerTest {

	private BoulangerieMaker bm;
	private Commande c1;
	private Commande c2;


	@BeforeEach
	public void setUp() throws Exception {
		bm = new BoulangerieMaker();
		
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
	public void testAjoutStockValeurErrone() throws StockException {
		assertThrows(StockException.class, () -> { bm.ajouterStockBoulangerie(4, -1, 3, 2); });
	}
	
	@Test
	public void testVendrePain() {
		bm.ajoutCommande(c1);
		assertEquals(2.6, bm.vendrePain(0, 5));
	}
	
	@Test
	public void testPasserCommandeAvecArgentPasAssezEleve() {
		bm.ajoutCommande(c1);
		final int moneyAmount = 2;
		assertTrue(moneyAmount < bm.getToutesCommandes()[0].getPrix());
		assertEquals(moneyAmount, bm.vendrePain(0, moneyAmount));
	}
	
	@Test
	public void testPasserCommandeAvecPasAssezIngredients() {
		bm.ajoutCommande(c2);
		assertEquals(5, bm.vendrePain(0, 5));
	}
	
	@Test
	public void testPasserDesCommandesJusquaIncapaciteStock() {
		bm.ajoutCommande(c1);
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(5,bm.vendrePain(0, 5));
	}
	
	@Test
	public void testAjoutProduitStock() throws StockException {
		bm.ajouterStockBoulangerie(5, 5, 5, 5);
		String stock = buffer(20,20,20,20);
		assertEquals(stock,bm.verifierStockBoulangerie());
	}
	
	@Test
	public void testPasserDesCommandeApresRemplissageDesStock() throws StockException{
		bm.ajoutCommande(c1);
		String stock = buffer(14,20,20,20);
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(5,bm.vendrePain(0, 5));
		bm.ajouterStockBoulangerie(15, 5, 5, 5);
		assertEquals(2.6,bm.vendrePain(0, 5));
		assertEquals(stock,bm.verifierStockBoulangerie());
	}
	
	public String buffer(int baguette, int painCampagne, int croissant, int painChocolat) {
		StringBuilder buffer = new StringBuilder();
    	buffer.append("Baguette: ");
    	buffer.append(baguette);
    	buffer.append("\n");
    	buffer.append("Pain Campagne: ");
    	buffer.append(painCampagne);
    	buffer.append("\n");
    	buffer.append("Croissant: ");
    	buffer.append(croissant);
    	buffer.append("\n");
    	buffer.append("Pain Chocolat: ");
    	buffer.append(painChocolat);
    	buffer.append("\n");
    	return buffer.toString();
	}
}
