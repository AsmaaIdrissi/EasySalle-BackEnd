package fr.dawan.locationsalles.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.repository.SalleRepository;
import fr.dawan.locationsalles.services.SalleService;


@Transactional
@Service 
public class SalleServiceImpl implements SalleService{
	
	@Autowired
	private SalleRepository salleRepository;
	@Override
	public Salle save(Salle salle) {
		return salleRepository.save(salle);
	}

	@Override
	public Iterable<Salle> save(Iterable<Salle> salles) {
		return salleRepository.saveAll(salles);	
	}
	@DeleteMapping("/Salles/{id}")
	@Override
	public ResponseEntity<?> deletSalle(@PathVariable(value = "id") int salleId) throws NotFoundException {
		
		Salle salle= salleRepository.findById(salleId).orElseThrow(() -> new NotFoundException());  
	
	salleRepository.delete(salle);
	return ResponseEntity.ok().build();
	
	}
	

	@Override
	public ResponseEntity<?> deletSalles(Iterable<Integer> ids) throws NotFoundException {
		Salle salle=new Salle();
	List<Salle> salles=new ArrayList<>();
		for(int id : ids) {
			salle= salleRepository.findById(id).orElseThrow(() -> new NotFoundException());  	
			salles.add(salle);
		}
		
		salleRepository.deleteAll(salles);
		return ResponseEntity.ok().build();	
		
	}

	@Override
	public Salle updateSalle(@PathVariable(value = "id") Integer SalleId,@Valid @RequestBody Salle salleDetails) throws NotFoundException {

		Salle salle = salleRepository.findById(SalleId)
				.orElseThrow(() -> new NotFoundException());

		salle.setCapacite(salleDetails.getCapacite());
		salle.setCodePostale(salleDetails.getCodePostale());
		salle.setCapacite(salleDetails.getDescription());
		salle.setDisponibilite(salleDetails.getDisponibilite());
		salle.setGeocalisation(salleDetails.getGeocalisation());
		salle.setVoie(salleDetails.getVoie());
		salle.setVille(salleDetails.getVille());
		salle.setServicePropose(salleDetails.getServicePropose());
		salle.setCapacite(salleDetails.getTypeEvenement());
	
		Salle updatedSalle = salleRepository.save(salle);
		return updatedSalle;
	}
	
	@Override
	public Salle getSalleById(@PathVariable(value = "id") int SalleId) throws NotFoundException {
	    return salleRepository.findById(SalleId).orElseThrow(() -> new NotFoundException());
	}

	
	
	
}



