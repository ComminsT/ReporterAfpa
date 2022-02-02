package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Plan_marcheDAO {
	public void save(Plan_marche a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE plan_de_marche set titre_p=?,visible=? WHERE id=?");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getVisible());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO plan_de_marche (titre_p,visible) VALUES(?,?)");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getVisible());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Plan_marche getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM plan_de_marche WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Plan_marche a = new Plan_marche();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_p"));
				a.setVisible(resultat.getInt("visible"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Plan_marche> getAll() {
		ArrayList<Plan_marche> list = new ArrayList<Plan_marche>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM plan_de_marche WHERE visible=1");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Plan_marche a = new Plan_marche();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_p"));
				a.setVisible(resultat.getInt("visible"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Plan_marche> getAllRaw() {
		ArrayList<Plan_marche> list = new ArrayList<Plan_marche>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM plan_de_marche");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Plan_marche a = new Plan_marche();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_p"));
				a.setVisible(resultat.getInt("visible"));
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
					.prepareStatement("DELETE FROM plan_de_marche WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
