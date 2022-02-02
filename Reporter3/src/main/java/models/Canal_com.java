package models;

public class Canal_com {
	
	private int id;
	private String titrecc;
	private int visible;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titrecc;
	}
	public void setTitre(String titre) {
		this.titrecc = titre;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	public Canal_com(String titrecc, int visible) {
		super();
		this.titrecc = titrecc;
		this.visible = visible;
	}
	public Canal_com() {
		super();
	}
	
	
	
	
	
	

}
