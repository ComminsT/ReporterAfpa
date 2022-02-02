package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Result_btocDAO {
	public void save(Result_btoc a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE resultat_btoc set nbr_contact_rappel=?,nbr_contact_argumente=?,nbr_inscriptionic=? WHERE id=?");
				
				
				preparedStatement.setInt(1, a.getNbr_contact_rappel());
				preparedStatement.setInt(2, a.getNbr_contact_argumente());
				preparedStatement.setInt(3, a.getNbr_inscription_ic());
				preparedStatement.setInt(4, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO resultat_btob (nbr_contact_rappel,nbr_contact_argumente,nbr_inscriptionic) VALUES(?,?,?)");
				preparedStatement.setInt(1, a.getNbr_contact_rappel());
				preparedStatement.setInt(2, a.getNbr_contact_argumente());
				preparedStatement.setInt(3, a.getNbr_inscription_ic());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}
	public int saveINT(Result_btoc a) {
		int newid=0;

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE resultat_btoc set nbr_contact_rappel=?,nbr_contact_argumente=?,nbr_inscriptionic=? WHERE id=?");
				preparedStatement.setInt(1, a.getNbr_contact_rappel());
				preparedStatement.setInt(2, a.getNbr_contact_argumente());
				preparedStatement.setInt(3, a.getNbr_inscription_ic());
				preparedStatement.setInt(4, a.getId());
				preparedStatement.executeUpdate();
				newid=a.getId();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO resultat_btoc (nbr_contact_rappel,nbr_contact_argumente,nbr_inscriptionic) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, a.getNbr_contact_rappel());
				preparedStatement.setInt(2, a.getNbr_contact_argumente());
				preparedStatement.setInt(3, a.getNbr_inscription_ic());
				preparedStatement.executeUpdate();
				ResultSet resultat = preparedStatement.getGeneratedKeys();
	            resultat.next();
	            newid= resultat.getInt(1);
			}
			System.out.println("SAVED OK");
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}
		return newid;

	}

	public Result_btoc getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM resultat_btoc WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Result_btoc a = new Result_btoc();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setNbr_contact_argumente(resultat.getInt("nbr_contact_argumente"));
				a.setNbr_contact_rappel(resultat.getInt("nbr_contact_rappel"));
				a.setNbr_inscription_ic(resultat.getInt("nbr_inscriptionic"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Result_btoc> getAll() {
		ArrayList<Result_btoc> list = new ArrayList<Result_btoc>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM resultat_btoc");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Result_btoc a = new Result_btoc();
				a.setId(resultat.getInt("id"));
				a.setNbr_contact_argumente(resultat.getInt("nbr_contact_argumente"));
				a.setNbr_contact_rappel(resultat.getInt("nbr_contact_rappel"));
				a.setNbr_inscription_ic(resultat.getInt("nbr_inscriptionic"));
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
					.prepareStatement("DELETE FROM resultat_btoc WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
