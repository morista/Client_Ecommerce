package site.commerce.beans;

public class Produit {
	
	private int id;
	private String type;
	private float montantAchat;
	private float montantVente;
	private int vendu;
	private String fournisseur;
	private String nom;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getMontantAchat() {
		return montantAchat;
	}
	public void setMontantAchat(float montantAchat) {
		this.montantAchat = montantAchat;
	}
	public float getMontantVente() {
		return montantVente;
	}
	public void setMontantVente(float montantVente) {
		this.montantVente = montantVente;
	}
	public int getVendu() {
		return vendu;
	}
	public void setVendu(int vendu) {
		this.vendu = vendu;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

}
