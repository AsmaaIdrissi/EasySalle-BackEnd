package fr.dawan.locationsalles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.model.Utilisateur;

@RestController
@RequestMapping(value = "/email")
public class SimpleEmailController {

	@Autowired
	public JavaMailSender javaMailSender;

	@GetMapping("/confirmation")
	public void sendEmail(Utilisateur user) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo("asmaa.idrissi95@gmail.com");
		message.setSubject("Confirmation de la Réservation EasySalle");
		message.setText("Bonjour,"+"\r\n" +
			"Merci pour votre réservation,"+"\r\n" +  
			" Vous trouverez ci-dessous toutes les informations qui concernent votre salle réservée: "+"\r\n" +
			"	-Nom : "+"\r\n" + 
			"	-Adresse postal : "+"\r\n" + 
			"	-Date debut de réservation : "+"\r\n" + 
			"	-Date fin de réservation : "+"\r\n" +"\r\n" +
			
			
			"NB: vous avez 10 jours pour annuler votre reservation, après ce délais vous serez plus remboursés" +"\r\n" +
			"Pour toute information complémentaaire appeler le 02 40 41 90 00"+"\r\n" +
			
			"Cordialements,"+"\r\n" +
			"EassySalle"+"\r\n" 
			
			 );
		
		javaMailSender.send(message);
	}

}
