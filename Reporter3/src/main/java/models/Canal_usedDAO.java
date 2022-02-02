package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Canal_usedDAO {
	public void save(Canal_used a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE canal_used set id_canal=?,id_action=?WHERE id=?");
				preparedStatement.setInt(1, a.getId_canal());
				preparedStatement.setInt(2, a.getId_action());
				preparedStatement.setInt(3, a.getId());
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO canal_used (id_canal,id_action) VALUES(?,?)");
				preparedStatement.setInt(1, a.getId_canal());
				preparedStatement.setInt(2, a.getId_action());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Canal_used getById(int id) {
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM canal_used WHERE id=?");
			ResultSet resultat = preparedStatement.executeQuery();
			Canal_used a = new Canal_used();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setId_action(resultat.getInt("id_action"));
				a.setId_canal(resultat.getInt("id_canal"));
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Canal_used> getAll() {
		ArrayList<Canal_used> list = new ArrayList<Canal_used>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM canal_used");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Canal_used a = new Canal_used();
				a.setId(resultat.getInt("id"));
				a.setId_action(resultat.getInt("id_action"));
				a.setId_canal(resultat.getInt("id_canal"));
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
					.prepareStatement("DELETE FROM canal_used WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	public ArrayList<Canal_used> getAllByIdAction(int id_action){
		ArrayList<Canal_used> list = new ArrayList<Canal_used>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM canal_used WHERE id_action=?");
			preparedStatement.setInt(1, id_action);
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Canal_used a = new Canal_used();
				a.setId(resultat.getInt("id"));
				a.setId_action(resultat.getInt("id_action"));
				a.setId_canal(resultat.getInt("id_canal"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void deleteAllById(int actionid) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = Database.connexion.prepareStatement("DELETE FROM canal_used WHERE id_action=?");
			ps.setInt(1, actionid);
			ps.executeUpdate();
			System.out.println("DELETED OK");
		
		}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("DELETED NO");
			}
		}
		
	}

