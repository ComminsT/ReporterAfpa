package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Resultat_comDAO {
	public void save(Resultat_com a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE resultat_com set etat=?,id_result=? WHERE id=?");
				preparedStatement.setInt(1, a.getEtat());
				preparedStatement.setInt(2, a.getId_result());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO resultat_com (etat,id_result) VALUES(?,?)");
				preparedStatement.setInt(1, a.getEtat());
				preparedStatement.setInt(2, a.getId_result());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Resultat_com getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM resultat_com WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Resultat_com a = new Resultat_com();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_result(resultat.getInt("id_result"));
				a.setEtat(resultat.getInt("etat"));
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Resultat_com> getAll() {
		ArrayList<Resultat_com> list = new ArrayList<Resultat_com>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM resultat_com");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Resultat_com a = new Resultat_com();
				a.setId(resultat.getInt("id"));
				a.setId_result(resultat.getInt("id_result"));
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
					.prepareStatement("DELETE FROM resultat_com WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

	public Resultat_com getByActionId(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM resultat_com WHERE id_result IN(SELECT id FROM result WHERE id IN(SELECT id_result FROM action WHERE id=?))");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Resultat_com a = new Resultat_com();
			while (resultat.next()) {
				System.out.println("inside resultat.next()");
				a.setId(resultat.getInt("id"));
				a.setId_result(resultat.getInt("id_result"));
				a.setEtat(resultat.getInt("etat"));
				
			}
			
			return a;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Result_com not found");
			return null;
		}
	}
}
