package fr.dawan.locationsalles.DTO;

/**
 * 
 */


import java.util.HashSet;
import java.util.Set;

/**
 * @author Admin-Stagiaire
 *
 */
public class UtilisateurDTO {
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String mail;
	Set<ReservationDTO> listeReservation = new HashSet<>();

	// Constructeurs_______________________________________________________________________
	public UtilisateurDTO() {
		super();
	}

	public UtilisateurDTO(int id, String nom, String prenom, String adresse, String tel, String mail,
			Set<ReservationDTO> listeReservation) {
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

	public Set<ReservationDTO> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(Set<ReservationDTO> listeReservation) {
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
