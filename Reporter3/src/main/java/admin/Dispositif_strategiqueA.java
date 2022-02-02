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
import models.Dispositif_strategiqueDAO;
import verif.Checker;

/**
 * Servlet implementation class Dispositif_strategique
 */
@WebServlet(name = "Dispositif_strategique", urlPatterns = { "/Admin/Dispositif_strategique" })
public class Dispositif_strategiqueA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dispositif_strategiqueA() {
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
		if(request.getParameter("newsave")!=null) {
			newds(request);
		}
		Dispositif_strategiqueDAO ddao = new Dispositif_strategiqueDAO();
		ArrayList<Dispositif_strategique> ds = ddao.getAllRAW();

		for (Dispositif_strategique cc : ds) {
			if (request.getParameter("new" + cc.getId()) != null) {
				newds(request);
			} else {

				if (request.getParameter("change" + cc.getId()) != null) {
					System.out.println("Trouvé : " + cc.getId());
					if (cc.getVisible() == 0) {
						cc.setVisible(1);
					} else {
						cc.setVisible(0);
					}
					ddao.save(cc);
				}
			}
		}
		ds = ddao.getAllRAW();

		request.setAttribute("ds", ds);
		request.getRequestDispatcher("/Admin/dispositif_strategique.jsp").forward(request, response);}
	}

	private void newds(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Dispositif_strategiqueDAO dsdao = new Dispositif_strategiqueDAO();
		Dispositif_strategique ds = new Dispositif_strategique(request.getParameter("new"), 1);
		dsdao.save(ds);	}

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
