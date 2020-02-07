package fr.dawan.locationsalles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.locationsalles.model.Utilisateur;
import fr.dawan.locationsalles.repository.UtilisateurRepository;

@Transactional
@Service("UtilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}
	@Override
	public Iterable<Utilisateur> save(Iterable<Utilisateur> utilisateurs) {
		return utilisateurRepository.saveAll(utilisateurs);
}
}