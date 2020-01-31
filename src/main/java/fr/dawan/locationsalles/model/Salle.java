/**
 * 
 */
package fr.dawan.locationsalles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Admin-Stagiaire
 *
 */
@Entity
public class Salle {
	@Id
	@Column(name = "idSalle")
	private int idSalle;
	@Column(name = "capacite")
	private String capacite;
	@Column(name = "ville")
	private String ville ;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "codePostale")
	private int codePostale;
	@Column(name = "typeEvenemment")
	private String typeEvenement;
	@Column(name = "servicePropose")
	private String servicePropose;
	@Column(name = "Description")
	private String Description;
	@Column(name = "geocalisation")
	private String geocalisation;
	@Column(name = "disponibilite")
	private boolean disponibilite;
	
	//constructeur
	public Salle(int idSalle, String capacite, String ville, String adresse, int codePostale, String typeEvenement,
			String servicePropose, String description, String geocalisation, boolean disponibilite) {
		super();
		this.idSalle = idSalle;
		this.capacite = capacite;
		this.ville = ville;
		this.adresse = adresse;
		this.codePostale = codePostale;
		this.typeEvenement = typeEvenement;
		this.servicePropose = servicePropose;
		Description = description;
		this.geocalisation = geocalisation;
		this.disponibilite = disponibilite;
	}
	
	public Salle() {
		super();
	}

	// getters and setters
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}
	public String getTypeEvenement() {
		return typeEvenement;
	}
	public void setTypeEvenement(String typeEvenement) {
		this.typeEvenement = typeEvenement;
	}
	public String getServicePropose() {
		return servicePropose;
	}
	public void setServicePropose(String servicePropose) {
		this.servicePropose = servicePropose;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getGeocalisation() {
		return geocalisation;
	}
	public void setGeocalisation(String geocalisation) {
		this.geocalisation = geocalisation;
	}
	public boolean isDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	

}
