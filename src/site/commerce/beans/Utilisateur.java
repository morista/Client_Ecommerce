package site.commerce.beans;

public class Utilisateur {
	
	private String nom;
	private String motDePasse;
	private String login;
	private int typeU; 
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}	
	public int getTypeU() {
		return typeU;
	}
	public void setTypeU(int typeU) {
		this.typeU = typeU;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	

}
