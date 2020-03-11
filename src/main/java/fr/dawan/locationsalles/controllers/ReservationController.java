package fr.dawan.locationsalles.controllers;

import java.util.Date;

import fr.dawan.locationsalles.DTO.ReservationDTO;
import fr.dawan.locationsalles.DTO.ReservationLightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.*;

import fr.dawan.locationsalles.model.Reservation;
import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.model.Utilisateur;
import fr.dawan.locationsalles.repository.SalleRepository;
import fr.dawan.locationsalles.services.Impl.EmailServiceImpl;
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

	@Autowired
	private EmailServiceImpl emailService;

	@GetMapping(value = "/reserver")
	public void reserver(Utilisateur user,
			@DateTimeFormat(iso=ISO.DATE) @RequestParam("dateDebut") Date dateDebut ,
			@DateTimeFormat(iso=ISO.DATE) @RequestParam("dateFin") Date dateFin,
			@RequestParam("mail") String mail,
			@RequestParam(name = "idSalle", required = false) int idSalle)
	{

		Reservation newReservation = new Reservation();
		Salle salle = salleRepository.findById(idSalle).orElse(null);

		Utilisateur userFromDB = utilisateurServcie.findByMail(mail);


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

		emailService.sendEmail(mail,salle.getName(),dateDebut,dateFin,salle.getVoie(),salle.getVille() );
	}

	@PostMapping(value = "/creer")
	public void reserve(@RequestBody ReservationLightDto dto)
	{

		Reservation newReservation = new Reservation();
		Salle salle = salleRepository.findById(dto.getIdSalle()).orElse(null);

		Utilisateur userFromDB = utilisateurServcie.findByMail(dto.getEmail());


		if (userFromDB == null) {
		  Utilisateur utilisateur = new Utilisateur();
      utilisateur.setMail(dto.getEmail());
      utilisateur.setAdresse(dto.getAdresse());
      utilisateur.setNom(dto.getNom());
      utilisateur.setPrenom(dto.getPrenom());
			userFromDB = utilisateurServcie.save(utilisateur);
		}
		newReservation.setDateDebut(dto.getDateDebut());
		newReservation.setDateFin(dto.getDateFin());
		newReservation.setUtilisateur(userFromDB);
		newReservation.setSalle(salle);
		reservationService.save(newReservation);
		userFromDB.getListeReservation().add(newReservation);
		salle.getListeReservation().add(newReservation);
		utilisateurServcie.save(userFromDB);
		salle.setDisponibilite(false);
		salleService.save(salle);

		//emailService.sendEmail(dto.getEmail(),salle.getName(),dto.getDateDebut(),dto.getDateFin(),salle.getVoie(),salle.getVille() );
	}



}

