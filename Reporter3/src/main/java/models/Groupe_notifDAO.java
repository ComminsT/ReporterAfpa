package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Groupe_notifDAO {
	public void save(Groupe_notif a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE group_list set id_utilisateur=?,id_positionnement=? WHERE id=?");
				preparedStatement.setInt(1, a.getId_utilisateur());
				preparedStatement.setInt(2, a.getId_positionnement());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO groupe_notif (id_utilisateur,id_positionnement) VALUES(?,?)");
				preparedStatement.setInt(1, a.getId_utilisateur());
				preparedStatement.setInt(2, a.getId_positionnement());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Groupe_notif getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM groupe_notif WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Groupe_notif a = new Groupe_notif();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				a.setId_positionnement(resultat.getInt("id_positionnement"));
			}
			return a;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Groupe_notif> getAll() {
		ArrayList<Groupe_notif> list = new ArrayList<Groupe_notif>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM groupe_notif");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Groupe_notif a = new Groupe_notif();
				a.setId(resultat.getInt("id"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
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
					.prepareStatement("DELETE FROM groupe_notif WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
