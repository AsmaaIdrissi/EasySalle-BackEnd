/**
 * 
 */
package fr.dawan.locationsalles.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.model.Utilisateur;
import fr.dawan.locationsalles.services.Impl.UtilisateurServiceImpl;

/**
 * @author mihandsafae
 *
 */
@RestController
@RequestMapping("/utilisateur")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
	@Autowired 
	private UtilisateurServiceImpl userservice;
	
	@GetMapping("/init")
	public void init() {
		
		List<Utilisateur> listeUsers =new ArrayList<>();
		
		Utilisateur utilisateur=new Utilisateur();
		utilisateur.setNom("safae");
		utilisateur.setPrenom("mihand");
		utilisateur.setMail("bensaid.safae@gmail.com");
		utilisateur.setAdresse("22 rue paul verlaine");
		utilisateur.setTel("0660896567");
		listeUsers.add(utilisateur);
		System.out.println(utilisateur);
		Utilisateur utilisateur1=new Utilisateur();
		utilisateur1.setNom("safae");
		utilisateur1.setPrenom("mihand");
		utilisateur1.setMail("bensaid.safae@gmail.com");
		utilisateur1.setAdresse("22 rue paul verlaine");
		utilisateur1.setTel("0660896567");
		
		listeUsers.add(utilisateur1);
		userservice.save(utilisateur);
		//Iterable<Utilisateur> result= userservice.save(listeUsers);
		//System.out.println(result);
		//for(Utilisateur user : result) {
		//	System.out.println("new Id "+ user.getId());
		//}
		
		
		//return result;
		System.out.println("utilisateur ajouter avec succee");
	}
}
