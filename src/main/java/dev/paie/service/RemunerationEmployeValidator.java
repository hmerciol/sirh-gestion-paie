package dev.paie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Element;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class RemunerationEmployeValidator implements ElementValidator {

	@Autowired
	RemunerationEmployeRepository remEmplRepo;
	@Autowired
	EntrepriseRepository entRepo;
	@Autowired
	ProfilRemunerationRepository profRepo;
	@Autowired
	GradeRepository graRepo;

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
			if (employe.getEntreprise() == null || entRepo.findOne(employe.getEntreprise().getId()) == null) {
				return false;
			}

			// le profil doit exister
			if (employe.getProfilRemuneration() == null || profRepo.findOne(employe.getProfilRemuneration().getId()) == null) {
				return false;
			}

			// le grade doit exister
			return (employe.getGrade() != null && graRepo.findOne(employe.getGrade().getId()) != null);
		}
		// pas un bulletin
		return false;
	}

}
