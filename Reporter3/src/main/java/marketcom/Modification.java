package marketcom;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
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
import models.Sous_secteur;
import models.Sous_secteurDAO;
import verif.Checker;

/**
 * Servlet implementation class Modification
 */
@WebServlet(name = "Modification", urlPatterns = { "/MarketCom/Modification" })
public class Modification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modification() {
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
		System.out.println(request.getParameter("id"));
		int id_action = Integer.parseInt(request.getParameter("id"));
		System.out.println(id_action);
		ActionDAO actiondao = new ActionDAO();
		Action action = actiondao.getById(id_action);
		Dispositif_strategiqueDAO dispositifdao = new Dispositif_strategiqueDAO();
		Sous_secteurDAO ssecteurdao = new Sous_secteurDAO();
		Plan_marcheDAO planmarchedao = new Plan_marcheDAO();
		CentreDAO centredao = new CentreDAO();
		CanalDAO canaldao = new CanalDAO();
		PositionnementDAO positionnementdao = new PositionnementDAO();
		CibleDAO cibledao = new CibleDAO();
		Canal_usedDAO cuseddao = new Canal_usedDAO();
		Center_selectedDAO cselectdao = new Center_selectedDAO();

		ArrayList<Canal_used> cused = cuseddao.getAllByIdAction(id_action);
		ArrayList<Canal> canaux = new ArrayList<Canal>();
		for (Canal_used cu : cused) {
			canaux.add(canaldao.getById(cu.getId_canal()));
		}
		ArrayList<Center_selected> cselected = cselectdao.getAllByIdAction(id_action);

		ArrayList<Integer> centress = new ArrayList<Integer>();
		for (Center_selected cs : cselected) {
			centress.add(cs.getId_centre());
		}
		ArrayList<Dispositif_strategique> dispos_strat = dispositifdao.getAll();
		ArrayList<Sous_secteur> ssecteur = ssecteurdao.getAll();
		ArrayList<Plan_marche> pmarche = planmarchedao.getAll();
		ArrayList<Centre> centres = centredao.getAll();
		ArrayList<Canal> canal = canaldao.getAll();
		ArrayList<Positionnement> positionnement = positionnementdao.getAll();
		ArrayList<Cible> cibles = cibledao.getAll();
		String y = String.valueOf(action.getSemaine());
		String year = y.substring(0, 4);
		int semaine = Integer.valueOf(y.substring(4));
		LocalDate desiredDate = LocalDate.now().with(IsoFields.WEEK_OF_WEEK_BASED_YEAR,semaine)
				.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		String dt = String.valueOf(desiredDate);
		String[] date = dt.split("-");
		String ddate = date[2] + "/" + date[1] + "/" + date[0];

		if (request.getParameter("bsave") != null) {
			System.out.println(request.getParameter("type"));
			modifyAction(request, id_action);
			System.out.println("Avant redirection");
			response.sendRedirect("Details?action="+id_action);

		}else {
			request.setAttribute("ddate", ddate);
			request.setAttribute("cs", centress);
			request.setAttribute("cu", canaux);
			request.setAttribute("cibles", cibles);
			request.setAttribute("pos", positionnement);
			request.setAttribute("dispo", dispos_strat);
			request.setAttribute("ssecteur", ssecteur);
			request.setAttribute("pmarche", pmarche);
			request.setAttribute("centres", centres);
			request.setAttribute("canal", canal);
			request.setAttribute("action", action);
			request.getRequestDispatcher("/MarketCom/modification.jsp").forward(request, response);
			
		}

		

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

	public static void modifyAction(HttpServletRequest request, int id) {
		Database.Connect();
		ActionDAO actiondao = new ActionDAO();
		Action action = actiondao.getById(id);
		System.out.println("Debut modifyAction");
		int type = Integer.parseInt(request.getParameter("type"));
		action.setType(type);
		System.out.println("type : " + type);
		String theme = request.getParameter("input_theme");
		action.setTheme(theme);
		System.out.println("theme : " + theme);
		int dispositif = Integer.parseInt(request.getParameter("input_dispo"));
		action.setId_dispo(dispositif);
		System.out.println("dispositif strategique : " + dispositif);
		int plan = Integer.parseInt(request.getParameter("input_pmarche"));
		action.setId_plan(plan);
		System.out.println("plan de marche : " + plan);
		int ssecteur = Integer.parseInt(request.getParameter("input_ssecteur"));
		action.setId_ssecteur(ssecteur);
		System.out.println("sous secteur :" + ssecteur);
		int cible = Integer.parseInt(request.getParameter("input_cible"));
		action.setId_cible(cible);
		System.out.println("cible : " + cible);
		int pos=Integer.parseInt(request.getParameter("pos"));
		action.setId_positionnement(pos);
		
		
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
		System.out.println("DATE DE MODIFICATION : "+dates);
		String[] datesplit = dates.split("/");
		LocalDate date = LocalDate.of(Integer.parseInt(datesplit[2]), Integer.parseInt(datesplit[1]),
				Integer.parseInt(datesplit[0]));
		System.out.println("localdate  :"+date);
		int weekOfYear = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		int year = Integer.valueOf(datesplit[2]);
		int week = Integer.valueOf(String.valueOf(year) + String.valueOf(weekOfYear));
		System.out.println("semaine : " + weekOfYear);
		System.out.println("week = " + week);
		
		action.setSemaine(week);
		action.setId(id);
		actiondao.save(action);

		

		Center_selectedDAO center_selecteddao = new Center_selectedDAO();

		center_selecteddao.deleteAllById(id);
		Canal_usedDAO canaluseddao = new Canal_usedDAO();
		canaluseddao.deleteAllById(id);

		if (!centres.contains(0)) {
			for (Integer c : centres) {
				Center_selected cselected = new Center_selected(c, id);
				System.out.println("id_centre : " + c);
				center_selecteddao.save(cselected);
			}
		} else {
			CentreDAO cdao = new CentreDAO();
			ArrayList<Centre> liste_centres = cdao.getAll();
			for (Centre c : liste_centres) {
				Center_selected cselected = new Center_selected(c.getId(), id);
				System.out.println("id_centre : " + c.getId());
				center_selecteddao.save(cselected);
			}}

		for (Integer c : canal) {
			Canal_used cused = new Canal_used(c, id);
			System.out.println("id_canal : " + c);
			canaluseddao.save(cused);
		}
	}

}
