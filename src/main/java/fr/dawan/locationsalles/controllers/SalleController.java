package fr.dawan.locationsalles.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.DTO.SalleDTO;
import fr.dawan.locationsalles.Factory.SalleFactory;
import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.repository.SalleRepository;
import fr.dawan.locationsalles.services.Impl.SalleServiceImpl;

@RestController
@RequestMapping("/salle")
@CrossOrigin(origins = "*")
public class SalleController {
	
	
	@Autowired 
	private SalleServiceImpl salleService;
	
	
	
	
	@GetMapping(value="/init")
	public void init() throws Exception {

		Map<String,Salle> map =new HashMap<>();
		map=salleService.generatesalles();
		//List<Integer> keys= new ArrayList<Integer>();
		List<Salle> values= new ArrayList<Salle>(map.values());
		
				salleService.save(values);
		
	}
	
	@GetMapping(value= {"","/","/all"})
	public List<Salle> findAll() {
		return salleService.findAll();
	}
	
	
	@GetMapping(value = "/searchByVille")
	public List<SalleDTO> findbyVille(@RequestParam("ville") String ville) {
		return  salleService.getSalleByVille(ville);
	}
	
	
	@GetMapping(value = "/searchByCapacite")
	public List<SalleDTO> findbyCapacite(@RequestParam("capacite") int capacite) {
		return (List<SalleDTO>) salleService.getSalleByCapacite(capacite);
	}
	
	
	@GetMapping(value = "/searchByEvent")
	public List<SalleDTO> findbyTypeEvenement(@RequestParam("typeEvenement") String typeEvenement) {
		return (List<SalleDTO>) salleService.getSalleByVille(typeEvenement);
	}
	

	@GetMapping(value = "/searchByCodePostale")
	public List<SalleDTO> findbyCodePostale(@RequestParam("codePostale") String codePostale) {
		return (List<SalleDTO>) salleService.getSalleByVille(codePostale);
	}
	
	@GetMapping(value = "/searchByDispo")
	public List<SalleDTO> findbyDisponibilite(@RequestParam("disponibilite") Boolean disponibilite) {
		return (List<SalleDTO>) salleService.getSalleByDisponibilite(disponibilite);
	}

	@GetMapping(value = "/picture/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> download(@PathVariable("id") int id) {
		byte[] image = salleService.find(id).getPicture();
		return ResponseEntity
				// renvoie un status code 200
				.ok()
				// précise le type mime
				.header(HttpHeaders.CONTENT_TYPE, "image/png")
				// on envoie l'objet attendu
				.body(image);

	
}

	
}


	



