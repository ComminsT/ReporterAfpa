package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ResultDAO {
	public void save(Result a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE result set date_envoi=?,nbr_formulaire=?,visuel=?,id_utilisateur=? WHERE id=?");
				preparedStatement.setString(1, a.getDate_envoi());
				preparedStatement.setInt(2, a.getNbr_formulaire());
				preparedStatement.setString(3, a.getVisuel());
				preparedStatement.setInt(4, a.getId_utilisateur());
				preparedStatement.setInt(5, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO result (date_envoi,nbr_formulaire,visuel,id_utilisateur) VALUES(?,?,?,?)");
				preparedStatement.setString(1, a.getDate_envoi());
				preparedStatement.setInt(2, a.getNbr_formulaire());
				preparedStatement.setString(3, a.getVisuel());
				preparedStatement.setInt(4, a.getId_utilisateur());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}
	public int saveINT(Result a) {
int newid=0;
		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE result set date_envoi=?,nbr_formulaire=?,visuel=?,id_utilisateur=? WHERE id=?");
				preparedStatement.setString(1, a.getDate_envoi());
				preparedStatement.setInt(2, a.getNbr_formulaire());
				preparedStatement.setString(3, a.getVisuel());
				preparedStatement.setInt(4, a.getId_utilisateur());
				preparedStatement.setInt(5, a.getId());
				 newid=a.getId();
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO result (date_envoi,nbr_formulaire,visuel,id_utilisateur) VALUES(?,?,?,null)", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, a.getDate_envoi());
				preparedStatement.setInt(2, a.getNbr_formulaire());
				preparedStatement.setString(3, a.getVisuel());
				preparedStatement.executeUpdate();
				
				ResultSet resultat = preparedStatement.getGeneratedKeys();
	            resultat.next();
	            newid= resultat.getInt(1) ;
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}
		return newid;

	}

	public Result getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM result WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Result a = new Result();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setDate_envoi(resultat.getString("date_envoi"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				a.setNbr_formulaire(resultat.getInt("nbr_formulaire"));
				a.setVisuel(resultat.getString("visuel"));
				
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Result> getAll() {
		ArrayList<Result> list = new ArrayList<Result>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM result");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Result a = new Result();
				a.setId(resultat.getInt("id"));
				a.setDate_envoi(resultat.getString("date_envoi"));
				a.setId_utilisateur(resultat.getInt("id_utilisateur"));
				a.setNbr_formulaire(resultat.getInt("nbr_formulaire"));
				a.setVisuel(resultat.getString("visuel"));
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
					.prepareStatement("DELETE FROM result WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
