package fr.dawan.locationsalles.Factory;



import java.util.HashSet;
import java.util.Set;

import fr.dawan.locationsalles.DTO.SalleDTO;
import fr.dawan.locationsalles.model.Salle;

public class SalleFactory {

	/**
	 * Permet de construire une Salle à partir d'une SalleDTO
	 * 
	 * @param dto le DTO à convertir
	 * @param loadChildren false si vous voulez éviter la récursivité à partir de ce point
	 * @return
	 */
	public static Salle get(SalleDTO dto) {

		Salle entity = new Salle();
		entity.setCapacite(dto.getCapacite());
		entity.setCategorie(dto.getCategorie());
		entity.setCodePostale(dto.getCodePostale());
		entity.setDescription(dto.getDescription());
		entity.setDisponibilite(dto.getDisponibilite());
		entity.setGeocalisation(dto.getGeocalisation());
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setServicePropose(dto.getServicePropose());
		entity.setTypeEvenement(dto.getTypeEvenement());
		entity.setVille(dto.getVille());
		entity.setVoie(dto.getVoie());

		return entity;
	}

	public static Set<Salle> getEntities(Set<SalleDTO> dtos) {
		Set<Salle> set = new HashSet<>();

		// Pour chaque dto dans le set de dtos en paramètre
		// On le convertit en entité
		// puis on l'ajoute au set d'entités
		dtos.forEach(dto -> set.add(get(dto)));

		return set;
	}

	/**
	 * Permet de construire une SalleDTO à partir d'une Salle
	 * 
	 * @param entity
	 * @param loadReservation
	 * @return
	 */
	public static SalleDTO get(Salle entity, boolean loadReservation, boolean loadUser) {

		SalleDTO dto = new SalleDTO();
		dto.setCapacite(entity.getCapacite());
		dto.setCategorie(entity.getCategorie());
		dto.setCodePostale(entity.getCodePostale());
		dto.setDescription(entity.getDescription());
		dto.setDisponibilite(entity.getDisponibilite());
		dto.setGeocalisation(entity.getGeocalisation());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setServicePropose(entity.getServicePropose());
		dto.setTypeEvenement(entity.getTypeEvenement());
		dto.setVille(entity.getVille());
		dto.setVoie(entity.getVoie());

		if (loadReservation) {
			dto.setListeReservation(ReservationFactory.getDtos(entity.getListeReservation(), false, loadUser));
		}

		return dto;
	}

	public static SalleDTO get(Salle entity) {
		return get(entity, false, false);
	}

	public static Set<SalleDTO> getDtos(Set<Salle> entities) {
		Set<SalleDTO> set = new HashSet<>();

		// Pour chaque entité dans le set d'entités en paramètre
		// On le convertit en dto
		// puis on l'ajoute au set de dtos
		entities.forEach(e -> set.add(get(e)));

		return set;
	}
}
