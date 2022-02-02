package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Group_listDAO {
	public void save(Group_list a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE group_list set id_utilisateur=?,id_groupe=? WHERE id=?");
				preparedStatement.setInt(1, a.getId_utilisateur());
				preparedStatement.setInt(2, a.getId_groupe());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO group_list (id_utilisateur,id_groupe) VALUES(?,?)");
				preparedStatement.setInt(1, a.getId_utilisateur());
				preparedStatement.setInt(2, a.getId_groupe());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Group_list getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM group_list WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Group_list a = new Group_list();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				a.setId_groupe(resultat.getInt("id_groupe"));
			}
			return a;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Group_list> getAll() {
		ArrayList<Group_list> list = new ArrayList<Group_list>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM group_list");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Group_list a = new Group_list();
				a.setId(resultat.getInt("id"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				a.setId_groupe(resultat.getInt("id_groupe"));
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
					.prepareStatement("DELETE FROM group_list WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	
	public ArrayList<Group_list> getAllFromUtilisateurId(int id) {
		ArrayList<Group_list> list = new ArrayList<Group_list>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM group_list WHERE id_utilisateur=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Group_list a = new Group_list();
				a.setId(resultat.getInt("id"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				a.setId_groupe(resultat.getInt("id_groupe"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
