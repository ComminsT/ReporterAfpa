package models;

public class Result {
	private int id;
	private String date_envoi;
	private int nbr_formulaire;
	private String visuel;
	private int id_utilisateur;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate_envoi() {
		return date_envoi;
	}
	public void setDate_envoi(String date_envoi) {
		this.date_envoi = date_envoi;
	}
	public int getNbr_formulaire() {
		return nbr_formulaire;
	}
	public void setNbr_formulaire(int nbr_formulaire) {
		this.nbr_formulaire = nbr_formulaire;
	}
	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public Result(String date_envoi, int nbr_formulaire, String visuel, int id_utilisateur) {
		super();
		this.date_envoi = date_envoi;
		this.nbr_formulaire = nbr_formulaire;
		this.visuel = visuel;
		this.id_utilisateur = id_utilisateur;
	}
	public Result() {
		super();
	}
	

}
