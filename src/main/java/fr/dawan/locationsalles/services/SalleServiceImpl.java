package fr.dawan.locationsalles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.locationsalles.model.Salle;
import fr.dawan.locationsalles.repository.SalleRepository;


@Transactional
@Service("SalleService")
public class SalleServiceImpl implements SalleService{
	
	@Autowired
	private SalleRepository salleRepository;
	@Override
	public Salle save(Salle salle) {
		return salleRepository.save(salle);
	}

	@Override
	public Iterable<Salle> listeSalles(Iterable<Salle> salles) {
		return salleRepository.saveAll(salles);	
	}

	
}
