package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Result_btobDAO {
	public void save(Result_btob a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE resultat_btob set envoi_catalogue=?,inscription_event=?,nbr_prise_rdv=?,nbr_devis=?,nbr_convention=?,commentaire=?,id_resultat_btoc=? WHERE id=?");
				
				preparedStatement.setInt(1, a.getEnvoi_catalogue());
				preparedStatement.setInt(2, a.getInscription_event());
				preparedStatement.setInt(3, a.getNbr_prise_rdv());
				preparedStatement.setInt(4, a.getNbr_devis());
				preparedStatement.setInt(5, a.getNbr_convention());
				preparedStatement.setString(6, a.getCommentaire());
				preparedStatement.setInt(7,a.getId_resultat_btoc());
				preparedStatement.setInt(8, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO resultat_btob (envoi_catalogue,inscription_event,nbr_prise_rdv,nbr_devis,nbr_convention,commentaire,id_resultat_btoc) VALUES(?,?,?,?,?,?,?)");
				preparedStatement.setInt(1, a.getEnvoi_catalogue());
				preparedStatement.setInt(2, a.getInscription_event());
				preparedStatement.setInt(3, a.getNbr_prise_rdv());
				preparedStatement.setInt(4, a.getNbr_devis());
				preparedStatement.setInt(5, a.getNbr_convention());
				preparedStatement.setString(6, a.getCommentaire());
				preparedStatement.setInt(7,a.getId_resultat_btoc());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Result_btob getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM resultat_btob WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Result_btob a = new Result_btob();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setCommentaire(resultat.getString("commentaire"));
				a.setEnvoi_catalogue(resultat.getInt("envoi_catalogue"));
				a.setId_resultat_btoc(resultat.getInt("id_resultat_btoc"));
				a.setInscription_event(resultat.getInt("inscription_event"));
				a.setNbr_convention(resultat.getInt("nbr_convention"));
				a.setNbr_devis(resultat.getInt("nbr_devis"));
				a.setNbr_prise_rdv(resultat.getInt("nbr_prise_rdv"));
				
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public Result_btob getByIdBtoc(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM resultat_btob WHERE id_resultat_btoc=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Result_btob a = new Result_btob();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setCommentaire(resultat.getString("commentaire"));
				a.setEnvoi_catalogue(resultat.getInt("envoi_catalogue"));
				a.setId_resultat_btoc(resultat.getInt("id_resultat_btoc"));
				a.setInscription_event(resultat.getInt("inscription_event"));
				a.setNbr_convention(resultat.getInt("nbr_convention"));
				a.setNbr_devis(resultat.getInt("nbr_devis"));
				a.setNbr_prise_rdv(resultat.getInt("nbr_prise_rdv"));
				
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Result_btob> getAll() {
		ArrayList<Result_btob> list = new ArrayList<Result_btob>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM resultat_btob");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Result_btob a = new Result_btob();
				a.setId(resultat.getInt("id"));
				a.setCommentaire(resultat.getString("commentaire"));
				a.setEnvoi_catalogue(resultat.getInt("envoi_catalogue"));
				a.setId_resultat_btoc(resultat.getInt("id_resultat_btoc"));
				a.setInscription_event(resultat.getInt("inscription_event"));
				a.setNbr_convention(resultat.getInt("nbr_convention"));
				a.setNbr_devis(resultat.getInt("nbr_devis"));
				a.setNbr_prise_rdv(resultat.getInt("nbr_prise_rdv"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Result_btob> getAllById_plateforme(int id) {
		ArrayList<Result_btob> list = new ArrayList<Result_btob>();
		try {
			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM resultat_btob WHERE id_resultat_btoc=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Result_btob a = new Result_btob();
				a.setId(resultat.getInt("id"));
				a.setCommentaire(resultat.getString("commentaire"));
				a.setEnvoi_catalogue(resultat.getInt("envoi_catalogue"));
				a.setId_resultat_btoc(resultat.getInt("id_resultat_btoc"));
				a.setInscription_event(resultat.getInt("inscription_event"));
				a.setNbr_convention(resultat.getInt("nbr_convention"));
				a.setNbr_devis(resultat.getInt("nbr_devis"));
				a.setNbr_prise_rdv(resultat.getInt("nbr_prise_rdv"));
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
					.prepareStatement("DELETE FROM resultat_btob WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
