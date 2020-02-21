package fr.dawan.locationsalles.services;

import java.util.List;


import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.dawan.locationsalles.model.Salle;

public interface SalleService {
	public Salle save(Salle salle);
	public List<Salle> save(List<Salle> salles);
	public ResponseEntity<?>  deletSalle(@PathVariable(value = "id") int id) throws NotFoundException;
	public ResponseEntity<?> deletSalles(@PathVariable(value = "id") Iterable<Integer> id) throws NotFoundException;
	public Salle updateSalle(@PathVariable(value = "id") int salleId, @Valid @RequestBody Salle salleDetails) throws NotFoundException;
	public Salle getSalleById(int salleId) throws NotFoundException;
	public List<Salle> getAllSallesById(Iterable<Integer> sallesIds) throws NotFoundException;
	public List<Salle> getAllSalles();
	public Iterable<Salle> getSalleByVille(String ville);
	public Iterable<Salle> getSalleByCapacite(int capacite);
	public Iterable<Salle> getSalleByTypeEvenement(String typeEvenement);
	public Iterable<Salle> getSalleByCodePostale(int codePostale);
	public Iterable<Salle> getSalleByDisponibilite(boolean disponibilite);


}
