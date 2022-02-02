package models;

public class Action {
	private int id;
	private String theme;
	private int semaine;
	private int status;
	private int type;
	private int relance;
	private int id_dispo;
	private int id_plan;
	private int id_ssecteur;
	private int id_cible;
	private int id_result;
	private int id_positionnement;
	public int getId_positionnement() {
		return id_positionnement;
	}
	public void setId_positionnement(int id_positionnement) {
		this.id_positionnement = id_positionnement;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public int getSemaine() {
		return semaine;
	}
	public void setSemaine(int semaine) {
		this.semaine = semaine;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRelance() {
		return relance;
	}
	public void setRelance(int relance) {
		this.relance = relance;
	}
	public int getId_dispo() {
		return id_dispo;
	}
	public void setId_dispo(int id_dispo) {
		this.id_dispo = id_dispo;
	}
	public int getId_plan() {
		return id_plan;
	}
	public void setId_plan(int id_plan) {
		this.id_plan = id_plan;
	}
	public int getId_ssecteur() {
		return id_ssecteur;
	}
	public void setId_ssecteur(int id_ssecteur) {
		this.id_ssecteur = id_ssecteur;
	}
	public int getId_cible() {
		return id_cible;
	}
	public void setId_cible(int id_cible) {
		this.id_cible = id_cible;
	}
	public int getId_result() {
		return id_result;
	}
	public void setId_result(int id_result) {
		this.id_result = id_result;
	}
	public Action(String theme, int semaine, int status, int type, int relance, int id_dispo, int id_plan,
			int id_ssecteur, int id_cible, int id_result, int id_positionnement) {
		super();
		this.theme = theme;
		this.semaine = semaine;
		this.status = status;
		this.type = type;
		this.relance = relance;
		this.id_dispo = id_dispo;
		this.id_plan = id_plan;
		this.id_ssecteur = id_ssecteur;
		this.id_cible = id_cible;
		this.id_result = id_result;
		this.id_positionnement = id_positionnement;
	}
	public Action() {
		super();
	}
	
	
	

}
