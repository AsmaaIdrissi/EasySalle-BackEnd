package fr.dawan.locationsalles.DTO;

/**
 *
 */


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationLightDto {
	private int idSalle;
	private Date dateDebut;
	private Date dateFin;
	private SalleDTO salle;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;

}
