package site.commerce.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Produit {
	
	private java.sql.Connection connexion;
	
	public List<site.commerce.beans.Produit> recupererProduit(HttpServletRequest request){ // Fonction pour avoir la liste des produits
		
		//Array des produits
		List<site.commerce.beans.Produit> produits = new ArrayList<site.commerce.beans.Produit>();
		/**
		 * Récupération de l'Id du catégorie 
		 */
		String idCategory = request.getParameter("idCategory");
		int valeurId = Integer.parseInt(idCategory);
		//Chargement driver
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			
		}
		
		//Connexion à la base
		
		java.sql.Statement  statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try{
				
			statement = connexion.createStatement();
			
			java.sql.PreparedStatement prepare = connexion.prepareStatement("SELECT p.NomP, p.MontantVente, f.Nom FROM produits AS p INNER JOIN categories AS c ON p.Categorie = c.Id INNER JOIN fournisseurs AS f ON p.FournisseurP = f.Id WHERE p.Categorie = ?");
					prepare.setInt(1, valeurId);
					resultat = prepare.executeQuery();
			//Récupération des données
			while(resultat.next()){
				String nom = resultat.getString("p.NomP");
				float  montantVente = resultat.getFloat("p.MontantVente");
				String fournisseur  = resultat.getString("f.Nom");
				
				
				// Instanciation de la classe mor.form.beans.Produit
				site.commerce.beans.Produit produit = new site.commerce.beans.Produit();
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

