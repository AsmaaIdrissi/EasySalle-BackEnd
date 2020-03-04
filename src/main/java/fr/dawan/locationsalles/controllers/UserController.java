package fr.dawan.locationsalles.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.locationsalles.model.User;
import fr.dawan.locationsalles.services.Impl.UserServiceImpl;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired 
	private UserServiceImpl userService;
	
	@GetMapping(value = "/auth")
	public User findbyusername(@RequestParam("username") String username) {
		System.out.println("test je suis la ");
		User user1=userService.findByUsername(username);
		return  user1;
}
	
//	 @GetMapping(path = "/basicauth")
//	    public AuthenticationBean basicauth() {
//	        return new AuthenticationBean("You are authenticated");
//	    }
//	
//	@Autowired 
//	private AdministrateurServiceImpl adminService;
//	
	

}

