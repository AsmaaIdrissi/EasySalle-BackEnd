package fr.dawan.locationsalles.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.model.Utilisateur;
import fr.dawan.locationsalles.services.Impl.SalleServiceImpl;
import fr.dawan.locationsalles.services.Impl.UtilisateurServiceImpl;


public class SaveTest {
	private SalleServiceImpl salleService;
	private UtilisateurServiceImpl userservice;
	
	@Before
	public void avantSave() {
		Salle s=new Salle();
		System.out.println("Avant shaque save");
		assertNotNull(s);
	}
	
	@After
	public void apresshaque() {
		System.out.println("Apres shaque");
	}
	

	@BeforeClass
	public static void avantslasse() {
		System.out.println("Avant slasse; 1fois");

		
	}
	@AfterClass
	public static void apresslasse() {
		System.out.println("Apres slasse; 1fois");

		
	}
	@Test
	public void saveSalleTest() {	
		
		System.out.println("saveSalleTest");
		
		Salle newSalle=new Salle();
		newSalle.setCapacite("200");
		newSalle.setCodePostale(44500);
		newSalle.setDescription("salle de mariage avec plusieurs services");
		newSalle.setDisponibilite(true);
		newSalle.setTypeEvenement("mariege");
		newSalle.setVille("nantes");
		
	
		
		try {
			assertEquals(newSalle, salleService.save(newSalle));
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	
	}
	
	@Test
	public void saveUtilisateurTest() {	
		System.out.println("saveSalleTest");
		
	Utilisateur newUtilisateur=new Utilisateur();
		
		newUtilisateur.setAdresse("2 boulevard xxx");
		newUtilisateur.setMail("xxxx@gmail.com");
		newUtilisateur.setNom("mmmmmm");
		newUtilisateur.setPrenom("nnnnnnnnn");
		newUtilisateur.setTel("0765432187");
		
		try {
			assertEquals(newUtilisateur, userservice.save(newUtilisateur));
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


}












