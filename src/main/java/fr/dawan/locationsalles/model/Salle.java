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



/**
 * @author Admin-Stagiaire
 *
 */
@Entity
public class Salle{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idSalle")
	 private int id;
	@Column(name = "name")
	private String name ;
	@Column(name = "capacite")
	private int capacite;
	@Column(name = "ville")
	private String ville ;
	@Column(name = "voie")
	private String voie;
	@Column(name = "codePostale")
	private String codePostale;
	@Column(name = "typeEvenemment")
	private String typeEvenement;
	@Column(name = "servicePropose")
	private String servicePropose;
	@Column(name = "categorie")
	private int categorie;
	@Column(name = "description")
	private String description;
	@Column(name = "geocalisation")
	private String geocalisation;
	@Column(name = "disponibilite")
	private boolean disponibilite;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	
	@OneToMany(mappedBy = "salle")
	Set<Reservation> listeReservation =new HashSet<>();
	
	public Salle(int capacite, String ville, String voie, String codePostale, String typeEvenement,
			String servicePropose,int categorie, String description, String geocalisation, boolean disponibilite) {
		super();
		this.capacite = capacite;
		this.ville = ville;
		this.voie = voie;
		this.codePostale = codePostale;
		this.typeEvenement = typeEvenement;
		this.servicePropose = servicePropose;
		this.categorie=categorie;
		this.description = description;
		this.geocalisation = geocalisation;
		this.disponibilite= disponibilite;
	}
	
	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public Salle() {
		super();
	}

	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
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
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
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

	public Set<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(Set<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		
		return id;
	}
	
	

}
