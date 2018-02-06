package dev.paie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Element;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class RemunerationEmployeValidator implements ElementValidator {

	@Autowired
	RemunerationEmployeRepository remEmplRepo;

	@Override
	public boolean valider(Element element) {
		if (element instanceof RemunerationEmploye) {
			RemunerationEmploye employe = (RemunerationEmploye) element;

			// le matricule doit être assignée, conforme et pas déjà pris
			if (employe.getMatricule() == null || !employe.getMatricule().matches("[A-Z][0-9]+") || !remEmplRepo
					.findAll().stream().noneMatch(em -> em.getMatricule().equals(employe.getMatricule()))) {
				return false;
			}

			// l'entreprise doit exister
			if (employe.getEntreprise() == null) {
				return false;
			}

			// le profil doit exister
			if (employe.getProfilRemuneration() == null) {
				return false;
			}

			// le grade doit exister
			return (employe.getGrade() == null);
		}
		// pas un bulletin
		return false;
	}

}
