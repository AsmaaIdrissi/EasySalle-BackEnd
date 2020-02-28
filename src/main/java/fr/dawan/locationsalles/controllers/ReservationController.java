package fr.dawan.locationsalles.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.model.Reservation;
import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.model.Utilisateur;
import fr.dawan.locationsalles.repository.SalleRepository;
import fr.dawan.locationsalles.services.Impl.ReservationServiceImpl;
import fr.dawan.locationsalles.services.Impl.SalleServiceImpl;
import fr.dawan.locationsalles.services.Impl.UtilisateurServiceImpl;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
	@Autowired
	private ReservationServiceImpl reservationService;

	@Autowired
	private UtilisateurServiceImpl utilisateurServcie;

	@Autowired
	private SalleServiceImpl salleService;
	@Autowired
	private SalleRepository salleRepository;

	@GetMapping(value = "/reserver")
	public void reserver(Utilisateur user, @DateTimeFormat(iso=ISO.DATE) @RequestParam("dateDebut") Date dateDebut , @DateTimeFormat(iso=ISO.DATE) @RequestParam("dateFin") Date dateFin, @RequestParam("mail") String mail,
			@RequestParam(name = "idSalle", required = false) int idSalle) {

		Reservation newReservation = new Reservation();
		Salle salle = salleRepository.findById(idSalle).orElse(null);

		Utilisateur userFromDB = utilisateurServcie.findByMail(mail);
// hiiiiiiiiiii safae je suis lààààààààààààà----------------
		if (userFromDB == null) {
			userFromDB = utilisateurServcie.save(user);
		}
		newReservation.setDateDebut(dateDebut);
		newReservation.setDateFin(dateFin);
		newReservation.setUtilisateur(userFromDB);
		newReservation.setSalle(salle);
		reservationService.save(newReservation);
		userFromDB.getListeReservation().add(newReservation);
		salle.getListeReservation().add(newReservation);
		utilisateurServcie.save(userFromDB);
		salle.setDisponibilite(false);
		salleService.save(salle);
	}
	
	
	
}

//		System.out.println("initalisation");
//		
//		
//		Salle newSalle=new Salle();
//		//newSalle.setCapacite(200);
//		newSalle.setCodePostale("44500");
//		newSalle.setDescription("salle de mariage avec plusieurs services");
//		newSalle.setDisponibilite(true);
//		newSalle.setTypeEvenement("mariege");
//		newSalle.setVille("nantes");
//		
//		newSalle=salleService.save(newSalle);
//		/*
//		
//		Utilisateur newUtilisateur=new Utilisateur();
//		
//		newUtilisateur.setAdresse("2 boulevard xxx");
//		newUtilisateur.setMail("xxxx@gmail.com");
//		newUtilisateur.setNom("mmmmmm");
//		newUtilisateur.setPrenom("nnnnnnnnn");
//		newUtilisateur.setTel("0765432187");
//		*/
//		
//		Reservation newReservation=new Reservation();
//		newReservation.setSalle(newSalle);
//		newReservation.setDateDebut(null);
//		newReservation.setDateFin(null);
//		newReservation.setUtilisateur(null);
//		newReservation=reservationService.save(newReservation);
//		System.out.println("new Id "+ newReservation.getId());
//		
//		//reservationService.delet(newReservation);
//		//reservationService.delet(resule);
//		return newReservation;
//		
