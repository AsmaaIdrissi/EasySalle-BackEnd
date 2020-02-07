/**
 * 
 */
package fr.dawan.locationsalles.repository;

import org.springframework.data.repository.CrudRepository;

import fr.dawan.locationsalles.model.Reservation;

/**
 * @author mihandsafae
 *
 */
public interface ReservationRepository extends CrudRepository<Reservation, Integer>{
	

}
