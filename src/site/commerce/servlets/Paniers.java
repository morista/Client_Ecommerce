package site.commerce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Paniers extends HttpServlet {
	
	public static final String NOM_COOKIE = "nomProduit";
	public static final int MAX_AGE_COOKIE = 60*60*24*30 ; // UN MOIS
	public static final String URL_REDIRECTION = "/Ecommerce/accueil";
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nomC = getCookies(request, NOM_COOKIE);
		request.setAttribute("nom", nomC);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/monPanier.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Récupération du nom du produit
		 */
		String nomP = request.getParameter("nomProduit");
		/**
		 * Ajout du nom Produit au cookie
		 */
	//	setCookies(response, NOM_COOKIE, nomP, MAX_AGE_COOKIE);
		String nom = "test";
		String valeur = "ça marche";
		Cookie  test = new Cookie(nom, valeur);
		test.setMaxAge(MAX_AGE_COOKIE);
		response.addCookie(test);
		

			this.getServletContext().getRequestDispatcher("/WEB-INF/monPanier.jsp").forward(request, response);
		
		
	}
	/**
	 * Méthode pour ajouter un cookie 
	 * @param response
	 * @param nom
	 * @param valeur
	 * @param vieMax
	 */
	private static void setCookies(HttpServletResponse response, String nom, String valeur, int vieMax){
		
		Cookie cookies = new Cookie(nom, valeur);
			cookies.setMaxAge(vieMax);
			response.addCookie(cookies);
	}
	/**
	 * Methode pour récupérer un cookie
	 * @param request
	 * @param nom
	 * @return
	 */
	private static String getCookies(HttpServletRequest request, String nom){
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals(NOM_COOKIE) ){
					return cookie.getValue();
				}
			}
		}
		return null;
	}

}
