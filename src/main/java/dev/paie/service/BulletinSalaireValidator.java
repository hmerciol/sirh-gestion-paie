package dev.paie.service;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Element;

@Service
public class BulletinSalaireValidator implements ElementValidator {

	@Override
	public boolean valider(Element element) {
		if (element instanceof BulletinSalaire) {
			BulletinSalaire bulletin = (BulletinSalaire) element;

			// une prime nulle doit être assignée à 0
			if (bulletin.getPrimeExceptionnelle() == null) {
				return false;
			}

			// la rémunération employé doit exister
			if (bulletin.getRemunerationEmploye() == null) {
				return false;
			}

			// la période doit exister
			return (bulletin.getPeriode() != null);
		}
		// pas un bulletin
		return false;
	}

}
