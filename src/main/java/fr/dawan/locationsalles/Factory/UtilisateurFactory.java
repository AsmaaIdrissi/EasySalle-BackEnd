package fr.dawan.locationsalles.Factory;



import java.util.HashSet;
import java.util.Set;

import fr.dawan.locationsalles.DTO.UtilisateurDTO;
import fr.dawan.locationsalles.model.Utilisateur;

public class UtilisateurFactory {

	/**
	 * Permet de construire un Utilisateur à partir d'un UtilisateurDTO
	 * 
	 * @param dto le DTO à convertir
	 * @param loadChildren false si vous voulez éviter la récursivité à partir de ce point
	 * @return
	 */
	public static Utilisateur get(UtilisateurDTO dto, boolean loadChildren) {

		Utilisateur entity = new Utilisateur();
		entity.setAdresse(dto.getAdresse());
		entity.setMail(dto.getMail());
		entity.setId(dto.getId());
		entity.setNom(dto.getNom());
		entity.setPrenom(dto.getPrenom());
		entity.setTel(dto.getTel());

		if (loadChildren) {
			entity.setListeReservation(ReservationFactory.getEntities(dto.getListeReservation()));
		}

		return entity;
	}

	public static Utilisateur get(UtilisateurDTO dto) {
		return get(dto, true);
	}

	public static Set<Utilisateur> getEntities(Set<UtilisateurDTO> dtos) {
		Set<Utilisateur> set = new HashSet<>();

		// Pour chaque dto dans le set de dtos en paramètre
		// On le convertit en entité
		// puis on l'ajoute au set d'entités
		dtos.forEach(dto -> set.add(get(dto)));

		return set;
	}

	/**
	 * Permet de construire un UtilisateurDTO à partir d'un Utilisateur
	 * 
	 * @param dto2
	 * @param loadChildren
	 * @return
	 */
	public static UtilisateurDTO get(Utilisateur entity, boolean loadChildren) {

		UtilisateurDTO dto = new UtilisateurDTO();
		dto.setAdresse(entity.getAdresse());
		dto.setMail(entity.getMail());
		dto.setId(entity.getId());
		dto.setNom(entity.getNom());
		dto.setPrenom(entity.getPrenom());
		dto.setTel(entity.getTel());

		if (loadChildren) {
			dto.setListeReservation(ReservationFactory.getDtos(entity.getListeReservation()));
		}

		return dto;
	}

	public static UtilisateurDTO get(Utilisateur entity) {
		return get(entity, false);
	}

	public static Set<UtilisateurDTO> getDtos(Set<Utilisateur> entities) {
		Set<UtilisateurDTO> set = new HashSet<>();

		// Pour chaque entité dans le set d'entités en paramètre
		// On le convertit en dto
		// puis on l'ajoute au set de dtos
		entities.forEach(e -> set.add(get(e)));

		return set;
	}

}
