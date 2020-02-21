package fr.dawan.locationsalles.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.dawan.locationsalles.model.Utilisateur;



public interface UtilisateurService {
	public Utilisateur save(Utilisateur utilisateur);
	public Iterable<Utilisateur> save(Iterable<Utilisateur> utilisateurs);
	public Utilisateur findByUsername(String username);
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
