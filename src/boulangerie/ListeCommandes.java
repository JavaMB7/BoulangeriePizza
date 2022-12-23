package boulangerie;

public class ListeCommandes {
	
	private Commande[] tabCommande;
	private static final int NB_COMMANDES = 4;
	
	public ListeCommandes() {
		tabCommande = new Commande[NB_COMMANDES];
	}
	 
	public Commande[] getCommandes() {
		return tabCommande;
	}
	
	public boolean ajouterCommande(Commande c) {

		boolean exists = false;
		for (int i = 0; i < tabCommande.length; i++ ) {
			if (c.equals(tabCommande[i])) {
				exists = true;
			}
		}
		
		boolean added = false;
		if (!exists) {
			for (int i = 0; i < tabCommande.length && !added; i++) {
				if (tabCommande[i] == null) {
					tabCommande[i] = c;
					added = true;
				}
			}
		}
		return added;
	}

	public String supprimerCommande(int commandeASupprimer) {
		if (tabCommande[commandeASupprimer] != null) {
			String nomCommande = tabCommande[commandeASupprimer].getNom();
			tabCommande[commandeASupprimer] = new Commande();
			return nomCommande;
		} else {
			return null;
		}
	}
	
	public synchronized String modifierCommande(int commandeAModifier, Commande nvCommande) {
		if (tabCommande[commandeAModifier] != null) {
			String nomCommande = tabCommande[commandeAModifier].getNom();
			nvCommande.setNom("");
			tabCommande[commandeAModifier] = nvCommande;
			return nomCommande;
		} else {
			return null;
		}
	}

}
