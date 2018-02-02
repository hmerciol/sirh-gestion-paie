package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.ContextInitConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

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

	@Transactional
	@Override
	public void initialiser() {
		
		// mise en base des données xml
		cotisations.stream().forEach(c -> em.persist(c));
		entreprises.stream().forEach(e -> em.persist(e));
		grades.stream().forEach(g -> em.persist(g));
		profils.stream().forEach(f -> em.persist(f));
		
		// mise en base des périodes
		IntStream.rangeClosed(1, 12).forEach(month -> {
			Periode p = new Periode();
			LocalDate date = LocalDate.of(2017, month, 1);
			p.setDateDebut(date);
			p.setDateFin(date.with(TemporalAdjusters.lastDayOfMonth()));
			em.persist(p);
		});
	}

}
