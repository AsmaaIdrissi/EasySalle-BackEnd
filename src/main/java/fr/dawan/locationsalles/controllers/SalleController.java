package fr.dawan.locationsalles.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
		
		private static Map<String, Salle> salles = new HashMap<>();
		
		
		
		@GetMapping(value="/init")
		public void init() throws Exception {
	
			Map<String,Salle> map =new HashMap<>	();
			map=generatesalles();
			
			//List<Integer> keys= new ArrayList<Integer>();
			List<Salle> values= new ArrayList<Salle>(map.values());
			
					salleService.save(values);
			
		}
		
		
		 public Map<String,Salle> generatesalles()
				throws FileNotFoundException, IOException {
			
			FileReader filesallesReader = new FileReader("C:\\Users\\Admin-Stagiaire\\Desktop\\sallesNantes.csv");
			BufferedReader buffersallesReader = new BufferedReader(filesallesReader);
			
			String line = buffersallesReader.readLine();
			
			while ((line = buffersallesReader.readLine()) != null) {
				String[] data = line.split(",");
				//System.out.println(data[2]);
				
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
				salle.setDisponibilite((Integer.parseInt(data[10])==1));
				salle.setGeocalisation(data[11]);
				
				salles.put(data[0], salle);
			
				
			} 
		
			buffersallesReader.close();
			return salles;
		}
		
		
}
	
	
	
	
	
//	List<List<String>> salles = new ArrayList<List<String>>();
//	try (CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Admin-Stagiaire\\Desktop\\sallesNantes.csv"));) {
//	    String[]values = null;
//	    while ((values = csvReader.readNext()) != null) {
//	        salles.add(Arrays.asList(values));
//	    }
//	}
//	return salles;
//	}	

//@Autowired 
//private SalleServiceImpl salleService;
//@Autowired 
//private SalleServiceImpl salleService1;

//Salle newSalle=new Salle();

//
//Salle newSalle1=new Salle();
//newSalle1.setCapacite("200");
//newSalle1.setCodePostale(44500);
//newSalle1.setDescription("ggggggggggggggggggggg");
//newSalle1.setDisponibilite(true);
//newSalle1.setTypeEvenement("maaaaaaaaaaaa");
//newSalle1.setVille("nantes");
//
//
//newSalle=salleService.updateSalle(5, newSalle1);
//System.out.println("la salle  "+ newSalle.getId()+ newSalle);


//System.out.println("ajout d'une liste de salle ");
//List<Salle> listeSalles=new ArrayList<>();
//
//Salle newSalle1=new Salle();
//newSalle1.setCapacite("200");
//newSalle1.setCodePostale(44500);
//newSalle1.setDescription("salle de mariage avec plusieurs services");
//newSalle1.setDisponibilite(true);
//newSalle1.setTypeEvenement("mariege");
//newSalle1.setVille("nantes");
//listeSalles.add(newSalle1);
//
//Salle newSalle2=new Salle();
//newSalle2.setCapacite("200");
//newSalle2.setCodePostale(44500);
//newSalle2.setDescription("salle de mariage avec plusieurs services");
//newSalle2.setDisponibilite(true);
//newSalle2.setTypeEvenement("mariege");
//newSalle2.setVille("nantes");
//listeSalles.add(newSalle2);
//
//Iterable<Salle> result= salleService.save(listeSalles);
//for(Salle salle : result) {
//	System.out.println("new Id "+ salle.getId());
//}


//newSalle=salleService.getSalleById(1);
//System.out.println(newSalle.getId());
//salleService1.deletSalle(1);

//System.out.println(newSalle);
//salleService.deletAll(result);
		



