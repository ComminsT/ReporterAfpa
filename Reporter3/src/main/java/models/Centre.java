package models;

public class Centre {
	private int id;
	private String titre;
	private int visible;
	private int id_utilisateur;
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
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public Centre(String titre, int visible, int id_utilisateur) {
		super();
		this.titre = titre;
		this.visible = visible;
		this.id_utilisateur = id_utilisateur;
	}
	public Centre() {
		super();
	}
	@Override
	public String toString() {
		return titre;
	}
	
	
	

}
