/**
 * 
 */
package fr.dawan.locationsalles.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.exception.ResourceNotFoundException;

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
	
	@DeleteMapping("/salles/{idSalle}")
	public ResponseEntity<?> deleteSalle(@PathVariable(value = "idSalle") Integer idSalle) {
        Salle salle = repository.findById(idSalle)
                .orElseThrow(() -> new ResourceNotFoundException("salle", "idSalle", idSalle));
        repository.delete(salle);
        return ResponseEntity.ok().build();
    }
	
	

}
