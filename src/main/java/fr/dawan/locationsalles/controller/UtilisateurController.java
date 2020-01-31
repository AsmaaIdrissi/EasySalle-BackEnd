/**
 * 
 */
package fr.dawan.locationsalles.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.model.Utilisateur;
import fr.dawan.locationsalles.repository.UtilisateurRepository;




/**
 * @author Admin-Stagiaire
 *
 */
@RestController
@RequestMapping("utilisateurs")
public class UtilisateurController {
	
	private final UtilisateurRepository repository;

	public UtilisateurController(UtilisateurRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public Iterable<Utilisateur> getUtilisateurs() {
		return repository.findAll();
	}	

	@PostMapping
	public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
		return repository.save(utilisateur);
	}
	
}
