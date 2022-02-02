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
import models.Plan_marche;
import models.Plan_marcheDAO;
import verif.Checker;

/**
 * Servlet implementation class Plan_marche
 */
@WebServlet(name = "Plan_marche", urlPatterns = { "/Admin/Plan_marche" })
public class Plan_marcheA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Plan_marcheA() {
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
			newpm(request);
		}
		
		
		Plan_marcheDAO pmdao = new Plan_marcheDAO();
		ArrayList<Plan_marche> pm= pmdao.getAllRaw();
		for (Plan_marche cc : pm) {
				if (request.getParameter("change" + cc.getId()) != null) {
					System.out.println("Trouvé : " + cc.getId());
					if (cc.getVisible() == 0) {
						cc.setVisible(1);
					} else {
						cc.setVisible(0);
					}
					pmdao.save(cc);
				}
			
		}
		pm= pmdao.getAllRaw();
		
		request.setAttribute("pm", pm);
		request.getRequestDispatcher( "/Admin/plan_marche.jsp" ).forward( request, response );}
	}


	private void newpm(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Plan_marcheDAO planmarchedao = new Plan_marcheDAO();
		Plan_marche pmarche = new Plan_marche(request.getParameter("new"),1);
		planmarchedao.save(pmarche);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
