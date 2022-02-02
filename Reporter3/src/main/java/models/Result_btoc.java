package models;

public class Result_btoc {
	private int id;
	private int nbr_contact_rappel;
	private int nbr_contact_argumente;
	private int nbr_inscription_ic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbr_contact_rappel() {
		return nbr_contact_rappel;
	}
	public void setNbr_contact_rappel(int nbr_contact_rappel) {
		this.nbr_contact_rappel = nbr_contact_rappel;
	}
	public int getNbr_contact_argumente() {
		return nbr_contact_argumente;
	}
	public void setNbr_contact_argumente(int nbr_contact_argumente) {
		this.nbr_contact_argumente = nbr_contact_argumente;
	}
	public int getNbr_inscription_ic() {
		return nbr_inscription_ic;
	}
	public void setNbr_inscription_ic(int nbr_inscription_ic) {
		this.nbr_inscription_ic = nbr_inscription_ic;
	}
	public Result_btoc(int nbr_contact_rappel, int nbr_contact_argumente, int nbr_inscription_ic) {
		super();
		this.nbr_contact_rappel = nbr_contact_rappel;
		this.nbr_contact_argumente = nbr_contact_argumente;
		this.nbr_inscription_ic = nbr_inscription_ic;
	}
	public Result_btoc() {
		super();
	}
	

}
