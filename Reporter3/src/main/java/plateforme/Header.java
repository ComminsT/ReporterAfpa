package plateforme;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import models.Database;
import models.Utilisateur;

/**
 * Servlet implementation class Header
 */
@WebServlet(name = "Headerpl", urlPatterns = { "/Plateforme/Header" })
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean change=false;
		Boolean problem=false;
		Database.Connect();
		
		HttpSession session = request.getSession(true);
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("currentuser");
		System.out.println(session.getAttribute("isConnected"));
		if (session.getAttribute("isConnected") == null) {
			session.setAttribute("isConnected", false);
		}
		if(request.getParameter("changemdp")!=null) {
			System.out.println("Entrée dans changemdp");
			String cmdp1 = request.getParameter("mdp");
			System.out.println("cmdp="+cmdp1);
			String cmdp=cmdp1+"zack"+(utilisateur.getIdentifiant().length()*5-3);
			String myHash="";
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
				md.update(cmdp.getBytes());
				byte[] digest = md.digest();
				myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			System.out.println("MyHash = "+myHash);
			System.out.println("pwd ="+utilisateur.getPassword());
			if(myHash.equals(utilisateur.getPassword())) {
				System.out.println("EQUALS");
				String newmdp=request.getParameter("newmdp");
				utilisateur.changemdp(newmdp);
			}else {
				System.out.println("NOT EQUALS");
				problem=true;
					
			}
			
			
			
			
		}
			request.getRequestDispatcher("/Plateforme/Header.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
