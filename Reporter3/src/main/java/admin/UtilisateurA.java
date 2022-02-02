package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Database;
import models.Group_list;
import models.Group_listDAO;
import models.Groupe;
import models.GroupeDAO;
import models.Utilisateur;
import models.UtilisateurDAO;
import verif.Checker;

/**
 * Servlet implementation class Utilisateur
 */
@WebServlet(name = "Utilisateur", urlPatterns = { "/Admin/Utilisateur" })
public class UtilisateurA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurA() {
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
		}else if (!Checker.usercheck(request, 6)) {
			response.sendRedirect("/Reporter2/Login");
		} else {
		Database.Connect();

		UtilisateurDAO utilisateurdao = new UtilisateurDAO();
		ArrayList<Utilisateur> utilisateurs = utilisateurdao.getAll();
		for (Utilisateur u : utilisateurs) {
			if (request.getParameter("grpchange" + u.getId()) != null) {
				grpchange(request, u.getId());
			} else {
				if (request.getParameter("change" + u.getId()) != null) {
					if (u.getActive() == 0) {
						u.setActive(1);

					} else {
						u.setActive(0);
					}
					utilisateurdao.save(u);
				}
			}
		}

		utilisateurs = utilisateurdao.getAll();
		GroupeDAO groupedao = new GroupeDAO();
		ArrayList<Groupe> groupes = groupedao.getAll();

		Group_listDAO glistdao = new Group_listDAO();
		ArrayList<Group_list> glist = glistdao.getAll();

		request.setAttribute("utilisateurs", utilisateurs);
		request.setAttribute("groupes", groupes);
		request.setAttribute("glist", glist);

		request.getRequestDispatcher("/Admin/utilisateur.jsp").forward(request, response);}
	}

	private void grpchange(HttpServletRequest request, int id) {
		// TODO Auto-generated method stub
		Database.Connect();
		Group_listDAO glistdao = new Group_listDAO();
		ArrayList<Group_list> group_list = glistdao.getAllFromUtilisateurId(id);
		if (group_list.size() != 0) {
			for (Group_list gl : group_list) {
				glistdao.deleteById(gl.getId());
			}

		}
		Group_list group_list2 = new Group_list(Integer.parseInt(request.getParameter("idgrp" + id)), id);
		glistdao.save(group_list2);

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
