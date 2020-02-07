/**
 * 
 */
package fr.dawan.locationsalles.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Admin-Stagiaire
 *
 */
@Entity
public class Utilisateur {
	@Id
	private int idUtilisateur;
	
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String mail;
	
	
	@OneToMany
	Set<Reservation> listeReservation =new HashSet<>();
	
	
	public Utilisateur(int idUtilisateur, String prenom, String nom, String adresse, String tel, String mail) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
	}
	
	public Utilisateur() {
		super();
	}

	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
