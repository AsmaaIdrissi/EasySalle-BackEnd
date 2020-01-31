/**
 * 
 */
package fr.dawan.locationsalles.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.repository.SalleRepository;

/**
 * @author mihandsafae
 *
 */
@RestController
@RequestMapping("salles")
public class Sallecontroller {
	private final SalleRepository repository;
	
	public  Sallecontroller(SalleRepository repository) {
		this.repository=repository;
	}
	
	@GetMapping
	public Iterable<Salle> getSalles(){
		return repository.findAll();
	}
	
	@PostMapping
	public Salle addSalle(@RequestBody Salle salle) {
		return repository.save(salle);
		
	}
	
	

}
