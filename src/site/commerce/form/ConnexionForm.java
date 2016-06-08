package site.commerce.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import site.commerce.beans.Utilisateur;

public final class ConnexionForm {
	
    private static final String CHAMP_LOGIN  	= "login";
    private static final String CHAMP_PASS   	= "motdepasse";
    
    private Connection connexion;
    private String  resultat;

    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur( HttpServletRequest request )  {

        String login = getValeurChamp( request, CHAMP_LOGIN );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        Utilisateur utilisateur = new Utilisateur();
		
		java.sql.Statement  statement = null;
		ResultSet resultats = null;
		loadDatabase();

		try{	
			statement = connexion.createStatement();
			resultats = statement.executeQuery("SELECT Login, Mdp, TypeU, Nom FROM utilisateurs");

			if (!resultats.isBeforeFirst()) {
				setErreur(CHAMP_LOGIN, "inconnue");
			}
			else
			{
				while(resultats.next()){
	
					String log = resultats.getString("Login");
					String pass = resultats.getString("Mdp");
					String Nom = resultats.getString("Nom");
					int typeU = resultats.getInt("TypeU");
					try{
						validation(login, log, motDePasse, pass);
			            utilisateur.setLogin(login);
			            utilisateur.setMotDePasse(motDePasse);
			            utilisateur.setTypeU(typeU);
			            utilisateur.setNom(Nom);
						this.erreurs = new HashMap<String, String>();
						break;
					}catch(Exception e){
						setErreur(CHAMP_LOGIN, e.getMessage());
					}      
			    
				}
			}
		}
		catch(SQLException e){
		
			} finally {

				try{
					if(resultats != null) resultats.close();
					if(statement != null) statement.close();
					if(connexion != null) connexion.close();
				}catch(SQLException ignore){
					
				}
			}
		return utilisateur;
    }
    
    private void validation(String log, String log1, String pass, String pass1) throws Exception {
    	if(!log.equals(log1) || !pass.equals(pass1)){
    		throw new Exception("Erreur!");
    	}
    }

    
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    

    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
	private void loadDatabase() {

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