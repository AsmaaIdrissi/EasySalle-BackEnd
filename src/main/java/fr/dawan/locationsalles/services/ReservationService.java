package fr.dawan.locationsalles.services;

import java.util.List;

import fr.dawan.locationsalles.model.Reservation;

public interface ReservationService {
	public Reservation save(Reservation reservation);
	public List<Reservation> save(List<Reservation> reservations);
	public void delet(Reservation reservation);
	public void delet(List<Reservation> reservation);
	public void upDate(Reservation reservations);
	//public void saveDetailReserrvation(Utilisateur user, int idIalle, Reservation reservation);

}
