/**
 * 
 */
package fr.dawan.locationsalles.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author Admin-Stagiaire
 *
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "tel" )
	private String tel;

	@Column(name = "mail")
	private String mail;

	@OneToMany(mappedBy = "utilisateur")
	Set<Reservation> listeReservation = new HashSet<>();

	// Constructeurs_______________________________________________________________________

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Utilisateur(int id, String nom, String prenom, String adresse, String tel, String mail,
			Set<Reservation> listeReservation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		this.listeReservation = listeReservation;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(Set<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
