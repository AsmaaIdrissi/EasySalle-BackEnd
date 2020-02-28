package fr.dawan.locationsalles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.locationsalles.model.Reservation;

public interface AdministrateurRepository  extends JpaRepository<Reservation, Integer>{
	
	
//	
//	@Query("select u from Utilisateur u " + " where u.username = ?1") 
//	Optional<Utilisateur> findUserWithName(String username);


}
