package fr.dawan.locationsalles.services;

import java.util.List;

import fr.dawan.locationsalles.model.Utilisateur;



public interface UtilisateurService {
	public Utilisateur save(Utilisateur utilisateur);
	public List<Utilisateur> save(List<Utilisateur> utilisateurs);
	public Utilisateur findByMail(String mail);
	
	//UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
