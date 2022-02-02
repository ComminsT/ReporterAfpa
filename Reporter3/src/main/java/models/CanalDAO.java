package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CanalDAO {
	public void save(Canal a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE canal set titre=?,visible=? WHERE id=?");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getVisible());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO canal (titre,visible) VALUES(?,?)");
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

	public Canal getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM canal WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Canal a = new Canal();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre"));
				a.setVisible(resultat.getInt("visible"));
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Canal> getAll() {
		ArrayList<Canal> list = new ArrayList<Canal>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM canal WHERE visible=1");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Canal a = new Canal();
				a.setId(resultat.getInt("id"));
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
	public ArrayList<Canal> getAllRaw() {
		ArrayList<Canal> list = new ArrayList<Canal>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM canal");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Canal a = new Canal();
				a.setId(resultat.getInt("id"));
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
					.prepareStatement("DELETE FROM canal WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
