package fr.dawan.locationsalles.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.locationsalles.model.User;
import fr.dawan.locationsalles.repository.RoleRepository;
import fr.dawan.locationsalles.repository.UserRepository;
import fr.dawan.locationsalles.services.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService{
	 @Autowired
	    private UserRepository userRepository;
	  @Autowired
	    private RoleRepository roleRepository;
//	  @Autowired
//	    private BCryptPasswordEncoder bCryptPasswordEncoder;

//	  @Override
//	    public void save(User user) {
//	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//	        user.setRoles(new HashSet<>(roleRepository.findAll()));
//	        userRepository.save(user);
//	    }

	    @Override
	    public User findByUsername(String username) {
	    	System.out.println("test");
	    	User user1=userRepository.findByUsername(username);
	    	System.out.println(user1.getUsername());
	        return user1;
	    }

}
