package site.commerce.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import site.commerce.beans.Client;
import site.commerce.beans.Commande;

public class CreationCommande extends HttpServlet {
    /* Constantes */
    public static final String CHAMP_NOM              = "nomClient";
    public static final String CHAMP_PRENOM           = "prenomClient";
    public static final String CHAMP_ADRESSE          = "adresseClient";
    public static final String CHAMP_TELEPHONE        = "telephoneClient";
    public static final String CHAMP_EMAIL            = "emailClient";
 
    public static final String CHAMP_DATE             = "dateCommande";
    public static final String CHAMP_MONTANT          = "montantCommande";
    public static final String CHAMP_MODE_PAIEMENT    = "modePaiementCommande";
    public static final String CHAMP_STATUT_PAIEMENT  = "statutPaiementCommande";
    public static final String CHAMP_MODE_LIVRAISON   = "modeLivraisonCommande";
    public static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";
 
    public static final String ATT_COMMANDE           = "commande";
    public static final String ATT_MESSAGE            = "message";
    public static final String ATT_ERREUR             = "erreur";
    
    public static final String SESSION_USER = "userSession";
 
    public static final String FORMAT_DATE            = "dd/MM/yyyy HH:mm:ss";
 
    public static final String VUE                    = "/WEB-INF/validerCommande.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
		if (session.getAttribute(SESSION_USER) == null || session.getAttribute(SESSION_USER).equals("")){
			this.getServletContext().getRequestDispatcher( "/WEB-INF/connecter.jsp" ).forward( request, response );
		}
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
		if (session.getAttribute(SESSION_USER) == null || session.getAttribute(SESSION_USER).equals("")){
			this.getServletContext().getRequestDispatcher( "/WEB-INF/connecter.jsp" ).forward( request, response );
		}
		
		
		/*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        String adresse = request.getParameter( CHAMP_ADRESSE );
        String telephone = request.getParameter( CHAMP_TELEPHONE );
        String email = request.getParameter( CHAMP_EMAIL );

        /* Récupération de la date courante */
        DateTime dt = new DateTime();
        /* Conversion de la date en String selon le format choisi */
        DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
        String date = dt.toString( formatter );
        //double montant;
        //try {
        //    /* Récupération du montant */
        //    montant = Double.parseDouble( request.getParameter( CHAMP_MONTANT ) );
        //} catch ( NumberFormatException e ) {
        //    /* Initialisation à -1 si le montant n'est pas un nombre correct */
        //    montant = -1;
        //}
        String modePaiement = request.getParameter( CHAMP_MODE_PAIEMENT );
        String modeLivraison = request.getParameter( CHAMP_MODE_LIVRAISON );

        String message;
        boolean erreur;
        
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty()
                || modePaiement.isEmpty() || modeLivraison.isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerCommande.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'une commande.";
            erreur = true;
        } else {
        	
            site.commerce.bdd.Commande commandeBdd = new site.commerce.bdd.Commande();
            commandeBdd.saveCommande(request);
        	
            message = "Commande créée avec succès !";
            erreur = false;
        }
        
        
        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_ERREUR, erreur );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/WEB-INF/monPanier.jsp" ).forward( request, response );
    	
    }
}