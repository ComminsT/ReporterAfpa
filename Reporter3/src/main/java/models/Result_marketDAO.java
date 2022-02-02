package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Result_marketDAO {
	public void save(Result_market a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE resultat_market set nbr_contact_cible=?,nbr_ouvreurs=?,nbr_cliqueurs=?,etat=?,id_result=? WHERE id=?");
				preparedStatement.setInt(1, a.getNbr_contactcible());
				preparedStatement.setInt(2, a.getNbr_ouvreurs());
				preparedStatement.setInt(3, a.getNbr_cliqueurs());
				preparedStatement.setInt(4, a.getEtat());
				preparedStatement.setInt(5, a.getId_result());
				preparedStatement.setInt(6, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO resultat_market (nbr_contact_cible,nbr_ouvreurs,nbr_cliqueurs,etat,id_result) VALUES(?,?,?,?,?)");
				preparedStatement.setInt(1, a.getNbr_contactcible());
				preparedStatement.setInt(2, a.getNbr_ouvreurs());
				preparedStatement.setInt(3, a.getNbr_cliqueurs());
				preparedStatement.setInt(4, a.getEtat());
				preparedStatement.setInt(5, a.getId_result());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Result_market getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM resultat_market WHERE id=?");
			ResultSet resultat = preparedStatement.executeQuery();
			preparedStatement.setInt(1, id);
			Result_market a = new Result_market();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_result(resultat.getInt("id_result"));
				a.setNbr_cliqueurs(resultat.getInt("nbr_cliqueurs"));
				a.setNbr_contactcible(resultat.getInt("nbr_contact_cible"));
				a.setNbr_ouvreurs(resultat.getInt("nbr_ouvreurs"));
				a.setEtat(resultat.getInt("etat"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Result_market> getAll() {
		ArrayList<Result_market> list = new ArrayList<Result_market>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM resultat_market");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Result_market a = new Result_market();
				a.setId(resultat.getInt("id"));
				a.setId_result(resultat.getInt("id_result"));
				a.setNbr_cliqueurs(resultat.getInt("nbr_cliqueurs"));
				a.setNbr_contactcible(resultat.getInt("nbr_contact_cible"));
				a.setNbr_ouvreurs(resultat.getInt("nbr_ouvreurs"));
				a.setEtat(resultat.getInt("etat"));
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
					.prepareStatement("DELETE FROM resultat_market WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	
	public Result_market getByIdResult(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM resultat_market WHERE id_result=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Result_market a = new Result_market();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_result(resultat.getInt("id_result"));
				a.setNbr_cliqueurs(resultat.getInt("nbr_cliqueurs"));
				a.setNbr_contactcible(resultat.getInt("nbr_contact_cible"));
				a.setNbr_ouvreurs(resultat.getInt("nbr_ouvreurs"));
				a.setEtat(resultat.getInt("etat"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
