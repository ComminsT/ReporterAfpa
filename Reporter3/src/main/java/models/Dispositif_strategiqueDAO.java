package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dispositif_strategiqueDAO {
	public void save(Dispositif_strategique a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE dispositif_strategique set titre_d=?,visible=? WHERE id=?");
				preparedStatement.setString(1, a.getTitre());
				preparedStatement.setInt(2, a.getVisible());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO dispositif_strategique (titre_d,visible) VALUES(?,?)");
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

	public Dispositif_strategique getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM dispositif_strategique WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Dispositif_strategique a = new Dispositif_strategique();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_d"));
				a.setVisible(resultat.getInt("visible"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Dispositif_strategique> getAll() {
		ArrayList<Dispositif_strategique> list = new ArrayList<Dispositif_strategique>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM dispositif_strategique WHERE visible=1");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Dispositif_strategique a = new Dispositif_strategique();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_d"));
				a.setVisible(resultat.getInt("visible"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Dispositif_strategique> getAllRAW() {
		ArrayList<Dispositif_strategique> list = new ArrayList<Dispositif_strategique>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM dispositif_strategique");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Dispositif_strategique a = new Dispositif_strategique();
				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre_d"));
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
					.prepareStatement("DELETE FROM dispositif_strategique WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
