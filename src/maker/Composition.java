package maker;

import exception.CompositionException;

public class Composition {

	protected String nom;
	protected int prix;
	
	private static final String ENTIER_NEGATIF = "La quantité à affecter doit être positive";
	
	protected void paramInvalide() throws CompositionException {
		throw new CompositionException(ENTIER_NEGATIF);
	}

	public Composition() {
		this.nom="";
		this.prix=0;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if(nom != null) {
			this.nom = nom;
		}
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) throws CompositionException {
		if (prix >= 0) {
			this.prix = prix;
		} else {
			paramInvalide();
		}
	}

	public String toString() {
		return nom;
	}

}