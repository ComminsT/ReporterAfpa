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
import models.Resultat_com;
import models.Resultat_comDAO;
import models.Type;
import models.TypeDAO;
import models.Utilisateur;
import models.UtilisateurDAO;
import verif.Checker;

/**
 * Servlet implementation class Reportingc
 */
@WebServlet(name = "Reportingc", urlPatterns = { "/MarketCom/Reportingc" })
public class Reportingc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportingc() {
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
		}else if (!Checker.usercheck(request, 2)) {
			response.sendRedirect("/Reporter2/Login");
		} else {
		Database.Connect();
		System.out.println("Entree servlet reportingc");
		int id_action = Integer.parseInt(request.getParameter("id"));
		
		ActionDAO actiondao = new ActionDAO();
		Action action = actiondao.getById(id_action);
		
		UtilisateurDAO utilisateurdao = new UtilisateurDAO();
		ArrayList<Utilisateur> users = utilisateurdao.getAllMC();
		
		ResultDAO rdao = new ResultDAO();
		Result result = rdao.getById(action.getId_result());
		
		Canal_com_usedDAO canalcomuseddao = new Canal_com_usedDAO();
		ArrayList<Canal_com_used> ccomused = canalcomuseddao.getByResultcomId(result.getId());
		
		Canal_comDAO canalcomdao = new Canal_comDAO();
		ArrayList<Canal_com>canalcoms=canalcomdao.getAll();
		
		TypeDAO typedao = new TypeDAO();
		ArrayList<Type> types = typedao.getAll();
		
		Resultat_comDAO rcomdao = new Resultat_comDAO();
		Resultat_com resultatcom = rcomdao.getByActionId(id_action);
		
		if (resultatcom.getId() != 0) {
			System.out.println("Action trouvé");
			ccomused = canalcomuseddao.getByResultcomId(resultatcom.getId());

		} else {
			System.out.println("Action non trouvé");
			resultatcom.setId_result(result.getId());
			resultatcom.setEtat(0);
			rcomdao.save(resultatcom);
			System.out.println("Resultat_com enregistré");
		}
		
if(request.getParameter("savenewc")!=null) {
			
			newc(request, resultatcom, result.getId());	
		}


		
		String datedisplayed = "";
		if (result.getDate_envoi() != null) {
			String date[] = result.getDate_envoi().split("-");
			datedisplayed = date[2] + "/" + date[1] + "/" + date[0];
		}
		
		for (Canal_com_used cu : ccomused) {
			int id = cu.getId();
			System.out.println(id);
			if (request.getParameter("deleteactionc" + id) != null) {
				System.out.println("Entree supression");
				canalcomuseddao.deleteById(id);
				
			}
			;
		}
		
		if(request.getParameter("confirm")!=null) {
			savereportc(request, resultatcom, result.getId(),result);
		}
		if(request.getParameter("validate")!=null) {
			savereportc(request, resultatcom, result.getId(),result);
			resultatcom.setEtat(1);
			rcomdao.save(resultatcom);
			action.setStatus(3);
			actiondao.save(action);
			
		}
		
		ccomused = canalcomuseddao.getByResultcomId(resultatcom.getId());
		
		
		
		
		request.setAttribute("types", types);
		request.setAttribute("canalcoms", canalcoms);
		request.setAttribute("date",datedisplayed);
		request.setAttribute("ccomused", ccomused);
		request.setAttribute("result", result);
		request.setAttribute("action", action);
		request.setAttribute("users", users);
		request.getRequestDispatcher("/MarketCom/reportingc.jsp").forward(request, response);
	}}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void savereportc(HttpServletRequest request, Resultat_com resultcom, int id_result, Result result) {
		ResultDAO resultdao = new ResultDAO();
		Canal_com_usedDAO ccomuseddao = new Canal_com_usedDAO();
		ArrayList<Canal_com_used> cused = ccomuseddao.getByResultcomId(resultcom.getId());
		
		
		

		for (Canal_com_used cu : cused) {
			int id = cu.getId();
			int couverture = Integer.parseInt(request.getParameter(String.valueOf(id)));
			cu.setTaux_couverture(couverture);
			ccomuseddao.save(cu);
			System.out.println("MAJ " + cu.getId());
			System.out.println(couverture);
			
		}
		
		result.setVisuel(request.getParameter("visuel"));
		if (Integer.parseInt(request.getParameter("user")) != 0) {
			result.setId_utilisateur(Integer.parseInt(request.getParameter("user")));
		}
		System.out.println("Userset ok");
		
		String denvoi = request.getParameter("date");

		if (denvoi.length() > 1) {
			String[] d = denvoi.split("/");
			denvoi = d[2] + "-" + d[1] + "-" + d[0];

		} else {
			denvoi = null;

		}
		result.setDate_envoi(denvoi);
		resultdao.save(result);
		
		

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

}
