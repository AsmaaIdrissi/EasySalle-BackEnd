package fr.dawan.locationsalles.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import fr.dawan.locationsalles.model.Salle;

public interface SalleService {
	public Salle save(Salle salle);
	public List<Salle> findAll();
	public List<Salle> save(List<Salle> salles);
	public ResponseEntity<?>  deletSalle(@PathVariable(value = "id") int id) throws NotFoundException;
	public ResponseEntity<?> deletSalles(@PathVariable(value = "id") Iterable<Integer> id) throws NotFoundException;
	public Salle updateSalle(@PathVariable(value = "id") int salleId, @Valid @RequestBody Salle salleDetails) throws NotFoundException;
	public Salle getSalleById(int salleId) throws NotFoundException;
	public List<Salle> getAllSallesById(Iterable<Integer> sallesIds) throws NotFoundException;
	public List<Salle> getAllSalles();
	public List<Salle> getSalleByVille(String ville);
	public List<Salle> getSalleByCapacite(int capacite);
	public List<Salle> getSalleByTypeEvenement(String typeEvenement);
	public List<Salle> getSalleByCodePostale(int codePostale);
	public List<Salle> getSalleByDisponibilite(boolean disponibilite);
	public Salle upload(int id, MultipartFile file) throws IOException, NotFoundException;
	public Map<String,Salle> generatesalles() throws FileNotFoundException, IOException;


}
