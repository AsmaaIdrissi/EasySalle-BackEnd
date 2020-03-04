package fr.dawan.locationsalles.services;

import fr.dawan.locationsalles.model.User;

public interface UserService {
	 //void save(User user);

	    User findByUsername(String username);
}
