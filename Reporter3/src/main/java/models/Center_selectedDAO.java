package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Center_selectedDAO {
	public void save(Center_selected a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE center_selected set id_centre=?,id_action=? WHERE id=?");
				preparedStatement.setInt(1, a.getId_centre());
				preparedStatement.setInt(2, a.getId_action());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO center_selected (id_centre,id_action) VALUES(?,?)");
				preparedStatement.setInt(1, a.getId_centre());
				preparedStatement.setInt(2, a.getId_action());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Center_selected getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM center_selected WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Center_selected a = new Center_selected();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_action(resultat.getInt("id_action"));
				a.setId_centre(resultat.getInt("id_centre"));
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Center_selected> getAll() {
		ArrayList<Center_selected> list = new ArrayList<Center_selected>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM center_selected");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Center_selected a = new Center_selected();
				a.setId(resultat.getInt("id"));
				a.setId_action(resultat.getInt("id_action"));
				a.setId_centre(resultat.getInt("id_centre"));
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
					.prepareStatement("DELETE FROM center_selected WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	public ArrayList<Center_selected> getAllByIdAction(int id_action) {
		ArrayList<Center_selected> list = new ArrayList<Center_selected>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM center_selected WHERE id_action=?");
			preparedStatement.setInt(1, id_action);
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Center_selected a = new Center_selected();
				a.setId(resultat.getInt("id"));
				a.setId_action(resultat.getInt("id_action"));
				a.setId_centre(resultat.getInt("id_centre"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void deleteAllById(int actionid) {
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM center_selected WHERE id_action=? ");
			ps.setInt(1, actionid);
			ps.executeUpdate();
			System.out.println("DELETED OK ");
			
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		// TODO Auto-generated method stub
		
	}
}
