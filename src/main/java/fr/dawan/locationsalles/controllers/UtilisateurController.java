/**
 * 
 */
package fr.dawan.locationsalles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.services.Impl.UtilisateurServiceImpl;


@RestController
@Controller("/user")
public class UtilisateurController {

	@Autowired 
	private UtilisateurServiceImpl userservice;

	


	@GetMapping("/init")
	public void init() {

		
		

	}
}