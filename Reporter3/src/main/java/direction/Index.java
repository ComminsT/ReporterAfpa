package direction;

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
import javax.servlet.http.HttpSession;

import models.Action;
import models.ActionDAO;
import models.Database;
import models.Utilisateur;
import verif.Checker;

/**
 * Servlet implementation class IndexDirection
 */
@WebServlet(name = "IndexDirection", urlPatterns = { "/Direction/Index" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
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
		HttpSession session = request.getSession(true);
		Utilisateur utilisateur =(Utilisateur)session.getAttribute("currentuser");
		ActionDAO actiondao = new ActionDAO();
		ArrayList<Action>actions = actiondao.getBySemaineANDeByDirecteurId(weekOfYear, year,utilisateur.getId());
		request.setAttribute("actions", actions);
		request.setAttribute("year", year);
		request.setAttribute("weeknumber", weekOfYear);
		request.getRequestDispatcher( "/Direction/index.jsp" ).forward( request, response );}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
