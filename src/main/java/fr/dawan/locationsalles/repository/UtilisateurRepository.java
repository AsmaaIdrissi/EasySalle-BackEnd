/**
 * 
 */
package fr.dawan.locationsalles.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.dawan.locationsalles.model.Utilisateur;





/**
 * @author Admin-Stagiaire
 *
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

@Query
	Utilisateur findByMail(String mail);



}
