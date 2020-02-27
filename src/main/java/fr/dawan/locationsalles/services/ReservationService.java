package fr.dawan.locationsalles.services;

import fr.dawan.locationsalles.model.Reservation;
import fr.dawan.locationsalles.model.Utilisateur;

public interface ReservationService {
	public Reservation save(Reservation reservation);
	public Iterable<Reservation> save(Iterable<Reservation> reservations);
	public void delet(Reservation reservation);
	public void delet(Iterable<Reservation> reservation);
	public void upDate(Reservation reservations);
	//public void saveDetailReserrvation(Utilisateur user, int idIalle, Reservation reservation);

}
