package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Database;
import models.Sous_secteur;
import models.Type;
import models.TypeDAO;
import verif.Checker;

/**
 * Servlet implementation class Type
 */
@WebServlet(name = "Type", urlPatterns = { "/Admin/Type" })
public class TypeA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeA() {
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
			newt(request);
		}
		
		
		TypeDAO typedao = new TypeDAO();
		ArrayList<Type>types = typedao.getAllRaw();
		for (Type cc : types) {
			if (request.getParameter("change" + cc.getId()) != null) {
				System.out.println("Trouvé : " + cc.getId());
				if (cc.getVisible() == 0) {
					cc.setVisible(1);
				} else {
					cc.setVisible(0);
				}
				typedao.save(cc);
			}
		}	
		
		
		types=typedao.getAllRaw();
		request.setAttribute("types", types);
		request.getRequestDispatcher( "/Admin/type.jsp" ).forward( request, response );}
	}

	private void newt(HttpServletRequest request) {
		// TODO Auto-generated method stub
		TypeDAO typedao = new TypeDAO();
		Type type = new Type(request.getParameter("new"),1);
		typedao.save(type);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
