package fr.dawan.locationsalles;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.dawan.locationsalles.services.SalleService;
import fr.dawan.locationsalles.services.SalleServiceImpl;
import fr.dawan.locationsalles.services.UtilisateurService;
import fr.dawan.locationsalles.services.UtilisateurServiceImpl;


@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"fr.dawan.locationsalles.repository"} )
@ComponentScan("fr.dawan.locationsalles")
@PropertySource("classpath:application.properties")
public class JPAConfiguration {

	@Bean
	public SalleService salleService() {
		return new SalleServiceImpl();
		
	}
	
	@Bean
	public UtilisateurService utilisateurService() {
		return new UtilisateurServiceImpl();
		
	}
}
