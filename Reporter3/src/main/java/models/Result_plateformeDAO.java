package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Result_plateformeDAO {
	public void save(Result_plateforme a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE resultat_plateforme set date=?,id_result=?,id_result_btoc=?,id_utilisateur=? WHERE id=?");

				preparedStatement.setString(1, a.getDate());
				preparedStatement.setInt(2, a.getId_result());
				preparedStatement.setInt(3, a.getId_result_btoc());
				preparedStatement.setInt(4, a.getId_utilisateur());
				preparedStatement.setInt(5, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO resultat_plateforme (date,id_result,id_result_btoc,id_utilisateur) VALUES(?,?,?,?)");
				preparedStatement.setString(1, a.getDate());
				preparedStatement.setInt(2, a.getId_result());
				preparedStatement.setInt(3, a.getId_result_btoc());
				preparedStatement.setInt(4, a.getId_utilisateur());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Result_plateforme getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM resultat_plateforme WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Result_plateforme a = new Result_plateforme();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setDate(resultat.getString("date"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_result_btoc(resultat.getInt("id_result_btoc"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Result_plateforme> getAll() {
		ArrayList<Result_plateforme> list = new ArrayList<Result_plateforme>();
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM resultat_plateforme");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Result_plateforme a = new Result_plateforme();
				a.setId(resultat.getInt("id"));
				a.setDate(resultat.getString("date"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_result_btoc(resultat.getInt("id_result_btoc"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
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
					.prepareStatement("DELETE FROM resultat_plateforme WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

	public ArrayList<Result_plateforme> getAllByIdAction(int id) {
		ArrayList<Result_plateforme> list = new ArrayList<Result_plateforme>();
		try {
			PreparedStatement ps = Database.connexion.prepareStatement(
					"SELECT * FROM resultat_plateforme WHERE id_result in(SELECT id FROM result WHERE id IN(SELECT id_result FROM action WHERE id=?))");
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Result_plateforme a = new Result_plateforme();
				a.setId(resultat.getInt("id"));
				a.setDate(resultat.getString("date"));
				a.setId_result(resultat.getInt("id_result"));
				a.setId_result_btoc(resultat.getInt("id_result_btoc"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				list.add(a);
			}
				return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
}
