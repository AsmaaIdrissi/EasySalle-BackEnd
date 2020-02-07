package fr.dawan.locationsalles.services;

import fr.dawan.locationsalles.model.Salle;

public interface SalleService {
	public Salle save(Salle salle);
	public Iterable<Salle> save(Iterable<Salle> salles);

}
