package fr.dawan.locationsalles.services.Impl;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.locationsalles.services.EmailService;


@Service
@Transactional
public class EmailServiceImpl implements EmailService{
	
	
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(String mail,String nomSalle,Date dateDebut, Date dateFin, String voie,String ville) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(mail);
		message.setSubject("Confirmation de la Réservation EasySalle");
		message.setText("Bonjour,"+"\r\n" +
			"Merci pour votre réservation,"+"\r\n" +  
			" Vous trouverez ci-dessous toutes les informations qui concernent votre salle réservée: "+"\r\n" +
			"	-Nom : "+nomSalle+"\r\n" + 
			"	-Adresse postal : " +voie+" , "+ville  +"\r\n" + 
			"	-Date debut de réservation : "+ dateDebut+"\r\n" + 
			"	-Date fin de réservation : "+dateFin+"\r\n" +"\r\n" +
			
			
			"NB: vous avez 10 jours pour annuler votre reservation, après ce délais vous serez plus remboursés" +"\r\n" +
			"Pour toute information complémentaaire appeler le 02 40 41 90 00"+"\r\n" +
			
			"Cordialements,"+"\r\n" +
			"EassySalle"+"\r\n" 
			
			 );
		
		javaMailSender.send(message);
	}



}
