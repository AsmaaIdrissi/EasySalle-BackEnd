package fr.dawan.locationsalles.Factory;



import java.util.HashSet;
import java.util.Set;

import fr.dawan.locationsalles.DTO.ReservationDTO;
import fr.dawan.locationsalles.model.Reservation;

public class ReservationFactory {

	/**
	 * Permet de construire une Reservation à partir d'une ReservationDTO
	 * 
	 * @param dto le DTO à convertir
	 * @param loadChildren false si vous voulez éviter la récursivité à partir de ce point
	 * @return
	 */
	public static Reservation get(ReservationDTO dto) {

		Reservation entity = new Reservation();
		entity.setDateDebut(dto.getDateDebut());
		entity.setDateFin(dto.getDateFin());
		entity.setId(dto.getId());

		return entity;
	}

	public static Set<Reservation> getEntities(Set<ReservationDTO> dtos) {
		Set<Reservation> set = new HashSet<>();

		// Pour chaque dto dans le set de dtos en paramètre
		// On le convertit en entité
		// puis on l'ajoute au set d'entités
		dtos.forEach(dto -> set.add(get(dto)));

		return set;
	}

	/**
	 * Permet de construire une ReservationDTO à partir d'une Reservation
	 * 
	 * @param entity
	 * @param loadChildren
	 * @return
	 */
	public static ReservationDTO get(Reservation entity, boolean loadSalle, boolean loadUser) {

		ReservationDTO dto = new ReservationDTO();
		entity.setDateDebut(entity.getDateDebut());
		entity.setDateFin(entity.getDateFin());

		if (loadSalle) {
			entity.setSalle(SalleFactory.get(dto.getSalle()));
		}
		
		if (loadUser) {
			entity.setUtilisateur(UtilisateurFactory.get(dto.getUtilisateur()));
		}

		return dto;
	}

	public static ReservationDTO get(Reservation entity) {
		return get(entity, false, false);
	}

	public static Set<ReservationDTO> getDtos(Set<Reservation> entities) {
		Set<ReservationDTO> set = new HashSet<>();

		// Pour chaque entité dans le set d'entités en paramètre
		// On le convertit en dto
		// puis on l'ajoute au set de dtos
		entities.forEach(e -> set.add(get(e)));

		return set;
	}
	
	public static Set<ReservationDTO> getDtos(Set<Reservation> entities, boolean loadSalle, boolean loadUser) {
		Set<ReservationDTO> set = new HashSet<>();

		// Pour chaque entité dans le set d'entités en paramètre
		// On le convertit en dto
		// puis on l'ajoute au set de dtos
		entities.forEach(e -> set.add(get(e, loadSalle, loadUser)));

		return set;
	}
}
