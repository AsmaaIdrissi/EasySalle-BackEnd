package fr.dawan.locationsalles.services.Impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.repository.SalleRepository;
import fr.dawan.locationsalles.services.SalleService;

@Transactional
@Service
public class SalleServiceImpl implements SalleService {

	@Autowired
	private SalleRepository salleRepository;

	@Override
	public Salle save(Salle salle) {
		return salleRepository.save(salle);
	}

	@Override
	public List<Salle> save(List<Salle> salles) {
		return (List<Salle>) salleRepository.saveAll(salles);
	}

	@DeleteMapping("/Salles/{id}")
	@Override
	public ResponseEntity<?> deletSalle(@PathVariable(value = "id") int salleId) throws NotFoundException {

		Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new NotFoundException());

		salleRepository.delete(salle);
		return ResponseEntity.ok().build();

	}

	@Override
	public ResponseEntity<?> deletSalles(Iterable<Integer> ids) throws NotFoundException {
		Salle salle = new Salle();
		List<Salle> salles = new ArrayList<>();
		for (int id : ids) {
			salle = salleRepository.findById(id).orElseThrow(() -> new NotFoundException());
			salles.add(salle);
		}

		salleRepository.deleteAll(salles);
		return ResponseEntity.ok().build();

	}

	@Override
	public Salle updateSalle(@PathVariable(value = "id") int SalleId, @Valid @RequestBody Salle salleDetails)
			throws NotFoundException {

		Salle salle = salleRepository.findById(SalleId).orElseThrow(() -> new NotFoundException());

		salle.setName(salleDetails.getName());
		salle.setCategorie(salleDetails.getCategorie());
		salle.setCapacite(salleDetails.getCapacite());
		salle.setCodePostale(salleDetails.getCodePostale());
		salle.setDescription(salleDetails.getDescription());
		salle.setDisponibilite(salleDetails.getDisponibilite());
		salle.setGeocalisation(salleDetails.getGeocalisation());
		salle.setVoie(salleDetails.getVoie());
		salle.setVille(salleDetails.getVille());
		salle.setServicePropose(salleDetails.getServicePropose());
		salle.setTypeEvenement(salleDetails.getTypeEvenement());

		Salle updatedSalle = salleRepository.save(salle);
		return updatedSalle;
	}

	@Override
	public Salle getSalleById(@PathVariable(value = "id") int salleId) throws NotFoundException {
		return salleRepository.findById(salleId).orElseThrow(() -> new NotFoundException());
	}

	@Override
	public List<Salle> getAllSallesById(Iterable<Integer> sallesIds) throws NotFoundException {
		List<Salle> salles = new ArrayList<Salle>();
		for (Integer id : sallesIds) {
			salles.add(salleRepository.findById(id).orElseThrow(() -> new NotFoundException()));
		}

		return salles;
	}

	@Override
	public List<Salle> getAllSalles() {
		return (List<Salle>) salleRepository.findAll();
	}

	@Override
	public List<Salle> getSalleByVille(String ville) {
		List<Salle> salles = salleRepository.getSalleByVille(ville);
		salles.forEach(s -> s.getListeReservation().forEach(r -> r.setSalle(null)));
		return salles;
	}

	@Override
	public List<Salle> getSalleByCapacite(int capacite) {
		return salleRepository.getSalleByCapacite(capacite);
	}

	@Override
	public List<Salle> getSalleByTypeEvenement(String typeEvenement) {
		return salleRepository.getSalleByTypeEvenement(typeEvenement);
	}

	@Override
	public List<Salle> getSalleByCodePostale(int codePostale) {
		return salleRepository.getSalleByCodePostale(codePostale);
	}

	@Override
	public List<Salle> getSalleByDisponibilite(boolean disponibilite) {
		return salleRepository.getSalleByDisponibilite(disponibilite);
	}

	public Salle upload(int id, MultipartFile file) throws IOException, NotFoundException {
		Salle salle = (salleRepository.findById(id).orElseThrow(() -> new NotFoundException()));
		if (salle != null) {
			salle.setPicture(file.getBytes());
		}
		salleRepository.save(salle);
		return salle;
	}

	public Map<String, Salle> generatesalles() throws FileNotFoundException, IOException {
		Map<String, Salle> salles = new HashMap<>();

		FileReader filesallesReader = new FileReader("input/sallesNantes.csv");
		BufferedReader buffersallesReader = new BufferedReader(filesallesReader);

		String line = buffersallesReader.readLine();

		while ((line = buffersallesReader.readLine()) != null) {
			String[] data = line.split(",");
			// System.out.println(data[2]);

			Salle salle = new Salle();

			salle.setId(Integer.parseInt(data[0]));
			salle.setName(data[1]);
			salle.setCapacite(Integer.parseInt(data[2]));
			salle.setVille(data[3]);
			salle.setCodePostale(data[4]);
			salle.setVoie(data[5]);
			salle.setServicePropose(data[6]);
			salle.setCategorie(Integer.parseInt(data[7]));
			salle.setTypeEvenement(data[8]);
			salle.setDescription(data[9]);
			salle.setDisponibilite((Integer.parseInt(data[10]) == 1));
			salle.setGeocalisation(data[11]);

			salles.put(data[0], salle);

		}

		buffersallesReader.close();
		return salles;
	}

	@Override
	public List<Salle> findAll() {

		return salleRepository.findAll();
	}


	
	public Salle find(int id) {
		return salleRepository.findById(id).orElse(new Salle());
	}
}
