package dev.paie.service;

import java.time.Year;
import java.util.List;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.ContextInitConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;

@Service
@Import(ContextInitConfig.class)
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private EntityManager em;

	@Autowired
	private List<Cotisation> cotisations;

	@Autowired
	private List<Entreprise> entreprises;

	@Autowired
	private List<Grade> grades;

	@Autowired
	private List<ProfilRemuneration> profils;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initialiser() {

		// mise en base des données xml
		cotisations.stream().forEach(c -> em.persist(c));
		entreprises.stream().forEach(e -> em.persist(e));
		grades.stream().forEach(g -> em.persist(g));
		profils.stream().forEach(f -> em.persist(f));

		// mise en base des périodes
		IntStream.rangeClosed(1, 12).forEach(month -> {
			Periode p = new Periode();
			p.setDateDebut(Year.now().atMonth(month).atDay(1));
			p.setDateFin(Year.now().atMonth(month).atEndOfMonth());
			em.persist(p);
		});

		//enregistrement de deux utilisateurs
		Utilisateur admin = new Utilisateur();
		admin.setNomUtilisateur("admin");
		admin.setMotDePasse(passwordEncoder.encode("admin"));
		admin.setRole(ROLES.ROLE_ADMINISTRATEUR);
		admin.setEstActif(true);
		em.persist(admin);

		Utilisateur user = new Utilisateur();
		user.setNomUtilisateur("user");
		user.setMotDePasse(passwordEncoder.encode("user"));
		user.setRole(ROLES.ROLE_UTILISATEUR);
		user.setEstActif(true);
		em.persist(user);
	}

}
