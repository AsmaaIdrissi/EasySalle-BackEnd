/**
 * 
 */
package fr.dawan.locationsalles.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Admin-Stagiaire
 *
 */
@Entity
public class Salle extends Identifiant {
	
	public Salle(int id) {
		super(id);
		
	}
	@Column(name = "capacite")
	private String capacite;
	@Column(name = "ville")
	private String ville ;
	@Column(name = "voie")
	private String voie;
	@Column(name = "codePostale")
	private int codePostale;
	@Column(name = "typeEvenemment")
	private String typeEvenement;
	@Column(name = "servicePropose")
	private String servicePropose;
	@Column(name = "description")
	private String description;
	@Column(name = "geocalisation")
	private String geocalisation;
	@Column(name = "disponibilite")
	private boolean disponibilite;
	
	
	
	
	@OneToMany
	Set<Reservation> listeReservation =new HashSet<>();
	
	public Salle(String capacite, String ville, String voie, int codePostale, String typeEvenement,
			String servicePropose, String description, String geocalisation, boolean disponibilite) {
		super();
		this.capacite = capacite;
		this.ville = ville;
		this.voie = voie;
		this.codePostale = codePostale;
		this.typeEvenement = typeEvenement;
		this.servicePropose = servicePropose;
		this.description = description;
		this.geocalisation = geocalisation;
		this.disponibilite = disponibilite;
	}
	
	public Salle() {
		super();
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
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
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
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGeocalisation() {
		return geocalisation;
	}
	public void setGeocalisation(String geocalisation) {
		this.geocalisation = geocalisation;
	}
	public boolean getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	
	

}
