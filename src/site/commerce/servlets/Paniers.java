package site.commerce.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import site.commerce.bdd.Produit;
import site.commerce.beans.PanierArticles;


public class Paniers extends HttpServlet {
	
	public static final String NOM_SESSION = "produitPanier";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/monPanier.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("idP") != null){
			
			HttpSession session = request.getSession();
			List<PanierArticles> listPanierArticlesBeans;
			
			PanierArticles panierArticlesBeans = new PanierArticles();
			boolean alreadyIn = false;
			
			//recupere un article avec l'id du request
			site.commerce.bdd.Produit produitBdd = new Produit();
			site.commerce.beans.Produit produitBeans = produitBdd.recupererUnProduit(request);
			
			panierArticlesBeans.setProduit(produitBeans);
			panierArticlesBeans.setQuantite(1);
			
			
			if (session.getAttribute(NOM_SESSION) == null || session.getAttribute(NOM_SESSION).equals("")){
				listPanierArticlesBeans = new ArrayList<site.commerce.beans.PanierArticles>();
			}
			else{
				listPanierArticlesBeans =  (List<PanierArticles>) session.getAttribute(NOM_SESSION);
			}
			
		    for (PanierArticles pA : listPanierArticlesBeans) {
		        if (pA.getProduit().getId() == produitBeans.getId()) {
		        	pA.setQuantite(pA.getQuantite()+1);
		            alreadyIn = true;
		        }
		    }
		    
		    if(!alreadyIn){
		    	listPanierArticlesBeans.add(panierArticlesBeans);
		    }
		    	
			session.setAttribute( NOM_SESSION, listPanierArticlesBeans );
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/monPanier.jsp").forward(request, response);
	}
		

}
