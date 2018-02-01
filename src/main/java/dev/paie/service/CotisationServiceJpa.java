package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Transactional
	@Override
	public void mettreAJour(Cotisation cotisation) {
		TypedQuery<Cotisation> query = em.createQuery("select c from Cotisation c where c.code=:code",
				Cotisation.class);
		query.setParameter("code", cotisation.getCode());
		Cotisation oldCotisation = query.getSingleResult();

		oldCotisation.setLibelle(cotisation.getLibelle());
		oldCotisation.setTauxPatronal(cotisation.getTauxPatronal());
		oldCotisation.setTauxSalarial(cotisation.getTauxSalarial());
	}

	@Override
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("select c from Cotisation c", Cotisation.class);
		List<Cotisation> result = query.getResultList();
		return result;
	}

}
