package site.commerce.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Produit {
	
	private java.sql.Connection connexion;
	
	public List<site.commerce.beans.Produit> recupererProduit(HttpServletRequest request){ // Fonction pour avoir la liste des produits
		
		//Array des produits
		List<site.commerce.beans.Produit> produits = new ArrayList<site.commerce.beans.Produit>();
		/**
		 * R�cup�ration de l'Id du cat�gorie 
		 */
		String idCategory = request.getParameter("idCategory");
		int valeurId = Integer.parseInt(idCategory);
		//Chargement driver
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			
		}
		
		//Connexion � la base
		
		java.sql.Statement  statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try{
				
			statement = connexion.createStatement();
			
			java.sql.PreparedStatement prepare = connexion.prepareStatement("SELECT p.Id, p.NomP, p.MontantVente, f.Nom FROM produits AS p INNER JOIN categories AS c ON p.Categorie = c.Id INNER JOIN fournisseurs AS f ON p.FournisseurP = f.Id WHERE p.Categorie = ?");
					prepare.setInt(1, valeurId);
					resultat = prepare.executeQuery();
			//R�cup�ration des donn�es
			while(resultat.next()){
				int id = resultat.getInt("p.Id");
				String nom = resultat.getString("p.NomP");
				float  montantVente = resultat.getFloat("p.MontantVente");
				String fournisseur  = resultat.getString("f.Nom");
				
				
				// Instanciation de la classe site.commerce.beans.Produit
				site.commerce.beans.Produit produit = new site.commerce.beans.Produit();
				produit.setId(id);
				produit.setNom(nom);
				produit.setMontantVente(montantVente);
				produit.setFournisseur(fournisseur);
				
				produits.add(produit);
			}
		}catch(SQLException e){
			
		} finally {
			//Fermeture connexion
			try{
				if(resultat != null) resultat.close();
				if(statement != null) statement.close();
				if(connexion != null) connexion.close();
			}catch(SQLException ignore){
				
			}
		}
		
		return produits;
	}
	
	public site.commerce.beans.Produit recupererUnProduit(HttpServletRequest request){ // Fonction pour avoir la liste des produits

		site.commerce.beans.Produit produit = new site.commerce.beans.Produit();

		String idProduit = request.getParameter("idP");
		int valeurId = Integer.parseInt(idProduit);
		//Chargement driver
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			
		}
		
		java.sql.Statement  statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try{
			
			statement = connexion.createStatement();
			
			java.sql.PreparedStatement prepare = connexion.prepareStatement("SELECT p.Id, p.NomP, p.MontantVente, f.Nom FROM produits AS p INNER JOIN categories AS c ON p.Categorie = c.Id INNER JOIN fournisseurs AS f ON p.FournisseurP = f.Id WHERE p.Id = ?");
					prepare.setInt(1, valeurId);
					resultat = prepare.executeQuery();
			//R�cup�ration des donn�es
			while(resultat.next()){
				int id = resultat.getInt("p.Id");
				String nom = resultat.getString("p.NomP");
				float  montantVente = resultat.getFloat("p.MontantVente");
				String fournisseur  = resultat.getString("f.Nom");
				
				
				// Instanciation de la classe site.commerce.beans.Produit
				produit.setId(id);
				produit.setNom(nom);
				produit.setMontantVente(montantVente);
				produit.setFournisseur(fournisseur);
			}
		}catch(SQLException e){
			
		} finally {
			//Fermeture connexion
			try{
				if(resultat != null) resultat.close();
				if(statement != null) statement.close();
				if(connexion != null) connexion.close();
			}catch(SQLException ignore){
				
			}
		}
		
		return produit;
	}
	
    public void ajouterProduit(site.commerce.beans.Produit produits) {
        loadDatabase();
        
        try {
            java.sql.PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO produits(NomP, TypeP, MontantAchat, MontantVente, Vendu, FournisseurP) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, produits.getNom());
            preparedStatement.setString(2, produits.getType());
            preparedStatement.setFloat(3, produits.getMontantAchat());
            preparedStatement.setFloat(4, produits.getMontantVente());
            preparedStatement.setInt(5, produits.getVendu());
            preparedStatement.setString(6, produits.getFournisseur());
  
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstocks", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

