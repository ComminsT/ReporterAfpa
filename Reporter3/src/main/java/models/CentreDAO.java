package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CentreDAO {
	public void save(Centre a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE centre set titre=?,visible=?,id_utilisateur=? WHERE id=?");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getVisible());
				preparedStatement.setInt(3, a.getId_utilisateur());
				preparedStatement.setInt(4, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO centre (titre,visible,id_utilisateur) VALUES(?,?,?)");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getVisible());
				preparedStatement.setInt(3, a.getId_utilisateur());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Centre getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM centre WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Centre a = new Centre();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				a.setTitre(resultat.getString("titre"));
				a.setVisible(resultat.getInt("visible"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Centre> getAll() {
		ArrayList<Centre> list = new ArrayList<Centre>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM centre");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Centre a = new Centre();
				a.setId(resultat.getInt("id"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				a.setTitre(resultat.getString("titre"));
				a.setVisible(resultat.getInt("visible"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Centre> getAllRaw() {
		ArrayList<Centre> list = new ArrayList<Centre>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM centre");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Centre a = new Centre();
				a.setId(resultat.getInt("id"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				a.setTitre(resultat.getString("titre"));
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
					.prepareStatement("DELETE FROM centre WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
