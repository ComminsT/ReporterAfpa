package models;

public class Resultat_com {
	
	private int id;
	private int id_result;
	private int etat;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_result() {
		return id_result;
	}
	public void setId_result(int id_result) {
		this.id_result = id_result;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public Resultat_com(int id_result, int etat) {
		super();
		this.id_result = id_result;
		this.etat = etat;
	}
	public Resultat_com() {
		super();
	}
	
	

}
