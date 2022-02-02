package models;

public class Positionnement {
	
	private int id;
	private String titre;
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
	public Positionnement() {
		super();
	}
	public Positionnement(String titre) {
		super();
		this.titre = titre;
	}
	@Override
	public String toString() {
		return titre;
	}
	
	

}
