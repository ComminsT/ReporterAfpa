package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Canal_comDAO {
	public void save(Canal_com a) {

		try {

			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE canal_com set titrecc=?,visible=? WHERE id=?");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getVisible());
				preparedStatement.setInt(3, a.getId());

				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO canal_com (titrecc,visible) VALUES(?,?)");
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

	public Canal_com getById(int id) {
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM canal_com WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Canal_com a = new Canal_com();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titrecc"));
				a.setVisible(resultat.getInt("visible"));
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Canal_com> getAll() {
		ArrayList<Canal_com> list = new ArrayList<Canal_com>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM canal_com WHERE visible=1");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Canal_com a = new Canal_com();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titrecc"));
				a.setVisible(resultat.getInt("visible"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Canal_com> getAllRaw() {
		ArrayList<Canal_com> list = new ArrayList<Canal_com>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM canal_com");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Canal_com a = new Canal_com();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titrecc"));
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
					.prepareStatement("DELETE FROM canal_com WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
