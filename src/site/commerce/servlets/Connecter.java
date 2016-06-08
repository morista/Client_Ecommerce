package site.commerce.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.commerce.beans.Utilisateur;
import site.commerce.form.ConnexionForm;


public class Connecter extends HttpServlet {
	
	public static final String SESSION_USER = "userSession";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/connecter.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        ConnexionForm form = new ConnexionForm();
      
        Utilisateur utilisateur = form.connecterUtilisateur( request );
        HttpSession session = request.getSession();

        
        if(form.getErreurs().isEmpty()){
        	session.setAttribute(SESSION_USER, utilisateur);
        	this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        }else{
        	session.setAttribute(SESSION_USER, null);
        	this.getServletContext().getRequestDispatcher("/WEB-INF/connecter.jsp").forward(request, response);
        }
        
    	//response.sendRedirect(request.getContextPath());
		
	}

}
