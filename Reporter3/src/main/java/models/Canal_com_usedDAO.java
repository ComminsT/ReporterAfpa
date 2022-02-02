package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Canal_com_usedDAO {
	public void save(Canal_com_used a) {

		try {

			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE canal_com_used set taux_couverture=?,id_result_com=?,id_canal_com=?,id_type=?,nbr_interaction=? WHERE id=?");
				preparedStatement.setInt(1, a.getTaux_couverture());
				preparedStatement.setInt(2, a.getId_result_com());
				preparedStatement.setInt(3, a.getId_canal_com());
				preparedStatement.setInt(4, a.getId_type());
				preparedStatement.setInt(5, a.getId_type());
				preparedStatement.setInt(6, a.getId());

				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO canal_com_used (taux_couverture,id_result_com,id_canal_com,id_type,nbr_interaction) VALUES(?,?,?,?,?)");
				preparedStatement.setInt(1, a.getTaux_couverture());
				preparedStatement.setInt(2, a.getId_result_com());
				preparedStatement.setInt(3, a.getId_canal_com());
				preparedStatement.setInt(4, a.getId_type());
				preparedStatement.setInt(5, a.getInterraction());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Canal_com_used getById(int id) {
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM canal_com_used WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Canal_com_used a = new Canal_com_used();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_canal_com(resultat.getInt("id_canal_com"));
				a.setId_result_com(resultat.getInt("id_result_com"));
				a.setTaux_couverture(resultat.getInt("taux_couverture"));
				a.setId_type(resultat.getInt("id_type"));
				a.setInterraction(resultat.getInt("nbr_interaction"));
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Canal_com_used> getAll() {
		ArrayList<Canal_com_used> list = new ArrayList<Canal_com_used>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM canal_com_used");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Canal_com_used a = new Canal_com_used();
				a.setId(resultat.getInt("id"));
				a.setId_canal_com(resultat.getInt("id_canal_com"));
				a.setId_result_com(resultat.getInt("id_result_com"));
				a.setTaux_couverture(resultat.getInt("taux_couverture"));
				a.setId_type(resultat.getInt("id_type"));
				a.setInterraction(resultat.getInt("nbr_interaction"));
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
					.prepareStatement("DELETE FROM canal_com_used WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

	public ArrayList<Canal_com_used> getByResultcomId(int id) {
		ArrayList<Canal_com_used> list = new ArrayList<Canal_com_used>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM canal_com_used WHERE id_result_com IN(SELECT id FROM resultat_com WHERE id=?)");
			preparedStatement.setInt(1, id);
			
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Canal_com_used a = new Canal_com_used();
				a.setId(resultat.getInt("id"));
				a.setId_canal_com(resultat.getInt("id_canal_com"));
				a.setId_result_com(resultat.getInt("id_result_com"));
				a.setTaux_couverture(resultat.getInt("taux_couverture"));
				a.setId_type(resultat.getInt("id_type"));
				a.setInterraction(resultat.getInt("nbr_interaction"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
