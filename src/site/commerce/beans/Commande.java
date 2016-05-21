package site.commerce.beans;

public class Commande {
	
	Client client = new Client();
	private double montantCommande;
	private String modePaiement ;
	private String statutPaiement; 
	
	private String statutCommande;
	private String modeLivraison;
	private String statutLivraison;
	private String date; 
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getStatutPaiement() {
		return statutPaiement;
	}
	public void setStatutPaiement(String statutPaiement) {
		this.statutPaiement = statutPaiement;
	}
	public double getMontantCommande() {
		return montantCommande;
	}
	public void setMontantCommande(double montantCommande) {
		this.montantCommande = montantCommande;
	}
	public String getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	public String getStatutCommande() {
		return statutCommande;
	}
	public void setStatutCommande(String statutCommande) {
		this.statutCommande = statutCommande;
	}
	public String getModeLivraison() {
		return modeLivraison;
	}
	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}
	public String getStatutLivraison() {
		return statutLivraison;
	}
	public void setStatutLivraison(String statutLivraison) {
		this.statutLivraison = statutLivraison;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
