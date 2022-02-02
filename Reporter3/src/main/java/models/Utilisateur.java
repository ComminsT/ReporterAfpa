package models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

public class Utilisateur {
	private int id;
	private String identifiant;
	private String password;
	private int active;
	private String mail;
	private String nom;
	private String prenom;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Utilisateur(String identifiant, String password, int active, String mail, String nom, String prenom) {
		super();
		this.identifiant = identifiant;
		this.password = password;
		this.active = active;
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Utilisateur() {
		super();
	}
	@Override
	public String toString() {
		return identifiant;
	}
	public void changemdp(String newmdp) {
		String newpass=newmdp+"zack"+(identifiant.length()*5-3);
		/////MD5//////
		String myHash="";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(newpass.getBytes());
			byte[] digest = md.digest();
			myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		this.password=myHash;
		UtilisateurDAO utilisateurdao = new UtilisateurDAO();
		utilisateurdao.save(this);
		System.out.println("mdp changé");
	
	}
	

	
}
