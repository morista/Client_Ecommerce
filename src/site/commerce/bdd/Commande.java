package site.commerce.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import site.commerce.beans.CategoryProduit;

public class Commande {
	
	private java.sql.Connection connexion;
	
	public void saveCommande(HttpServletRequest request){
		loadDatabase();
		try {
			java.sql.PreparedStatement preparedStatement = connexion
					.prepareStatement("INSERT INTO panier(UserP) VALUES(?);");

			preparedStatement.setString(1, (String) request.getSession().getAttribute("userSession"));

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
