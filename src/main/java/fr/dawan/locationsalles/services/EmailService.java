package fr.dawan.locationsalles.services;

import java.util.Date;

public interface EmailService {
	
	public void sendEmail(String mail, String nomSalle, Date dateDebut, Date dateFin, String voie,String ville);

}
