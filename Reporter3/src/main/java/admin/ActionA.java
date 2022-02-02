package admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Action;
import models.ActionDAO;
import models.Canal_com_used;
import models.Canal_com_usedDAO;
import models.Canal_used;
import models.Canal_usedDAO;
import models.Center_selected;
import models.Center_selectedDAO;
import models.Database;
import models.Result_market;
import models.Result_marketDAO;
import models.Result_plateforme;
import models.Result_plateformeDAO;
import models.Resultat_com;
import models.Resultat_comDAO;
import verif.Checker;

/**
 * Servlet implementation class Action
 */
@WebServlet(name = "Action", urlPatterns = { "/admin/Action" })
public class ActionA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionA() {
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
		int weekOfYear=0;
		Date cdate = new Date();
		LocalDate date = LocalDate.of(cdate.getYear(), cdate.getMonth()+1, cdate.getDate());
		int year = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(year);
		if(request.getParameter("semaine")!=null) {
			weekOfYear=Integer.parseInt(request.getParameter("semaine"));
			System.out.println("week of year : "+weekOfYear);
			year=Integer.parseInt(request.getParameter("year"));
		}else {
			weekOfYear = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
			System.out.println(weekOfYear);
		}
		if(weekOfYear>52) {
			weekOfYear=1;
			year+=1;
		}else if(weekOfYear<1) {
			weekOfYear=52;
			year-=1;
		}
		
		if(request.getParameter("delete")!=null) {
			int deletedid=Integer.parseInt(request.getParameter("delete"));
			deleteAction(deletedid);
		}
		ActionDAO actiondao = new ActionDAO();
		ArrayList<Action>actions = actiondao.getAll();
		request.setAttribute("actions", actions);
		request.setAttribute("year", year);
		request.setAttribute("weeknumber", weekOfYear);
		
		
		request.getRequestDispatcher( "/Admin/action.jsp" ).forward( request, response );}
	}

	private void deleteAction(int deletedid) {
		// TODO Auto-generated method stub
		Database.Connect();
		ActionDAO actiondao = new ActionDAO();
		Action action = actiondao.getById(deletedid);
		
		Resultat_comDAO rcomdao= new Resultat_comDAO();
		Resultat_com rcom = rcomdao.getByActionId(action.getId());
		
		Canal_com_usedDAO ccuseddao=new Canal_com_usedDAO();
		ArrayList<Canal_com_used> ccused = ccuseddao.getByResultcomId(rcom.getId());
		
		Result_marketDAO rmarketdao= new Result_marketDAO();
		Result_market rmarket = rmarketdao.getByIdResult(action.getId_result());
		
		Canal_usedDAO cuseddao = new Canal_usedDAO();
		ArrayList<Canal_used>cused = cuseddao.getAllByIdAction(deletedid);
		
		Center_selectedDAO cselecteddao = new Center_selectedDAO();
		ArrayList<Center_selected>cselected=cselecteddao.getAllByIdAction(deletedid);
		
		Result_plateformeDAO rplateformedao = new Result_plateformeDAO();
		ArrayList<Result_plateforme>rplateforme = rplateformedao.getAllByIdAction(deletedid);
		
		
		
		
		
		
		
		
		//Suppression des reporting en premier lieu : 
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
