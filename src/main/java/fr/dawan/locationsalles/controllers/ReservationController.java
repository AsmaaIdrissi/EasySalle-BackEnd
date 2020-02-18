package fr.dawan.locationsalles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.model.Reservation;
import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.services.Impl.ReservationServiceImpl;
import fr.dawan.locationsalles.services.Impl.SalleServiceImpl;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {
	@Autowired 
	private ReservationServiceImpl reservationService;
	
	@Autowired
	private SalleServiceImpl salleService;
	@GetMapping("/init")
	public Reservation init() {
		System.out.println("initalisation");
		
		
		Salle newSalle=new Salle();
		//newSalle.setCapacite(200);
		newSalle.setCodePostale("44500");
		newSalle.setDescription("salle de mariage avec plusieurs services");
		newSalle.setDisponibilite(true);
		newSalle.setTypeEvenement("mariege");
		newSalle.setVille("nantes");
		
		newSalle=salleService.save(newSalle);
		/*
		
		Utilisateur newUtilisateur=new Utilisateur();
		
		newUtilisateur.setAdresse("2 boulevard xxx");
		newUtilisateur.setMail("xxxx@gmail.com");
		newUtilisateur.setNom("mmmmmm");
		newUtilisateur.setPrenom("nnnnnnnnn");
		newUtilisateur.setTel("0765432187");
		*/
		
		Reservation newReservation=new Reservation();
		newReservation.setSalle(newSalle);
		newReservation.setDateDebut(null);
		newReservation.setDateFin(null);
		newReservation.setUtilisateur(null);
		newReservation=reservationService.save(newReservation);
		System.out.println("new Id "+ newReservation.getId());
		
		//reservationService.delet(newReservation);
		//reservationService.delet(resule);
		return newReservation;
		
		
	}
}
