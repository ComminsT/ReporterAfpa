package marketcom;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Action;
import models.ActionDAO;
import models.Canal;
import models.CanalDAO;
import models.Canal_used;
import models.Canal_usedDAO;
import models.Center_selected;
import models.Center_selectedDAO;
import models.Centre;
import models.CentreDAO;
import models.Cible;
import models.CibleDAO;
import models.Database;
import models.Dispositif_strategique;
import models.Dispositif_strategiqueDAO;
import models.Plan_marche;
import models.Plan_marcheDAO;
import models.Positionnement;
import models.PositionnementDAO;
import models.Result;
import models.ResultDAO;
import models.Sous_secteur;
import models.Sous_secteurDAO;
import verif.Checker;

/**
 * Servlet implementation class New
 */
@WebServlet("/New")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public New() {
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
		if (request.getSession(false) == null) {
			response.sendRedirect("/Reporter2/Login");
		} else if (!Checker.usercheck(request, 2)) {
			response.sendRedirect("/Reporter2/Login");
		} else {
			Dispositif_strategiqueDAO dispositifdao = new Dispositif_strategiqueDAO();
			Sous_secteurDAO ssecteurdao = new Sous_secteurDAO();
			Plan_marcheDAO planmarchedao = new Plan_marcheDAO();
			CentreDAO centredao = new CentreDAO();
			CanalDAO canaldao = new CanalDAO();
			PositionnementDAO positionnementdao = new PositionnementDAO();
			CibleDAO cibledao = new CibleDAO();
			Database.Connect();
			ArrayList<Dispositif_strategique> dispos_strat = dispositifdao.getAll();
			ArrayList<Sous_secteur> ssecteur = ssecteurdao.getAll();
			ArrayList<Plan_marche> pmarche = planmarchedao.getAll();
			ArrayList<Centre> centres = centredao.getAll();
			ArrayList<Canal> canal = canaldao.getAll();
			ArrayList<Positionnement> positionnement = positionnementdao.getAll();
			ArrayList<Cible> cibles = cibledao.getAll();

			request.setAttribute("cibles", cibles);
			request.setAttribute("pos", positionnement);
			request.setAttribute("dispo", dispos_strat);
			request.setAttribute("ssecteur", ssecteur);
			request.setAttribute("pmarche", pmarche);
			request.setAttribute("centres", centres);
			request.setAttribute("canal", canal);

			if (request.getParameter("bcreer") != null) {
				System.out.println(request.getParameter("type"));
				newAction(request);

			}
			request.getRequestDispatcher("/MarketCom/nouvelleAction.jsp").forward(request, response);

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

	public static void newAction(HttpServletRequest request) {
		int type = Integer.parseInt(request.getParameter("type"));
		System.out.println("type : " + type);
		String theme = request.getParameter("input_theme");
		System.out.println("theme : " + theme);
		int dispositif = Integer.parseInt(request.getParameter("input_dispo"));
		System.out.println("dispositif strategique : " + dispositif);
		int plan = Integer.parseInt(request.getParameter("input_pmarche"));
		System.out.println("plan de marche : " + plan);
		int ssecteur = Integer.parseInt(request.getParameter("input_ssecteur"));
		System.out.println("sous secteur :" + ssecteur);
		int cible = Integer.parseInt(request.getParameter("input_cible"));
		System.out.println("cible : " + cible);

		ArrayList<Integer> centres = new ArrayList<Integer>();
		String[] stringCentres = request.getParameterValues("centres");
		for (String s : stringCentres) {
			centres.add(Integer.parseInt(s));
		}
		System.out.println("Centres : " + centres);

		String[] stringCanal = request.getParameterValues("canal");
		ArrayList<Integer> canal = new ArrayList<Integer>();
		for (String s : stringCanal) {
			canal.add(Integer.parseInt(s));
		}
		System.out.println("Canal : " + canal);
		int positionnement = Integer.parseInt(request.getParameter("pos"));
		System.out.println("positionnement : " + positionnement);
		String dates = request.getParameter("date");
		String[] datesplit = dates.split("/");
		LocalDate date = LocalDate.of(Integer.parseInt(datesplit[2]), Integer.parseInt(datesplit[1]),
				Integer.parseInt(datesplit[0]));
		int weekOfYear = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		int year = Integer.valueOf(datesplit[2]);
		int week = Integer.valueOf(String.valueOf(year) + String.valueOf(weekOfYear));
		System.out.println("semaine : " + weekOfYear);
		System.out.println("week = " + week);

		ActionDAO actiondao = new ActionDAO();

		ResultDAO resultdao = new ResultDAO();
		if (positionnement != 3) {
			Action action = new Action(theme, week, 0, type, 0, dispositif, plan, ssecteur, cible,
					resultdao.saveINT(new Result()), positionnement);

			int actionid = actiondao.saveINT(action);

			Center_selectedDAO center_selecteddao = new Center_selectedDAO();
			if (!centres.contains(0)) {
				for (Integer c : centres) {
					Center_selected cselected = new Center_selected(c, actionid);
					System.out.println("id_centre : " + c);
					center_selecteddao.save(cselected);
				}
			} else {
				CentreDAO cdao = new CentreDAO();
				ArrayList<Centre> liste_centres = cdao.getAll();
				for (Centre c : liste_centres) {
					Center_selected cselected = new Center_selected(c.getId(), actionid);
					System.out.println("id_centre : " + c.getId());
					center_selecteddao.save(cselected);
				}

			}

			Canal_usedDAO canaluseddao = new Canal_usedDAO();

			for (Integer c : canal) {
				Canal_used cused = new Canal_used(c, actionid);
				System.out.println("id_canal : " + c);
				canaluseddao.save(cused);
			}
		}else if(positionnement==3) {
			Action action = new Action(theme, week, 0, type, 0, dispositif, plan, ssecteur, cible,
					resultdao.saveINT(new Result()), 1);
			Action action2 = new Action(theme, week, 0, type, 0, dispositif, plan, ssecteur, cible,
					resultdao.saveINT(new Result()), 2);

			int actionid = actiondao.saveINT(action);
			int actionid2 = actiondao.saveINT(action2);

			Center_selectedDAO center_selecteddao = new Center_selectedDAO();
			if (!centres.contains(0)) {
				for (Integer c : centres) {
					Center_selected cselected = new Center_selected(c, actionid);
					System.out.println("id_centre : " + c);
					center_selecteddao.save(cselected);
					cselected = new Center_selected(c, actionid2);
					System.out.println("id_centre : " + c);
					center_selecteddao.save(cselected);
				}
			} else {
				CentreDAO cdao = new CentreDAO();
				ArrayList<Centre> liste_centres = cdao.getAll();
				for (Centre c : liste_centres) {
					Center_selected cselected = new Center_selected(c.getId(), actionid);
					
					System.out.println("id_centre : " + c.getId());
					center_selecteddao.save(cselected);
					 cselected = new Center_selected(c.getId(), actionid2);
					 center_selecteddao.save(cselected);
				}

			}

			Canal_usedDAO canaluseddao = new Canal_usedDAO();

			for (Integer c : canal) {
				Canal_used cused = new Canal_used(c, actionid);
				System.out.println("id_canal : " + c);
				canaluseddao.save(cused);
				cused = new Canal_used(c, actionid2);
				canaluseddao.save(cused);
			}
			
		}

	}

}
