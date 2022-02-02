package marketcom;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Action;
import models.ActionDAO;
import models.Canal_com;
import models.Canal_comDAO;
import models.Canal_com_used;
import models.Canal_com_usedDAO;
import models.Database;
import models.Result;
import models.ResultDAO;
import models.Result_market;
import models.Result_marketDAO;
import models.Resultat_com;
import models.Resultat_comDAO;
import models.Type;
import models.TypeDAO;
import models.Utilisateur;
import models.UtilisateurDAO;
import verif.Checker;

/**
 * Servlet implementation class Reporting
 */
@WebServlet(name = "Reportingmc", urlPatterns = { "/MarketCom/Reportingmc" })
public class Reportingmc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reportingmc() {
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
		}else if (!Checker.usercheck(request, 2)) {
			response.sendRedirect("/Reporter2/Login");
		} else {
		Database.Connect();

		System.out.println("Entree servlet");
		int id_action = Integer.parseInt(request.getParameter("id"));
		System.out.println("id de l'action : " + id_action);
		ActionDAO actiondao = new ActionDAO();
		Action action = actiondao.getById(id_action);
		Result_marketDAO resultmarketdao = new Result_marketDAO();
		
		
		
		ResultDAO rdao = new ResultDAO();
		Result result = rdao.getById(action.getId_result());
		Result_market rmarket = resultmarketdao.getByIdResult(result.getId());
		
		if(rmarket.getId()==0) {
			System.out.println("sauvegarde du nouveau rmarket");
			rmarket.setId_result(result.getId());
			resultmarketdao.save(rmarket);
			rmarket= resultmarketdao.getByIdResult(result.getId());
			System.out.println("Nouvelle ID"+rmarket.getId());
		}
		UtilisateurDAO utilisateurdao = new UtilisateurDAO();
		ArrayList<Utilisateur> users = utilisateurdao.getAllMC();

		if (request.getParameter("bsavem") != null) {
			System.out.println("entree bsavem");
			savereportm(request, rmarket, result);
			System.out.println("Avant redirection");
		}

		if (request.getParameter("bconfirmm") != null) {
			
			savereportm(request, rmarket, result);
			rmarket.setEtat(1);
			resultmarketdao.save(rmarket);
		}

		String datedisplayed = "";
		if (result.getDate_envoi() != null) {
			String date[] = result.getDate_envoi().split("-");
			datedisplayed = date[2] + "/" + date[1] + "/" + date[0];
		}

		// partie comm

		Resultat_comDAO resultatcomdao = new Resultat_comDAO();

		TypeDAO typedao = new TypeDAO();
		ArrayList<Type> types = typedao.getAll();

		Canal_comDAO ccomdao = new Canal_comDAO();
		ArrayList<Canal_com> ccoms = ccomdao.getAll();

		Resultat_comDAO rcomdao = new Resultat_comDAO();
		Resultat_com resultatcom = rcomdao.getByActionId(id_action);

		Canal_com_usedDAO ccomuseddao = new Canal_com_usedDAO();
		ArrayList<Canal_com_used> ccomused = new ArrayList<Canal_com_used>();

		if (resultatcom.getId() != 0) {
			System.out.println("Action trouvé");
			ccomused = ccomuseddao.getByResultcomId(resultatcom.getId());

		} else {
			System.out.println("Action non trouvé");
			resultatcom.setId_result(result.getId());
			resultatcom.setEtat(0);
			resultatcomdao.save(resultatcom);
			System.out.println("Resultat_com enregistré");
			
		}

		if (request.getParameter("bsavec") != null) {
			savereportc(request, resultatcom, result.getId(),result);

		}
		if (request.getParameter("validatecom") != null) {
			savereportc(request, resultatcom, result.getId(),result);
			System.out.println("ici");
			resultatcom.setEtat(1);
			
			resultatcomdao.save(resultatcom);
			

		}
		if (request.getParameter("savenewc") != null) {
			newc(request, resultatcom, result.getId());
		}

		for (Canal_com_used cu : ccomused) {
			int id = cu.getId();
			System.out.println(id);
			if (request.getParameter("deleteactionc" + id) != null) {
				System.out.println("Entree supression");
				ccomuseddao.deleteById(id);
			}
			;

		}

		ccomused = ccomuseddao.getByResultcomId(resultatcom.getId());
		statecheck(resultatcom,rmarket,action);

		request.setAttribute("ccomused", ccomused);
		request.setAttribute("types", types);
		request.setAttribute("ccoms", ccoms);
		request.setAttribute("date", datedisplayed);
		request.setAttribute("resultat", result);
		request.setAttribute("users", users);
		request.setAttribute("rmarket", rmarket);
		request.setAttribute("action", action);
		request.getRequestDispatcher("/MarketCom/reportingmc.jsp").forward(request, response);
	}}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void savereportm(HttpServletRequest request, Result_market rmarket, Result result) {
		
		ResultDAO rdao = new ResultDAO();
		System.out.println("Entree dans savereportm");
		rmarket.setId_result(result.getId());
		Result_marketDAO rmarketdao = new Result_marketDAO();
		rmarket.setNbr_cliqueurs(Integer.parseInt(request.getParameter("nbrcliqueurs")));
		System.out.println(request.getParameter("nbrcliqueurs"));
		rmarket.setNbr_contactcible(Integer.parseInt(request.getParameter("nbrcontactcible")));
		System.out.println(request.getParameter("nbrcontactcible"));
		rmarket.setNbr_ouvreurs(Integer.parseInt(request.getParameter("nbrouvreurs")));
		System.out.println("ouvreurs: " + request.getParameter("nbrouvreurs"));
		if (Integer.parseInt(request.getParameter("user")) != 0) {
			result.setId_utilisateur(Integer.parseInt(request.getParameter("user")));
		}
		result.setNbr_formulaire(Integer.parseInt(request.getParameter("nbrformulaire")));
		result.setVisuel(request.getParameter("visuel"));

		String denvoi = request.getParameter("denvoi");

		if (denvoi.length() > 1) {
			String[] d = denvoi.split("/");
			denvoi = d[2] + "-" + d[1] + "-" + d[0];

		} else {
			denvoi = null;

		}
		result.setDate_envoi(denvoi);

		rmarketdao.save(rmarket);
		rdao.save(result);

	}

	private void savereportc(HttpServletRequest request, Resultat_com resultcom, int id_result, Result result) {
		ResultDAO rdao = new ResultDAO();
		Canal_com_usedDAO ccomuseddao = new Canal_com_usedDAO();
		ArrayList<Canal_com_used> cused = ccomuseddao.getByResultcomId(resultcom.getId());

		for (Canal_com_used cu : cused) {
			int id = cu.getId();
			int couverture = Integer.parseInt(request.getParameter(String.valueOf(id)));
			cu.setTaux_couverture(couverture);
			ccomuseddao.save(cu);
			System.out.println("MAJ " + cu.getId());
			
		}
		
		result.setNbr_formulaire(Integer.parseInt(request.getParameter("formulairec")));
		rdao.save(result);

	}

	private void newc(HttpServletRequest request, Resultat_com resultcom, int id_result) {
		int type = Integer.parseInt(request.getParameter("typesave"));
		System.out.println("id type : " + type);
		int canal = Integer.parseInt(request.getParameter("canalsave"));
		System.out.println("id canal : " + canal);
		Canal_com_usedDAO cuseddao = new Canal_com_usedDAO();
		Canal_com_used ccused = new Canal_com_used(canal, resultcom.getId(), 0, type, 0);
		cuseddao.save(ccused);
	}
	
	private void statecheck(Resultat_com resultatcom, Result_market rmarket, Action action) {
		// TODO Auto-generated method stub
		System.out.println("rmarketid:"+rmarket.getId());
		if(resultatcom.getEtat()==1&&rmarket.getEtat()==1&&action.getStatus()<2) {
			ActionDAO actiondao = new ActionDAO();
			action.setStatus(2);
			actiondao.save(action);
			
		}
		
		
		
	}

}
