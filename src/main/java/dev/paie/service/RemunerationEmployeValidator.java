package dev.paie.service;

import org.springframework.stereotype.Service;

import dev.paie.entite.Element;
import dev.paie.entite.RemunerationEmploye;

@Service
public class RemunerationEmployeValidator implements ElementValidator {

	@Override
	public boolean valider(Element element) {
		if(element instanceof RemunerationEmploye) {
			RemunerationEmploye employe = (RemunerationEmploye) element;
			
			// le matricule doit être assignée
			if(employe.getMatricule() == null || employe.getMatricule().equals("")) {
				return false;
			}
			
			// l'entreprise doit exister
			if(employe.getEntreprise() == null) {
				return false;
			}
			
			// le profil doit exister
			if(employe.getProfilRemuneration() == null) {
				return false;
			}
			
			// le grade doit exister
			if(employe.getGrade() == null) {
				return false;
			}
			
			return true;
		}
		// pas un bulletin
		return false;
	}

}
