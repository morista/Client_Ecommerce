package site.commerce.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.commerce.beans.CategoryProduit;

public class Category {
	
	private java.sql.Connection connexion;
	
	public List<CategoryProduit> recupererCategory(){
		List<CategoryProduit> category = new ArrayList<CategoryProduit>();
		
		//Connexion a la base
		
		java.sql.Statement  statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try{
				
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT  Id, Nom, Description FROM categories");
			
			//R�cup�ration des donn�es
			while(resultat.next()){
				int id 		= resultat.getInt("Id");
				String nom = resultat.getString("Nom");
				String description = resultat.getString("Description");
				
				CategoryProduit categorie = new CategoryProduit();
				categorie.setNom(nom);
				categorie.setDescription(description);
				categorie.setId(id);
				
				category.add(categorie);
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
		
		return category;
	}
	
    public void ajouterCategory(CategoryProduit category) {
        loadDatabase();
        
        try {
            java.sql.PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO categories(Nom, Description) VALUES(?, ?);");
            preparedStatement.setString(1, category.getNom());
            preparedStatement.setString(2, category.getDescription());
  
            
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
