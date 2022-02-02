package models;

public class Result_market {
	
	private int id;
	private int nbr_contactcible;
	private int nbr_ouvreurs;
	private int nbr_cliqueurs;
	private int etat;
	private int id_result;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbr_contactcible() {
		return nbr_contactcible;
	}
	public void setNbr_contactcible(int nbr_contactcible) {
		this.nbr_contactcible = nbr_contactcible;
	}
	public int getNbr_ouvreurs() {
		return nbr_ouvreurs;
	}
	public void setNbr_ouvreurs(int nbr_ouvreurs) {
		this.nbr_ouvreurs = nbr_ouvreurs;
	}
	public int getNbr_cliqueurs() {
		return nbr_cliqueurs;
	}
	public void setNbr_cliqueurs(int nbr_cliqueurs) {
		this.nbr_cliqueurs = nbr_cliqueurs;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public int getId_result() {
		return id_result;
	}
	public void setId_result(int id_result) {
		this.id_result = id_result;
	}
	public Result_market(int nbr_contactcible, int nbr_ouvreurs, int nbr_cliqueurs, int etat, int id_result) {
		super();
		this.nbr_contactcible = nbr_contactcible;
		this.nbr_ouvreurs = nbr_ouvreurs;
		this.nbr_cliqueurs = nbr_cliqueurs;
		this.etat = etat;
		this.id_result = id_result;
		
	}
	public Result_market() {
		super();
	}
	
	
	

}
