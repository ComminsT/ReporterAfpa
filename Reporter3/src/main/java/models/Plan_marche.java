package models;

public class Plan_marche {
	
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
	public Plan_marche(String titre, int visible) {
		super();
		this.titre = titre;
		this.visible = visible;
	}
	public Plan_marche() {
		super();
	}
	@Override
	public String toString() {
		return titre;
	}
	
	
	

}
