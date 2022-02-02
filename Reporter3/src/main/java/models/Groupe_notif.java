package models;

public class Groupe_notif {
	
	private int id;
	private int id_utilisateur;
	private int id_positionnement;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public int getId_positionnement() {
		return id_positionnement;
	}
	public void setId_positionnement(int id_positionnement) {
		this.id_positionnement = id_positionnement;
	}
	public Groupe_notif(int id_utilisateur, int id_positionnement) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.id_positionnement = id_positionnement;
	}
	public Groupe_notif() {
		super();
	}
	
	

}
