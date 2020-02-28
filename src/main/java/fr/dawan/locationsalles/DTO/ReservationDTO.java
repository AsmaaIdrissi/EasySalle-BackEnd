package fr.dawan.locationsalles.DTO;

/**
 * 
 */


import java.util.Date;

/**
 * @author mihandsafae
 *
 */
public class ReservationDTO {
	private int id;
	private Date dateDebut;
	private Date dateFin;
	private SalleDTO salle;
	private UtilisateurDTO utilisateur;

	/**
	 * @param dateDebut
	 * @param dateFin
	 * @param salle
	 * @param utilisateur
	 */
	public ReservationDTO(Date dateDebut, Date dateFin, SalleDTO salle, UtilisateurDTO utilisateur) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.salle = salle;
		this.utilisateur = utilisateur;
	}

	public ReservationDTO() {

	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the salle
	 */
	public SalleDTO getSalle() {
		return salle;
	}

	/**
	 * @param salle the salle to set
	 */
	public void setSalle(SalleDTO salle) {
		this.salle = salle;
	}

	/**
	 * @return the utilisateur
	 */
	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

}
