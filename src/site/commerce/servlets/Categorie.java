package site.commerce.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.commerce.bdd.Category;
import site.commerce.beans.CategoryProduit;

public class Categorie extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Category tableCategory = new Category();
		request.setAttribute("category", tableCategory.recupererCategory());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp" ).forward( request, response );
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
       CategoryProduit categories = new CategoryProduit();
        categories.setNom(request.getParameter("nom"));
        categories.setDescription(request.getParameter("description"));
        
        Category tableCategory = new Category();
        tableCategory.ajouterCategory(categories);
        
        request.setAttribute("category", tableCategory.recupererCategory());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterCategory.jsp").forward(request, response);
	}

}
