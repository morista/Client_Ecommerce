package site.commerce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import site.commerce.beans.PanierArticles;



public class SupprimeArticle extends HttpServlet{
	
	public static final String NOM_SESSION = "produitPanier";
	public static final String URL_REDIRECTION="/Client_Ecommerces/monPanier";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PanierArticles> listPanierArticlesBeans = new ArrayList<PanierArticles>();
		HttpSession session = request.getSession();
		String idProduit = request.getParameter("idProduit");
		int valeurId = Integer.parseInt(idProduit);
		
		List<PanierArticles>  listPanierArticlesBeansSession = (List<PanierArticles>) session.getAttribute(NOM_SESSION);
		
	    for (PanierArticles pA : listPanierArticlesBeansSession) {
	        if (pA.getProduit().getId() != valeurId) {
	        	listPanierArticlesBeans.add(pA);
	        }
	    }
		
	    session.setAttribute( NOM_SESSION, listPanierArticlesBeans );
		
		response.sendRedirect(URL_REDIRECTION);
	}
	
}