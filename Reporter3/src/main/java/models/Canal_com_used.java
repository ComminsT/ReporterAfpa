package models;

public class Canal_com_used {
	private int id;
	private int id_canal_com;
	private int id_result_com;
	private int taux_couverture;
	private int id_type;
	private int interraction;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_canal_com() {
		return id_canal_com;
	}
	public void setId_canal_com(int id_canal_com) {
		this.id_canal_com = id_canal_com;
	}
	public int getId_result_com() {
		return id_result_com;
	}
	public void setId_result_com(int id_result_com) {
		this.id_result_com = id_result_com;
	}
	public int getTaux_couverture() {
		return taux_couverture;
	}
	public void setTaux_couverture(int taux_couverture) {
		this.taux_couverture = taux_couverture;
	}
	public int getId_type() {
		return id_type;
	}
	public void setId_type(int id_type) {
		this.id_type = id_type;
	}
	public int getInterraction() {
		return interraction;
	}
	public void setInterraction(int interraction) {
		this.interraction = interraction;
	}
	public Canal_com_used(int id_canal_com, int id_result_com, int taux_couverture, int id_type, int interraction) {
		super();
		this.id_canal_com = id_canal_com;
		this.id_result_com = id_result_com;
		this.taux_couverture = taux_couverture;
		this.id_type = id_type;
		this.interraction = interraction;
	}
	public Canal_com_used() {
		super();
	}
	
	

}
