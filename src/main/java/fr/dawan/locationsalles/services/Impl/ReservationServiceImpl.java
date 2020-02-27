package fr.dawan.locationsalles.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.locationsalles.model.Reservation;
import fr.dawan.locationsalles.repository.ReservationRepository;
import fr.dawan.locationsalles.services.ReservationService;
import fr.dawan.locationsalles.services.UtilisateurService;

@Transactional
@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private UtilisateurService utilisateurRepository;

	@Override
	public Reservation save(Reservation reservation) {
		reservationRepository.flush();
		return reservationRepository.save(reservation);
	}

	@Override
	public Iterable<Reservation> save(Iterable<Reservation> reservations) {

		return reservationRepository.saveAll(reservations);
	}

	@Override
	public void delet(Reservation reservation) {
		reservationRepository.delete(reservation);

	}

	@Override
	public void delet(Iterable<Reservation> reservations) {
		reservationRepository.deleteAll(reservations);

	}

	@Override
	public void upDate(Reservation reservation) {

	}

//	@Override
//	public void saveDetailReserrvation(Utilisateur user, int idSalle, Reservation reservation) {
//
//		/*Utilisateur utilisateur = new Utilisateur();
//		utilisateur.setNom(user.getNom());
//		utilisateur.setPrenom(user.getPrenom());
//		utilisateur.setMail(user.getMail());
//		utilisateur.setAdresse(user.getAdresse());
//		Reservation res = new Reservation();
//		reservation.setDateDebut(reservation.getDateDebut());
//		reservation.setDateFin(reservation.getDateFin());*/
//		Salle s = new Salle();
//
//		s.setId(idSalle);
//		s.setDisponibilite(false);
//		res.setSalle(s);
//		res.setUtilisateur(utilisateur);
//		utilisateurRepository.save(utilisateur);
//		reservationRepository.save(res);
//
//	}

}
