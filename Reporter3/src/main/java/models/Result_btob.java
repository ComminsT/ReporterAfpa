package models;

public class Result_btob {
	
	private int id;
	private int envoi_catalogue;
	private int inscription_event;
	private int nbr_prise_rdv;
	private int nbr_devis;
	private int nbr_convention;
	private String commentaire;
	private int id_resultat_btoc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnvoi_catalogue() {
		return envoi_catalogue;
	}
	public void setEnvoi_catalogue(int envoi_catalogue) {
		this.envoi_catalogue = envoi_catalogue;
	}
	public int getInscription_event() {
		return inscription_event;
	}
	public void setInscription_event(int inscription_event) {
		this.inscription_event = inscription_event;
	}
	public int getNbr_prise_rdv() {
		return nbr_prise_rdv;
	}
	public void setNbr_prise_rdv(int nbr_prise_rdv) {
		this.nbr_prise_rdv = nbr_prise_rdv;
	}
	public int getNbr_devis() {
		return nbr_devis;
	}
	public void setNbr_devis(int nbr_devis) {
		this.nbr_devis = nbr_devis;
	}
	public int getNbr_convention() {
		return nbr_convention;
	}
	public void setNbr_convention(int nbr_convention) {
		this.nbr_convention = nbr_convention;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public int getId_resultat_btoc() {
		return id_resultat_btoc;
	}
	public void setId_resultat_btoc(int id_resultat_btoc) {
		this.id_resultat_btoc = id_resultat_btoc;
	}
	public Result_btob(int envoi_catalogue, int inscription_event, int nbr_prise_rdv, int nbr_devis, int nbr_convention,
			String commentaire, int id_resultat_btoc) {
		super();
		this.envoi_catalogue = envoi_catalogue;
		this.inscription_event = inscription_event;
		this.nbr_prise_rdv = nbr_prise_rdv;
		this.nbr_devis = nbr_devis;
		this.nbr_convention = nbr_convention;
		this.commentaire = commentaire;
		this.id_resultat_btoc = id_resultat_btoc;
	}
	public Result_btob() {
		super();
	}
	
	
	
	

}
