package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ActionDAO {
	public void save(Action a) {

		try {

			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE action set theme=?,semaine=?,status=?,type=?,relance=?,id_dispo=?,id_plan=?,id_ssecteur=?,id_cible=?,id_result=?,id_positionnement=? WHERE id=?");
				preparedStatement.setString(1, a.getTheme());
				preparedStatement.setInt(2, a.getSemaine());
				preparedStatement.setInt(3, a.getStatus());
				preparedStatement.setInt(4, a.getType());
				preparedStatement.setInt(5, a.getRelance());
				preparedStatement.setInt(6, a.getId_dispo());
				preparedStatement.setInt(7, a.getId_plan());
				preparedStatement.setInt(8, a.getId_ssecteur());
				preparedStatement.setInt(9, a.getId_cible());
				preparedStatement.setInt(10, a.getId_result());
				preparedStatement.setInt(11, a.getId_positionnement());
				preparedStatement.setInt(12, a.getId());

				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO action (theme,semaine,status,type,relance,id_dispo,id_plan,id_ssecteur,id_cible,id_result,id_positionnement) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, a.getTheme());
				preparedStatement.setInt(2, a.getSemaine());
				preparedStatement.setInt(3, a.getStatus());
				preparedStatement.setInt(4, a.getType());
				preparedStatement.setInt(5, a.getRelance());
				preparedStatement.setInt(6, a.getId_dispo());
				preparedStatement.setInt(7, a.getId_plan());
				preparedStatement.setInt(8, a.getId_ssecteur());
				preparedStatement.setInt(9, a.getId_cible());
				preparedStatement.setInt(10, a.getId_result());
				preparedStatement.setInt(11, a.getId_positionnement());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Action getById(int id) {
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM action WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Action a = new Action();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_cible(resultat.getInt("id_cible"));
				a.setId_dispo(resultat.getInt("id_dispo"));
				a.setId_plan(resultat.getInt("id_plan"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_ssecteur(resultat.getInt("id_ssecteur"));
				a.setRelance(resultat.getInt("relance"));
				a.setSemaine(resultat.getInt("semaine"));
				a.setStatus(resultat.getInt("status"));
				a.setTheme(resultat.getString("theme"));
				a.setType(resultat.getInt("type"));
				a.setId_positionnement(resultat.getInt("id_positionnement"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Action> getAll() {
		ArrayList<Action> list = new ArrayList<Action>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM action");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Action a = new Action();
				a.setId(resultat.getInt("id"));
				a.setId_cible(resultat.getInt("id_cible"));
				a.setId_dispo(resultat.getInt("id_dispo"));
				a.setId_plan(resultat.getInt("id_plan"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_ssecteur(resultat.getInt("id_ssecteur"));
				a.setRelance(resultat.getInt("relance"));
				a.setSemaine(resultat.getInt("semaine"));
				a.setStatus(resultat.getInt("status"));
				a.setTheme(resultat.getString("theme"));
				a.setType(resultat.getInt("type"));
				a.setId_positionnement(resultat.getInt("id_positionnement"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	public void deleteById(int id) {
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("DELETE FROM action WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

	public int saveINT (Action a) {
		int newid=0;
		
		
		try {

			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE action set theme=?,semaine=?,status=?,type=?,relance=?,id_dispo=?,id_plan=?,id_ssecteur=?,id_cible=?,id_result=?,id_positionnement=? WHERE id=?");
				preparedStatement.setString(1, a.getTheme());
				preparedStatement.setInt(2, a.getSemaine());
				preparedStatement.setInt(3, a.getStatus());
				preparedStatement.setInt(4, a.getType());
				preparedStatement.setInt(5, a.getRelance());
				preparedStatement.setInt(6, a.getId_dispo());
				preparedStatement.setInt(7, a.getId_plan());
				preparedStatement.setInt(8, a.getId_ssecteur());
				preparedStatement.setInt(9, a.getId_cible());
				preparedStatement.setInt(10, a.getId_result());
				preparedStatement.setInt(11, a.getId_positionnement());
				preparedStatement.setInt(12, a.getId());
				newid=a.getId();

				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO action (theme,semaine,status,type,relance,id_dispo,id_plan,id_ssecteur,id_cible,id_result,id_positionnement) VALUES(?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, a.getTheme());
				preparedStatement.setInt(2, a.getSemaine());
				preparedStatement.setInt(3, a.getStatus());
				preparedStatement.setInt(4, a.getType());
				preparedStatement.setInt(5, a.getRelance());
				preparedStatement.setInt(6, a.getId_dispo());
				preparedStatement.setInt(7, a.getId_plan());
				preparedStatement.setInt(8, a.getId_ssecteur());
				preparedStatement.setInt(9, a.getId_cible());
				preparedStatement.setInt(10, a.getId_result());
				preparedStatement.setInt(11, a.getId_positionnement());
				preparedStatement.executeUpdate();
				
				ResultSet resultat = preparedStatement.getGeneratedKeys();
	            resultat.next();
	            newid= resultat.getInt(1) ;
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}
		return newid;
	}
	public ArrayList<Action> getBySemaine(int weeknbr, int year) {
		ArrayList<Action>actions=new ArrayList<Action>();
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM action WHERE LEFT(semaine,4)=? AND SUBSTRING(semaine,5)=?");
			preparedStatement.setInt(1, year);
			preparedStatement.setInt(2, weeknbr);
			ResultSet resultat = preparedStatement.executeQuery();
			
			while (resultat.next()) {
				Action a = new Action();
				a.setId(resultat.getInt("id"));
				a.setId_cible(resultat.getInt("id_cible"));
				a.setId_dispo(resultat.getInt("id_dispo"));
				a.setId_plan(resultat.getInt("id_plan"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_ssecteur(resultat.getInt("id_ssecteur"));
				a.setRelance(resultat.getInt("relance"));
				a.setSemaine(resultat.getInt("semaine"));
				a.setStatus(resultat.getInt("status"));
				a.setTheme(resultat.getString("theme"));
				a.setType(resultat.getInt("type"));
				a.setId_positionnement(resultat.getInt("id_positionnement"));
				actions.add(a);
			}
			return actions;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Action> getBySemaineANDplateformeneeded(int weeknbr, int year) {
		ArrayList<Action>actions=new ArrayList<Action>();
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM action WHERE LEFT(semaine,4)=? AND SUBSTRING(semaine,5)=? AND status=2 AND type<>2 ");
			preparedStatement.setInt(1, year);
			preparedStatement.setInt(2, weeknbr);
			ResultSet resultat = preparedStatement.executeQuery();
			
			while (resultat.next()) {
				Action a = new Action();
				a.setId(resultat.getInt("id"));
				a.setId_cible(resultat.getInt("id_cible"));
				a.setId_dispo(resultat.getInt("id_dispo"));
				a.setId_plan(resultat.getInt("id_plan"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_ssecteur(resultat.getInt("id_ssecteur"));
				a.setRelance(resultat.getInt("relance"));
				a.setSemaine(resultat.getInt("semaine"));
				a.setStatus(resultat.getInt("status"));
				a.setTheme(resultat.getString("theme"));
				a.setType(resultat.getInt("type"));
				a.setId_positionnement(resultat.getInt("id_positionnement"));
				actions.add(a);
			}
			return actions;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Action> getBySemaineANDeByDirecteurId(int weeknbr, int year,int id_utilisateur) {
		ArrayList<Action>actions=new ArrayList<Action>();
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM action WHERE LEFT(semaine,4)=? AND SUBSTRING(semaine,5)=? AND status=3 AND id IN(SELECT id_action FROM center_selected WHERE id_centre IN(SELECT id FROM centre WHERE id_utilisateur=?))");
			preparedStatement.setInt(1, year);
			preparedStatement.setInt(2, weeknbr);
			preparedStatement.setInt(3, id_utilisateur);
			
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Action a = new Action();
				a.setId(resultat.getInt("id"));
				a.setId_cible(resultat.getInt("id_cible"));
				a.setId_dispo(resultat.getInt("id_dispo"));
				a.setId_plan(resultat.getInt("id_plan"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_ssecteur(resultat.getInt("id_ssecteur"));
				a.setRelance(resultat.getInt("relance"));
				a.setSemaine(resultat.getInt("semaine"));
				a.setStatus(resultat.getInt("status"));
				a.setTheme(resultat.getString("theme"));
				a.setType(resultat.getInt("type"));
				a.setId_positionnement(resultat.getInt("id_positionnement"));
				actions.add(a);
			}
			return actions;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Action> getAllFromDirecteurId(int id) {
		// TODO Auto-generated method stub
		ArrayList<Action>actions=new ArrayList<Action>();
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM action WHERE status=3 AND id IN(SELECT id_action FROM center_selected WHERE id_centre IN(SELECT id FROM centre WHERE id_utilisateur=?))");
			preparedStatement.setInt(1, id);
			
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Action a = new Action();
				a.setId(resultat.getInt("id"));
				a.setId_cible(resultat.getInt("id_cible"));
				a.setId_dispo(resultat.getInt("id_dispo"));
				a.setId_plan(resultat.getInt("id_plan"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_ssecteur(resultat.getInt("id_ssecteur"));
				a.setRelance(resultat.getInt("relance"));
				a.setSemaine(resultat.getInt("semaine"));
				a.setStatus(resultat.getInt("status"));
				a.setTheme(resultat.getString("theme"));
				a.setType(resultat.getInt("type"));
				a.setId_positionnement(resultat.getInt("id_positionnement"));
				actions.add(a);
			}
			return actions;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Action getByResult_Id(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM action WHERE id_result=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Action a = new Action();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_cible(resultat.getInt("id_cible"));
				a.setId_dispo(resultat.getInt("id_dispo"));
				a.setId_plan(resultat.getInt("id_plan"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_ssecteur(resultat.getInt("id_ssecteur"));
				a.setRelance(resultat.getInt("relance"));
				a.setSemaine(resultat.getInt("semaine"));
				a.setStatus(resultat.getInt("status"));
				a.setTheme(resultat.getString("theme"));
				a.setType(resultat.getInt("type"));
				a.setId_positionnement(resultat.getInt("id_positionnement"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
}
