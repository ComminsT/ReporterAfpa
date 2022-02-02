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
import models.Sous_secteur;
import models.Sous_secteurDAO;
import verif.Checker;

/**
 * Servlet implementation class Sous_secteur
 */
@WebServlet(name = "Sous_secteur", urlPatterns = { "/Admin/Sous_secteur" })
public class Sous_secteurA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sous_secteurA() {
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
			newss(request);
		}
		
		
		Sous_secteurDAO ssdao = new Sous_secteurDAO();
		ArrayList<Sous_secteur>ss = ssdao.getAllRaw();
		
		for (Sous_secteur cc : ss) {
				if (request.getParameter("change" + cc.getId()) != null) {
					System.out.println("Trouvé : " + cc.getId());
					if (cc.getVisible() == 0) {
						cc.setVisible(1);
					} else {
						cc.setVisible(0);
					}
					ssdao.save(cc);
				}
			}	
		ss = ssdao.getAllRaw();
		request.setAttribute("ss", ss);
		request.getRequestDispatcher( "/Admin/sous_secteur.jsp" ).forward( request, response );}
	}

	private void newss(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		Sous_secteurDAO ssdao = new Sous_secteurDAO();
		Sous_secteur ss = new Sous_secteur(request.getParameter("new"),1);
		ssdao.save(ss);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
