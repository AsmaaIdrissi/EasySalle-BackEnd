package fr.dawan.locationsalles.services;

import fr.dawan.locationsalles.model.Utilisateur;

public interface UtilisateurService {
	public Utilisateur save(Utilisateur utilisateur);
	public Iterable<Utilisateur> save(Iterable<Utilisateur> utilisateurs);
}
