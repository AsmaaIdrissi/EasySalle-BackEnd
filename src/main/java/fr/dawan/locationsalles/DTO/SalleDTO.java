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
public class SalleDTO {
	private int id;
//	private byte[] picture;
	private String name;
	private int capacite;
	private String ville;
	private String voie;
	private String codePostale;
	private String typeEvenement;
	private String servicePropose;
	private int categorie;
	private String description;
	private String geocalisation;
	private boolean disponibilite;
	Set<ReservationDTO> listeReservation = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public byte[] getPicture() {
//		return picture;
//	}
//
//	public void setPicture(byte[] picture) {
//		this.picture = picture;
//	}

	public SalleDTO(int capacite, String ville, String voie, String codePostale, String typeEvenement,
			String servicePropose, int categorie, String description, String geocalisation, boolean disponibilite) {
		super();
		this.capacite = capacite;
		this.ville = ville;
		this.voie = voie;
		this.codePostale = codePostale;
		this.typeEvenement = typeEvenement;
		this.servicePropose = servicePropose;
		this.categorie = categorie;
		this.description = description;
		this.geocalisation = geocalisation;
		this.disponibilite = disponibilite;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public SalleDTO() {
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

	public Set<ReservationDTO> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(Set<ReservationDTO> listeReservation) {
		this.listeReservation = listeReservation;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {

		return id;
	}

}
