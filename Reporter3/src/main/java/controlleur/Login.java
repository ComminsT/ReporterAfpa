package controlleur;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import models.Database;
import models.Group_list;
import models.Group_listDAO;
import models.Groupe;
import models.GroupeDAO;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public Login() {
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
		Database.Connect();
		Boolean connectederror = false;
		String identifiant = "";
		String mdp = "";
		UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
		Group_listDAO group_listDAO = new Group_listDAO();
		ArrayList<Group_list> group_list = new ArrayList<Group_list>();
		if (request.getParameter("login") != null) {
			identifiant = request.getParameter("identifiant");
			System.out.println("Identifiant : " + identifiant);
			mdp = request.getParameter("pwd");
			System.out.println("Mdp : " + mdp);
			String password = request.getParameter("pwd");
			String newpass = password + "zack" + (identifiant.length() * 5 - 3);
			///// MD5//////
			String myHash = "";
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
				md.update(newpass.getBytes());
				byte[] digest = md.digest();
				myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			Utilisateur utilisateur = utilisateurDAO.connect(identifiant, myHash);
			
				if (utilisateur.getId() != 0) {
					System.out.println("id_utilisateur" + utilisateur.getId());
					Group_listDAO glistdao = new Group_listDAO();
					ArrayList<Group_list> glist = glistdao.getAllFromUtilisateurId(utilisateur.getId());
					GroupeDAO groupeDAO = new GroupeDAO();
					Groupe groupe = groupeDAO.getById(glist.get(0).getId_groupe());
					HttpSession session = request.getSession(true);
					session.setAttribute("isConnected", true);
					session.setAttribute("currentuser", utilisateur);
					session.setAttribute("usernname", utilisateur.getNom() + " " + utilisateur.getPrenom());
					System.out.println("groupe : " + groupe.getTitre());
					session.setAttribute("groupe", groupe.getTitre());
					session.setAttribute("grouplist", glist);

					System.out.println("utilisateur non null");
					System.out.println("utilisateur id =" + utilisateur.getId());
					group_list = group_listDAO.getAllFromUtilisateurId(utilisateur.getId());
					int id_group = group_list.get(0).getId_groupe();

					if (id_group == 1) {
						response.sendRedirect("Direction/Index");
					} else if (id_group == 2) {
						response.sendRedirect("marketcom/Index");
					} else if (id_group == 3) {
						response.sendRedirect("Plateforme/Index");
					} else if (id_group == 4) {
						response.sendRedirect("Alternance/index.jsp");
					} else if (id_group == 5) {
						response.sendRedirect("Ptp/index.jsp");
					} else if (id_group == 6) {
						response.sendRedirect("Admin/Index");
					}
				} else if (utilisateur.getId() == 0) {
					connectederror = true;
					request.setAttribute("connected", connectederror);
					request.getRequestDispatcher("/Login.jsp").forward(request, response);
				}
			

		} else {

			request.setAttribute("connected", connectederror);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
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
