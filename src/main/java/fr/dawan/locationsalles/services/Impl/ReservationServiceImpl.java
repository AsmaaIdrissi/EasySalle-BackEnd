package fr.dawan.locationsalles.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.locationsalles.model.Reservation;
import fr.dawan.locationsalles.repository.ReservationRepository;
import fr.dawan.locationsalles.services.ReservationService;

@Transactional
@Service
public class ReservationServiceImpl implements ReservationService{

	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public Reservation save(Reservation reservation) {
		
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
		// TODO Auto-generated method stub
		
	}

}
