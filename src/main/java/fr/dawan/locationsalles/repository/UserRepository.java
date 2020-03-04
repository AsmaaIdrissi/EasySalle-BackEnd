package fr.dawan.locationsalles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.dawan.locationsalles.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	
	
//	
//	@Query("select u from Utilisateur u " + " where u.username = ?1") 
	@Query(value = "select * from user u where u.username =?1", nativeQuery = true)
	User findByUsername(String username);


}
