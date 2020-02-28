package fr.dawan.locationsalles.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.locationsalles.model.Utilisateur;
import fr.dawan.locationsalles.repository.UtilisateurRepository;
import fr.dawan.locationsalles.services.UtilisateurService;

@Transactional
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	public UtilisateurServiceImpl(UtilisateurRepository userRepository) {
		this.utilisateurRepository = userRepository;
	}

	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur user = utilisateurRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user present with username : " + username);
		} else {
			return user;
		}
	}*/
	
	

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public List<Utilisateur> save(List<Utilisateur> utilisateurs) {
		return utilisateurRepository.saveAll(utilisateurs);
	}

	@Override
	public Utilisateur findByMail(String mail) {
		
		return utilisateurRepository.findByMail(mail);
	}

	/*@Override
	public Utilisateur findByUsername(String username) {

		return utilisateurRepository.findByUsername(username);
	}*/

	

}