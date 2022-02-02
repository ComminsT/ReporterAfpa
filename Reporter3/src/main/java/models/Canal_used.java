package models;

public class Canal_used {
	private int id;
	private int id_canal;
	private int id_action;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_canal() {
		return id_canal;
	}
	public void setId_canal(int id_canal) {
		this.id_canal = id_canal;
	}
	public int getId_action() {
		return id_action;
	}
	public void setId_action(int id_action) {
		this.id_action = id_action;
	}
	public Canal_used(int id_canal, int id_action) {
		super();
		this.id_canal = id_canal;
		this.id_action = id_action;
	}
	public Canal_used() {
		super();
	}
	

}
