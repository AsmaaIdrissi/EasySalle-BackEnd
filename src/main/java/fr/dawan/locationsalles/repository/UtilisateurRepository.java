/**
 * 
 */
package fr.dawan.locationsalles.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.dawan.locationsalles.model.Utilisateur;





/**
 * @author Admin-Stagiaire
 *
 */
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {

	@Query
	Utilisateur findByUsername(String username);

}
