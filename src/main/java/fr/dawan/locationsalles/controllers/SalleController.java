package fr.dawan.locationsalles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.services.Impl.SalleServiceImpl;

@RestController
@RequestMapping("/salle")
@CrossOrigin(origins = "http://localhost:4200")
public class SalleController {
	
	@Autowired 
	private SalleServiceImpl salleService;
	@Autowired 
	private SalleServiceImpl salleService1;
	
	@GetMapping("/init")
	public Salle init() throws NotFoundException {
		System.out.println("initalisation");
		
		Salle newSalle=new Salle();
		
		
//		newSalle.setCapacite("200");
//		newSalle.setCodePostale(44500);
//		newSalle.setDescription("salle de mariage avec plusieurs services");
//		newSalle.setDisponibilite(true);
//		newSalle.setTypeEvenement("mariege");
//		newSalle.setVille("nantes");
//		newSalle=salleService.save(newSalle);
//		System.out.println("new Id "+ newSalle.getId());
//		
//		System.out.println("ajout d'une liste de salle ");
//		List<Salle> listeSalles=new ArrayList<>();
//
//		Salle newSalle1=new Salle();
//		newSalle1.setCapacite("200");
//		newSalle1.setCodePostale(44500);
//		newSalle1.setDescription("salle de mariage avec plusieurs services");
//		newSalle1.setDisponibilite(true);
//		newSalle1.setTypeEvenement("mariege");
//		newSalle1.setVille("nantes");
//		listeSalles.add(newSalle1);
//		
//		Salle newSalle2=new Salle();
//		newSalle2.setCapacite("200");
//		newSalle2.setCodePostale(44500);
//		newSalle2.setDescription("salle de mariage avec plusieurs services");
//		newSalle2.setDisponibilite(true);
//		newSalle2.setTypeEvenement("mariege");
//		newSalle2.setVille("nantes");
//		listeSalles.add(newSalle2);
//		
//		Iterable<Salle> result= salleService.save(listeSalles);
//		for(Salle salle : result) {
//			System.out.println("new Id "+ salle.getId());
//		}
		

		newSalle=salleService.getSalleById(1);
		System.out.println(newSalle.getId());
		salleService1.deletSalle(1);
		
		System.out.println(newSalle);
		//salleService.deletAll(result);
		
		return newSalle;
		
	}
	

}
