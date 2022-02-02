package models;

public class Center_selected {
	private int id;
	private int id_centre;
	private int id_action;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_centre() {
		return id_centre;
	}
	public void setId_centre(int id_centre) {
		this.id_centre = id_centre;
	}
	public int getId_action() {
		return id_action;
	}
	public void setId_action(int id_action) {
		this.id_action = id_action;
	}
	
	public Center_selected(int id_centre, int id_action) {
		super();
		this.id_centre = id_centre;
		this.id_action = id_action;
	}
	public Center_selected() {
		super();
	}
	
	

}
