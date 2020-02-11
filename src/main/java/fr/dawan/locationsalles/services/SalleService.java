package fr.dawan.locationsalles.services;

import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.dawan.locationsalles.model.Identifiant;
import fr.dawan.locationsalles.model.Salle;

public interface SalleService {
	public Salle save(Salle salle);
	public Iterable<Salle> save(Iterable<Salle> salles);
	public ResponseEntity<?>  deletSalle(@PathVariable(value = "id") Identifiant id) throws NotFoundException;
	public ResponseEntity<?> deletSalles(@PathVariable(value = "id") Iterable<Identifiant> id) throws NotFoundException;
	public Salle updateSalle(@PathVariable(value = "id") Integer SalleId, @Valid @RequestBody Salle salleDetails) throws NotFoundException;
	public Salle getSalleById(int SalleId) throws NotFoundException;


}
