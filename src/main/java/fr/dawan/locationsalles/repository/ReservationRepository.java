/**
 * 
 */
package fr.dawan.locationsalles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.locationsalles.model.Reservation;

/**
 * @author mihandsafae
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
