package dev.paie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Element;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class BulletinSalaireValidator implements ElementValidator {

	@Autowired
	RemunerationEmployeRepository remEmplRepo;
	@Autowired
	PeriodeRepository perRepo;

	@Override
	public boolean valider(Element element) {
		if (element instanceof BulletinSalaire) {
			BulletinSalaire bulletin = (BulletinSalaire) element;

			// la prime doit assignée
			if (bulletin.getPrimeExceptionnelle() == null) {
				return false;
			}

			// la rémunération employé doit exister
			if (bulletin.getRemunerationEmploye() == null || remEmplRepo.findAll().stream()
					.noneMatch(em -> em.getMatricule().equals(bulletin.getRemunerationEmploye().getMatricule()))) {
				return false;
			}

			// la période doit exister
			return (bulletin.getPeriode() != null && !perRepo.findAll().stream()
					.noneMatch(pe -> pe.getLabel().equals(bulletin.getPeriode().getLabel())));
		}
		// pas un bulletin
		return false;
	}

}
