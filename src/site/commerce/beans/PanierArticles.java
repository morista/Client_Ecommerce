package site.commerce.beans;

public class PanierArticles {

	private Produit produit;
	private int quantite;
	private float prixTotal;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getPrixTotal() {
		return this.produit.getMontantVente() * this.quantite;
	}

}
