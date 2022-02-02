package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Canal;
import models.CanalDAO;
import models.Canal_com;
import models.Database;
import verif.Checker;

/**
 * Servlet implementation class Canal
 */
@WebServlet(name = "Canal", urlPatterns = { "/Admin/Canal" })
public class CanalA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CanalA() {
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
		CanalDAO cdao = new CanalDAO();
		ArrayList<Canal> canals = cdao.getAllRaw();
		for (Canal cc : canals) {
			if (request.getParameter("change" + cc.getId()) != null) {
				System.out.println("Trouvé : " + cc.getId());
				if (cc.getVisible() == 0) {
					cc.setVisible(1);
				} else {
					cc.setVisible(0);
				}
				cdao.save(cc);
			}
		}
		canals = cdao.getAllRaw();

		
		request.setAttribute("canals", canals);
		request.getRequestDispatcher("/Admin/canal.jsp").forward(request, response);}
	}

	private void newc(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CanalDAO canaldao = new CanalDAO();
		Canal canal = new Canal(request.getParameter("new"), 1);
		canaldao.save(canal);
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
