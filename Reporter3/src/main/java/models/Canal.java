package models;

public class Canal {
	private int id;
	private String titre;
	private int visible;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	public Canal() {
		super();
	}
	public Canal(String titre, int visible) {
		super();
		this.titre = titre;
		this.visible = visible;
	}
	@Override
	public String toString() {
		return titre;
	}
	
	

}
