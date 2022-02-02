package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Sous_secteurDAO {
	public void save(Sous_secteur a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE sous_secteur set titre_s=?,visible=? WHERE id=?");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getVisible());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO sous_secteur (titre_s,visible) VALUES(?,?)");
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

	public Sous_secteur getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM sous_secteur WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Sous_secteur a = new Sous_secteur();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_s"));
				a.setVisible(resultat.getInt("visible"));
			}
			return a;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Sous_secteur> getAll() {
		ArrayList<Sous_secteur> list = new ArrayList<Sous_secteur>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM sous_secteur WHERE visible=1");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Sous_secteur a = new Sous_secteur();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_s"));
				a.setVisible(resultat.getInt("visible"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Sous_secteur> getAllRaw() {
		ArrayList<Sous_secteur> list = new ArrayList<Sous_secteur>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM sous_secteur");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Sous_secteur a = new Sous_secteur();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_s"));
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
					.prepareStatement("DELETE FROM plan_marche WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
