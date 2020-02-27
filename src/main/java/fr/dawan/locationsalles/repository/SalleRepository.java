package fr.dawan.locationsalles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.dawan.locationsalles.model.Salle;

public interface SalleRepository  extends JpaRepository<Salle, Integer>{
	/**
	 * méthode qui retourne la liste des salles dont le param est ville
	 * 
	 * @param ville
	 * @return listes des salles
	 */
	@Query
	public Iterable<Salle> getSalleByVille(String ville);
	/**
	 * méthode qui retourne la liste des salles dont la capacite entre deux nombres
	 * 
	 * @param capacite
	 * @return listes des salles
	 */
	@Query(value = "select * from Salle s where s.capacite =?1", nativeQuery = true)
	public Iterable<Salle> getSalleByCapacite(int capacite);
	/**
	 * Méthode renvoi la liste des salles par type Evenemment
	 * 
	 * @param typeEvenement
	 * @return liste des salles
	 */
	@Query
	public Iterable<Salle> getSalleByTypeEvenement(String typeEvenement);
	/**
	 * Méthode qui renvoi la liste des salles par code postale
	 * 
	 * @param codePostale
	 * @return
	 */
	@Query
	public Iterable<Salle> getSalleByCodePostale(int codePostale);
	/**
	 * Méthode renvoi la liste des salles disponible
	 * 
	 * @param disponibilite
	 * @return
	 */
	@Query(value = "select * from Salle s where s.disponibilite =?1", nativeQuery = true)
	public Iterable<Salle> getSalleByDisponibilite(boolean disponibilite);
}


