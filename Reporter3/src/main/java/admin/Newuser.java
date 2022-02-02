package admin;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import models.Database;
import models.Group_list;
import models.Group_listDAO;
import models.Groupe;
import models.GroupeDAO;
import models.Utilisateur;
import models.UtilisateurDAO;
import verif.Checker;

/**
 * Servlet implementation class Newuser
 */
@WebServlet(name = "newUser  ", urlPatterns = { "/Admin/NouvelUtilisateur" })
public class Newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newuser() {
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
		if(request.getParameter("save")!=null) {
			newUser(request);
		}
		Database.Connect();
		
		GroupeDAO gdao = new GroupeDAO();
		ArrayList<Groupe>groupes = gdao.getAll();
		
		
		
		request.setAttribute("groupes",groupes);
		request.getRequestDispatcher( "/Admin/newuser.jsp" ).forward( request, response );}
	}
	
	private void newUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Group_listDAO glistdao = new Group_listDAO();
		Group_list glist = new Group_list();
		UtilisateurDAO udao = new UtilisateurDAO();
		Utilisateur utilisateur= new Utilisateur();
		utilisateur.setIdentifiant(request.getParameter("identifiant"));
		utilisateur.setMail(request.getParameter("mail"));
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		
		String password = request.getParameter("password");
		String identifiant = request.getParameter("identifiant");
		String newpass=password+"zack"+(identifiant.length()*5-3);
		/////MD5//////
		String myHash="";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(newpass.getBytes());
			byte[] digest = md.digest();
			myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		/////MD5//////
		
		
		utilisateur.setActive(1);	
		utilisateur.setPassword(myHash);
		int id=udao.saveINT(utilisateur);
		glist.setId_utilisateur(id);
		System.out.println("id groupe type : "+request.getParameter("type"));
		glist.setId_groupe(Integer.parseInt(request.getParameter("type")));
		glistdao.save(glist);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
