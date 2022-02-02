package plateforme;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Action;
import models.ActionDAO;
import models.Database;
import models.Result_btob;
import models.Result_btobDAO;
import models.Result_btoc;
import models.Result_btocDAO;
import models.Result_plateforme;
import models.Result_plateformeDAO;
import models.Utilisateur;
import models.UtilisateurDAO;

/**
 * Servlet implementation class Reporting1
 */
@WebServlet(name = "Reporting", urlPatterns = { "/Plateforme/Reporting" })
public class Reporting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reporting() {
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
		System.out.println("Avant récupération de l'id_action");
		int id_action = Integer.parseInt(request.getParameter("id"));
		ActionDAO actiondao = new ActionDAO();
		Action action = actiondao.getById(id_action);
		if (request.getParameter("save") != null) {
			save(action, request);

		}
		UtilisateurDAO utilisateurdao = new UtilisateurDAO();
		ArrayList<Utilisateur> utilisateurs = utilisateurdao.getAllP();

		request.setAttribute("utilisateurs", utilisateurs);
		request.setAttribute("action", action);

		request.getRequestDispatcher("/Plateforme/reporting2.jsp").forward(request, response);
	}

	private void save(Action action, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Result_plateformeDAO rplateformedao = new Result_plateformeDAO();
		Result_btocDAO rbtocdao = new Result_btocDAO();
		int user = Integer.parseInt(request.getParameter("user"));

		String date = request.getParameter("date");
		if (date.length() > 1) {
			String[] d = date.split("/");
			date = d[2] + "-" + d[1] + "-" + d[0];
		}
		System.out.println("Date : " + date);
		int relance = Integer.parseInt(request.getParameter("nbrcontactrappele"));
		System.out.println("Nbr relance : " + relance);
		int argumente = Integer.parseInt(request.getParameter("nbrcontactargumente"));
		System.out.println("Nbr argumenté : " + argumente);
		int ic = Integer.parseInt(request.getParameter("nbrinscriptionic"));
		System.out.println("Nbr ic " + ic);
		Result_btoc rbtoc = new Result_btoc(relance, argumente, ic);
		int id_rbtoc = rbtocdao.saveINT(rbtoc);
		Result_plateforme rplateforme = new Result_plateforme(date, action.getId_result(), id_rbtoc, user);
		rplateformedao.save(rplateforme);

		if (action.getId_positionnement() == 1) {
			int catalogue = Integer.parseInt(request.getParameter("nbrenvoicatalogue"));
			System.out.println("Nbr catalogue :" + catalogue);
			int evenement = Integer.parseInt(request.getParameter("nbrinscriptionevent"));
			System.out.println("Nbr inscription event : " + evenement);
			int rdv = Integer.parseInt(request.getParameter("nbrrdv"));
			System.out.println("Nbr rdv : " + rdv);
			int devis = Integer.parseInt(request.getParameter("nbrdevis"));
			System.out.println("Nbr devis : " + devis);
			int convention = Integer.parseInt(request.getParameter("nbrconvention"));
			System.out.println("Nbr convention : " + convention);
			String commentaire = request.getParameter("commentaire");
			System.out.println("Commantaire : " + commentaire);
			Result_btobDAO rbtobdao = new Result_btobDAO();
			Result_btob rbtob = new Result_btob(catalogue, evenement, rdv, devis, convention, commentaire, id_rbtoc);
			rbtobdao.save(rbtob);
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
