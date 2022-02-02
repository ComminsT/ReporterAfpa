package models;

public class Groupe {
	
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
	public Groupe(String titre) {
		super();
		this.titre = titre;
	}
	
	public Groupe() {
		super();
	}
	@Override
	public String toString() {
		return titre;
	}
	
	

}
