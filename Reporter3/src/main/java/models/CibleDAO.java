package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CibleDAO {
	public void save(Cible a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE cible set titre_c=?,visible=? WHERE id=?");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getVisible());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO cible (titre_c,visible) VALUES(?,?)");
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

	public Cible getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM cible WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			
			Cible a = new Cible();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_c"));
				a.setVisible(resultat.getInt("visible"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Cible> getAll() {
		ArrayList<Cible> list = new ArrayList<Cible>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM cible WHERE visible=1");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Cible a = new Cible();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_c"));
				a.setVisible(resultat.getInt("visible"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Cible> getAllRAW() {
		ArrayList<Cible> list = new ArrayList<Cible>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM cible");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Cible a = new Cible();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_c"));
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
					.prepareStatement("DELETE FROM cible WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
