package models;

public class Group_list {
	private int id;
	private int id_groupe;
	private int id_utilisateur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_groupe() {
		return id_groupe;
	}

	public void setId_groupe(int id_groupe) {
		this.id_groupe = id_groupe;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public Group_list(int id_groupe, int id_utilisateur) {
		super();
		this.id_groupe = id_groupe;
		this.id_utilisateur = id_utilisateur;
	}

	public Group_list() {
		super();
	}

	public boolean isfromgroup(int id_group) {
		if (this.getId_groupe() == id_group) {
			System.out.println("true");
			return true;
		} else {

			return false;
		}

	}

}
