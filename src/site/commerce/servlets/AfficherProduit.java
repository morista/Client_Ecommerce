
package site.commerce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AfficherProduit extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		site.commerce.bdd.Produit tableProduit = new site.commerce.bdd.Produit();
		
		request.setAttribute("ListProduit", tableProduit.recupererProduit( request));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/afficherProduits.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		site.commerce.beans.Produit produit = new site.commerce.beans.Produit();
		produit.setNom(request.getParameter("nomP"));
		produit.setType(request.getParameter("typeP"));
		produit.setFournisseur(request.getParameter("fournisseur"));
		
		// R�cup�ration montants et nombre vendu:
		float montantAchat;
		float montantVente;
		int vendu;
		
		montantAchat = Float.parseFloat(request.getParameter("montantAchat"));
		montantVente = Float.parseFloat(request.getParameter("montantVente"));
		vendu = Integer.parseInt(request.getParameter("vendu"));
		
		produit.setMontantAchat(montantAchat);
		produit.setMontantVente(montantVente);
		produit.setVendu(vendu);
		
		site.commerce.bdd.Produit tableProduits = new site.commerce.bdd.Produit();
		tableProduits.ajouterProduit(produit);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterProduit.jsp").forward(request, response);
		
	}

}
