package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UtilisateurDAO {
	public void save(Utilisateur a) {

		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE utilisateur set identifiant=?,password=?,active=?,mail=?,nom=?,prenom=? WHERE id=?");
				preparedStatement.setString(1, a.getIdentifiant());
				preparedStatement.setString(2, a.getPassword());
				preparedStatement.setInt(3, a.getActive());
				preparedStatement.setString(4, a.getMail());
				preparedStatement.setString(5, a.getNom());
				preparedStatement.setString(6, a.getPrenom());
				preparedStatement.setInt(7, a.getId());
				
				preparedStatement.executeUpdate();
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO utilisateur (identifiant,password,active,mail,nom,prenom) VALUES(?,?,?,?,?,?)");
				preparedStatement.setString(1, a.getIdentifiant());
				preparedStatement.setString(2, a.getPassword());
				preparedStatement.setInt(3, a.getActive());
				preparedStatement.setString(4, a.getMail());
				preparedStatement.setString(5, a.getNom());
				preparedStatement.setString(6, a.getPrenom());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}
	public int saveINT(Utilisateur a) {
int newid=0;
		try {
			if (a.getId() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"UPDATE utilisateur set identifiant=?,password=?,active=?,mail=?,nom=?,prenom=? WHERE id=?");
				preparedStatement.setString(1, a.getIdentifiant());
				preparedStatement.setString(2, a.getPassword());
				preparedStatement.setInt(3, a.getActive());
				preparedStatement.setString(4, a.getMail());
				preparedStatement.setString(5, a.getNom());
				preparedStatement.setString(6, a.getPrenom());
				preparedStatement.setInt(7, a.getId());
				newid=a.getId();
				preparedStatement.executeUpdate();
				 
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement(
						"INSERT INTO utilisateur (identifiant,password,active,mail,nom,prenom) VALUES(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, a.getIdentifiant());
				preparedStatement.setString(2, a.getPassword());
				preparedStatement.setInt(3, a.getActive());
				preparedStatement.setString(4, a.getMail());
				preparedStatement.setString(5, a.getNom());
				preparedStatement.setString(6, a.getPrenom());
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

	public Utilisateur getById(int id) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM utilisateur WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();
			Utilisateur a = new Utilisateur();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setActive(resultat.getInt("active"));
				a.setIdentifiant(resultat.getString("identifiant"));
				a.setMail(resultat.getString("mail"));
				a.setPassword(resultat.getString("password"));
				a.setNom(resultat.getString("nom"));
				a.setPrenom(resultat.getString("prenom"));
				
				
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<Utilisateur> getAll() {
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM utilisateur");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Utilisateur a = new Utilisateur();
				a.setId(resultat.getInt("id"));
				a.setActive(resultat.getInt("active"));
				a.setIdentifiant(resultat.getString("identifiant"));
				a.setMail(resultat.getString("mail"));
				a.setPassword(resultat.getString("password"));
				a.setNom(resultat.getString("nom"));
				a.setPrenom(resultat.getString("prenom"));
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
					.prepareStatement("DELETE FROM utilisateur WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("DELETED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

	public ArrayList<Utilisateur> getAllMC() {
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		try {
			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM utilisateur WHERE id IN(SELECT id_utilisateur FROM group_list WHERE id_groupe=2) ");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Utilisateur a = new Utilisateur();
				a.setId(resultat.getInt("id"));
				a.setActive(resultat.getInt("active"));
				a.setIdentifiant(resultat.getString("identifiant"));
				a.setMail(resultat.getString("mail"));
				a.setPassword(resultat.getString("password"));
				a.setNom(resultat.getString("nom"));
				a.setPrenom(resultat.getString("prenom"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Utilisateur> getAllD() {
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		try {
			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM utilisateur WHERE id IN(SELECT id_utilisateur FROM group_list WHERE id_groupe=1) ");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Utilisateur a = new Utilisateur();
				a.setId(resultat.getInt("id"));
				a.setActive(resultat.getInt("active"));
				a.setIdentifiant(resultat.getString("identifiant"));
				a.setMail(resultat.getString("mail"));
				a.setPassword(resultat.getString("password"));
				a.setNom(resultat.getString("nom"));
				a.setPrenom(resultat.getString("prenom"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Utilisateur> getAllP() {
		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
		try {
			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM utilisateur WHERE id IN(SELECT id_utilisateur FROM group_list WHERE id_groupe=3) ");
			ResultSet resultat = preparedStatement.executeQuery();
			while (resultat.next()) {
				Utilisateur a = new Utilisateur();
				a.setId(resultat.getInt("id"));
				a.setActive(resultat.getInt("active"));
				a.setIdentifiant(resultat.getString("identifiant"));
				a.setMail(resultat.getString("mail"));
				a.setPassword(resultat.getString("password"));
				a.setNom(resultat.getString("nom"));
				a.setPrenom(resultat.getString("prenom"));
				list.add(a);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Utilisateur connect(String identifiant, String password) {
		try {
			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM utilisateur WHERE identifiant=? AND password=? AND active=1");
			preparedStatement.setString(1, identifiant);
			preparedStatement.setString(2, password);
			ResultSet resultat = preparedStatement.executeQuery();
			Utilisateur a = new Utilisateur();
			while (resultat.next()) {
				a.setId(resultat.getInt("id"));
				a.setActive(resultat.getInt("active"));
				a.setIdentifiant(resultat.getString("identifiant"));
				a.setMail(resultat.getString("mail"));
				a.setPassword(resultat.getString("password"));
				a.setNom(resultat.getString("nom"));
				a.setPrenom(resultat.getString("prenom"));
			}
			return a;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
}
