package site.commerce.beans;

public class Client {
	
	private String nomClient ;
	private String prenomClient;
	private String adresseClient;
	private String telephoneClient;
	private String emailClient;
	
	
	public String getNomClient(){
		return this.nomClient;
	}
	public String getPrenomClient(){
		return this.prenomClient;
	}
	public String getAdresseClient(){
		return this.adresseClient;
	}
	public String getTelephoneClient(){
		return this.telephoneClient;
	}
	public String getEmailClient(){
		return this.emailClient;
	}
	public void setNomClient(String nomClient){
		this.nomClient = nomClient;
	}
	public void setPrenomClient(String prenomClient){
		this.prenomClient = prenomClient;
	}
	public void setAdresseClient(String adresseClient){
		this.adresseClient = adresseClient;
	}
	public void setTelephoneClient(String telephoneClient){
		this.telephoneClient = telephoneClient;
	}
	public void setEmailClient(String emailClient){
		this.emailClient = emailClient;
	}

}
