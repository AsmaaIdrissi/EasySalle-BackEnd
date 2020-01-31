/**
 * 
 */
package fr.dawan.locationsalles.model;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	
	//constructeur
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

	//getters and setters
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
