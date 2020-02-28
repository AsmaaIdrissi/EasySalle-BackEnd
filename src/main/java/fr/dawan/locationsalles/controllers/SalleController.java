package fr.dawan.locationsalles.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.services.Impl.SalleServiceImpl;
import javassist.NotFoundException;

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
	public List<Salle> findbyVille(@RequestParam("ville") String ville) {
		return  salleService.getSalleByVille(ville);
	}
	
	
	@GetMapping(value = "/searchByCapacite")
	public List<Salle> findbyCapacite(@RequestParam("capacite") String capacite) {
		return (List<Salle>) salleService.getSalleByVille(capacite);
	}
	
	
	@GetMapping(value = "/searchByEvent")
	public List<Salle> findbyTypeEvenement(@RequestParam("typeEvenement") String typeEvenement) {
		return (List<Salle>) salleService.getSalleByVille(typeEvenement);
	}
	

	@GetMapping(value = "/searchByCodePostale")
	public List<Salle> findbyCodePostale(@RequestParam("codePostale") String codePostale) {
		return (List<Salle>) salleService.getSalleByVille(codePostale);
	}
	
	@GetMapping(value = "/searchByDispo")
	public List<Salle> findbyDisponibilite(@RequestParam("disponibilite") Boolean disponibilite) {
		return (List<Salle>) salleService.getSalleByDisponibilite(disponibilite);
	}
	
	
@PostMapping(value="/upload/{id}", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
public Salle uploadFile(
		@PathVariable("id") int id,
		@RequestParam(name="monument_file") MultipartFile file) throws  Exception{
	
	return salleService.upload(id, file);
}
	
}


	



