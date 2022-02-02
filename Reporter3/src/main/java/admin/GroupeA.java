package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Database;
import models.Dispositif_strategique;
import models.Groupe;
import models.GroupeDAO;
import verif.Checker;

/**
 * Servlet implementation class Groupe
 */
@WebServlet(name = "Groupe", urlPatterns = { "/Admin/Groupe" })
public class GroupeA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupeA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession(false) == null) {
		    response.sendRedirect("/Reporter2/Login");
		}else if (!Checker.usercheck(request, 6)) {
			response.sendRedirect("/Reporter2/Login");
		} else {
		Database.Connect();
		if(request.getParameter("newsave")!=null) {
			newgrp(request);
			
		}
		
		GroupeDAO groupedao = new GroupeDAO();
		ArrayList<Groupe>groupes = groupedao.getAll();
		
		request.setAttribute("groupes", groupes);
		request.getRequestDispatcher( "/Admin/groupe.jsp" ).forward( request, response );}
	}

	
	private void newgrp(HttpServletRequest request) {
		// TODO Auto-generated method stub
		GroupeDAO groupedao = new GroupeDAO();
		Groupe groupe = new Groupe(request.getParameter("new"));
		groupedao.save(groupe);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
