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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;





/**
 * @author mihandsafae
 *
 */
@Entity
public class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	 
	 @Column(name = "dateDebut")
	 private Date dateDebut;
	
	 @Column(name = "dateFin")
	 private Date dateFin ;
	 @ManyToOne
	    @JoinColumn
	    private Salle salle;
	 
	 @ManyToOne
	   @JoinColumn
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
	 
	 

}
