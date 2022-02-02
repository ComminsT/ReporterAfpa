package direction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Action;
import models.ActionDAO;
import models.Canal_com_used;
import models.Canal_com_usedDAO;
import models.Database;
import models.Result;
import models.ResultDAO;
import models.Result_btob;
import models.Result_btobDAO;
import models.Result_btoc;
import models.Result_btocDAO;
import models.Result_market;
import models.Result_marketDAO;
import models.Result_plateforme;
import models.Result_plateformeDAO;
import models.Resultat_com;
import models.Resultat_comDAO;
import verif.Checker;

/**
 * Servlet implementation class Details
 */
@WebServlet(name = "DetailsD", urlPatterns = { "/Direction/Details" })
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession(false) == null) {
		    response.sendRedirect("/Reporter/Login");
		}else if (!Checker.usercheck(request, 1)) {
			response.sendRedirect("/Reporter/Login");
		} else {
		System.out.println("Avant récupération de l'id_action");
		int id_action = Integer.parseInt(request.getParameter("action"));
		Database.Connect();
		ActionDAO actiondao = new ActionDAO();
		Action action = actiondao.getById(id_action);
		ResultDAO resultdao = new ResultDAO();
		Result result = resultdao.getById(action.getId_result());
		System.out.println("id result :" + result.getId());

		Resultat_comDAO rcomdao = new Resultat_comDAO();
		Resultat_com rcom = rcomdao.getByActionId(id_action);

		Result_marketDAO rmarketdao = new Result_marketDAO();
		Result_market rmarket = rmarketdao.getByIdResult(result.getId());

		Canal_com_usedDAO ccuseddao = new Canal_com_usedDAO();

		ArrayList<Canal_com_used> ccomused = ccuseddao.getByResultcomId(rcom.getId());

		String datedisplayed = "";
		if (result.getDate_envoi() != null) {
			String date[] = result.getDate_envoi().split("-");
			datedisplayed = date[2] + "/" + date[1] + "/" + date[0];
		}

		System.out.println("rmarketid=" + rmarket.getId());

		if (action.getStatus() == 3) {
			Result_plateformeDAO dao = new Result_plateformeDAO();
			Result_btocDAO rBtocDAO = new Result_btocDAO();
			Result_btobDAO rBtobDAO = new Result_btobDAO();

			ArrayList<Result_plateforme> result_plateforme = dao.getAllByIdAction(id_action);
			Result_btoc rbtoc = new Result_btoc();

			Result_btob rbtob = new Result_btob();
			// Btob
			int rappel = 0;
			int argumente = 0;
			int ic = 0;

			// BtoC
			int catalogue = 0;
			int event = 0;
			int rdv = 0;
			int devis = 0;
			int convention = 0;
			ArrayList<String> commentaires = new ArrayList<String>();

			for (Result_plateforme rp : result_plateforme) {
				rbtoc = rBtocDAO.getById(rp.getId_result_btoc());
				rappel += rbtoc.getNbr_contact_rappel();
				argumente += rbtoc.getNbr_contact_argumente();
				ic += rbtoc.getNbr_inscription_ic();
				if (action.getId_positionnement() == 1) {
					rbtob = rBtobDAO.getByIdBtoc(rbtoc.getId());
					catalogue += rbtob.getEnvoi_catalogue();
					event += rbtob.getInscription_event();
					rdv += rbtob.getNbr_prise_rdv();
					devis += rbtob.getNbr_devis();
					convention += rbtob.getNbr_convention();
					if (rbtob.getCommentaire() != "") {
						commentaires.add(rbtob.getCommentaire());
					}
				}

			}
			request.setAttribute("commentaires", commentaires);
			request.setAttribute("rappel", rappel);
			request.setAttribute("argumente", argumente);
			request.setAttribute("ic", ic);
			request.setAttribute("catalogue", catalogue);
			request.setAttribute("event", event);
			request.setAttribute("rdv", rdv);
			request.setAttribute("devis", devis);
			request.setAttribute("convention", convention);

		}

		request.setAttribute("date", datedisplayed);
		request.setAttribute("ccomused", ccomused);
		request.setAttribute("rcom", rcom);
		request.setAttribute("rmarket", rmarket);
		request.setAttribute("result", result);
		request.setAttribute("action", action);
		request.getRequestDispatcher("/Direction/details.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
