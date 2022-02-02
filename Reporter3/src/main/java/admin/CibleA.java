package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Canal_com;
import models.Cible;
import models.CibleDAO;
import models.Database;
import verif.Checker;

/**
 * Servlet implementation class Cible
 */
@WebServlet(name = "Cible", urlPatterns = { "/Admin/Cible" })
public class CibleA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CibleA() {
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
			newc(request);
		}
		CibleDAO cibledao = new CibleDAO();
		ArrayList<Cible>cibles = cibledao.getAllRAW();
		for(Cible cc : cibles) {
			if(request.getParameter("change"+cc.getId())!=null) {
			System.out.println("Trouvé : "+cc.getId());
			if(cc.getVisible()==0) {
				cc.setVisible(1);
			}else {
				cc.setVisible(0);
			}
					
		}
			cibledao.save(cc);
		}
		cibles=cibledao.getAllRAW();
		
		request.setAttribute("cibles", cibles);
		request.getRequestDispatcher( "/Admin/cible.jsp" ).forward( request, response );}
	}

	private void newc(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CibleDAO cibledao = new CibleDAO();
		Cible cible = new Cible(request.getParameter("new"),1);
		cibledao.save(cible);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
