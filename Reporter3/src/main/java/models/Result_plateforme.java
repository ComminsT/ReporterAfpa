package models;

public class Result_plateforme {
	private int id;
	private String date;
	private int id_result;
	private int id_result_btoc;
	private int id_utilisateur;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId_result() {
		return id_result;
	}
	public void setId_result(int id_result) {
		this.id_result = id_result;
	}
	public int getId_result_btoc() {
		return id_result_btoc;
	}
	public void setId_result_btoc(int id_result_btoc) {
		this.id_result_btoc = id_result_btoc;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public Result_plateforme(String date, int id_result, int id_result_btoc, int id_utilisateur) {
		super();
		this.date = date;
		this.id_result = id_result;
		this.id_result_btoc = id_result_btoc;
		this.id_utilisateur = id_utilisateur;
	}
	public Result_plateforme() {
		super();
	}
	

}
