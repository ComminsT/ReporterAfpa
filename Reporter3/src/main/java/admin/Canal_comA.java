package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Canal_com;
import models.Canal_comDAO;
import models.Database;
import verif.Checker;

/**
 * Servlet implementation class Canal_com
 */
@WebServlet(name = "Canal_com", urlPatterns = { "/Admin/Canal_com" })
public class Canal_comA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Canal_comA() {
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
		Canal_comDAO ccomdao= new Canal_comDAO();
		ArrayList<Canal_com>ccom=ccomdao.getAllRaw();
		
		
		for(Canal_com cc : ccom) {
			if(request.getParameter("change"+cc.getId())!=null) {
			System.out.println("Trouvé : "+cc.getId());
			if(cc.getVisible()==0) {
				cc.setVisible(1);
			}else {
				cc.setVisible(0);
			}
				ccomdao.save(cc);	
		}	
		}
		ccom=ccomdao.getAllRaw();
		request.setAttribute("ccom", ccom);
		request.getRequestDispatcher( "/Admin/canal_com.jsp" ).forward( request, response );}
	}

	private void newc(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Canal_comDAO ccdao = new Canal_comDAO();
		Canal_com ccom = new Canal_com(request.getParameter("new"),1);
		ccdao.save(ccom);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
