package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		em.persist(nouveauGrade);
	}

	@Transactional
	@Override
	public void mettreAJour(Grade grade) {
		Grade dbGrade = em.find(Grade.class, grade.getId());

		dbGrade.setCode(grade.getCode());
		dbGrade.setNbHeuresBase(grade.getNbHeuresBase());
		dbGrade.setTauxBase(grade.getTauxBase());
	}

	@Transactional
	@Override
	public void supprimer(Grade grade) {
		Grade dbGrade = em.find(Grade.class, grade.getId());

		em.remove(dbGrade);
	}

	@Override
	public List<Grade> lister() {
		TypedQuery<Grade> query = em.createQuery("select g from Grade g", Grade.class);
		return query.getResultList();
	}

}
