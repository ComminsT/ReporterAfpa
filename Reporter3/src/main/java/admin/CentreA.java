package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Centre;
import models.CentreDAO;
import models.Database;
import models.Utilisateur;
import models.UtilisateurDAO;
import verif.Checker;

/**
 * Servlet implementation class Centre
 */
@WebServlet(name = "Centre", urlPatterns = { "/Admin/Centre" })
public class CentreA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CentreA() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession(false) == null) {
		    response.sendRedirect("/Reporter2/Login");
		}else if (!Checker.usercheck(request, 6)) {
			response.sendRedirect("/Reporter2/Login");
		} else {
		Database.Connect();
		if (request.getParameter("newsave") != null) {
			newc(request);
		}
		CentreDAO centredao = new CentreDAO();
		ArrayList<Centre> centres = centredao.getAll();
		for (Centre cc : centres) {

			if (request.getParameter("Modif" + cc.getId()) != null) {
				modif(request,cc.getId());
			} else {
				if (request.getParameter("change" + cc.getId()) != null) {
					System.out.println("Trouvé : " + cc.getId());
					if (cc.getVisible() == 0) {
						cc.setVisible(1);
					} else {
						cc.setVisible(0);
					}
					centredao.save(cc);
				}
			}
		}
		centres = centredao.getAll();

		UtilisateurDAO utilisateurdao = new UtilisateurDAO();
		ArrayList<Utilisateur> users = utilisateurdao.getAllD();

		request.setAttribute("users", users);
		request.setAttribute("centres", centres);
		request.getRequestDispatcher("/Admin/centre.jsp").forward(request, response);}
	}

	private void modif(HttpServletRequest request, int id) {
		// TODO Auto-generated method stub
		
		CentreDAO centredao = new CentreDAO();
		Centre centre = centredao.getById(id);
		centre.setTitre(request.getParameter("newname"));
		centre.setId_utilisateur(Integer.parseInt(request.getParameter("iddirecteur")));
		centredao.save(centre);
		System.out.println("Centre modifié ");
		
		
	}

	private void newc(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CentreDAO centredao = new CentreDAO();
		Centre centre = new Centre(request.getParameter("new"), 1,
				Integer.parseInt(request.getParameter("utilisagteur")));
		centredao.save(centre);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
