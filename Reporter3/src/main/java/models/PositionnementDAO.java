package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PositionnementDAO {
	public void save(Positionnement a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE positionnement set titre=? WHERE id=?");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO positionnement (titre) VALUES(?)");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}
	public Positionnement getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM positionnement WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Positionnement a = new Positionnement();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre"));
			}
			return a;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Positionnement> getAll() {
		ArrayList<Positionnement> list = new ArrayList<Positionnement>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM positionnement");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Positionnement a = new Positionnement();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Positionnement> getAllRaw() {
		ArrayList<Positionnement> list = new ArrayList<Positionnement>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM positionnement");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Positionnement a = new Positionnement();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre"));
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
					.prepareStatement("DELETE FROM positionnement WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
