/**
 * 
 */
package fr.dawan.locationsalles.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author mihandsafae
 *
 */
@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReservation")
	private int id;

	@Column(name = "dateDebut", nullable = true)
	private Date dateDebut;

	@Column(name = "dateFin", nullable = true)
	private Date dateFin;

	@ManyToOne(optional = false)
	
	private Salle salle;

	@ManyToOne(optional = false)
	private Utilisateur utilisateur;

	/**
	 * @param dateDebut
	 * @param dateFin
	 * @param salle
	 * @param utilisateur
	 */
	public Reservation(Date dateDebut, Date dateFin, Salle salle, Utilisateur utilisateur) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.salle = salle;
		this.utilisateur = utilisateur;
	}

	public Reservation() {

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
	public Salle getSalle() {
		return salle;
	}

	/**
	 * @param salle the salle to set
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id2) {
		// TODO Auto-generated method stub
		
	}

}
