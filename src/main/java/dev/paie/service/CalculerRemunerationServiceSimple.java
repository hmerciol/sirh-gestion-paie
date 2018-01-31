package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Component
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration result = new ResultatCalculRemuneration();
		PaieUtils paieUtils = new PaieUtils();
		BigDecimal somme;

		// SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
		result.setSalaireDeBase(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye().getGrade()
				.getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase())));

		// SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
		result.setSalaireBrut(paieUtils
				.formaterBigDecimal(new BigDecimal(result.getSalaireDeBase()).add(bulletin.getPrimeExceptionnelle())));

		// TOTAL_RETENUE_SALARIALE =
		// SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		somme = new BigDecimal("0");
		for (Cotisation cotNonImp : bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables()) {
			BigDecimal tauxSalarial = cotNonImp.getTauxSalarial();
			if (tauxSalarial != null) {
				somme = somme.add(tauxSalarial.multiply(new BigDecimal(result.getSalaireBrut())));
			}
		}
		result.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(somme));


		// TOTAL_COTISATIONS_PATRONALES =
		// SOMME(COTISATION_NON_IMPOSABLE.TAUX_PATRONAL*SALAIRE_BRUT)
		somme = new BigDecimal("0");
		for (Cotisation cotNonImp : bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables()) {
			BigDecimal tauxPatronal = cotNonImp.getTauxPatronal();
			if (tauxPatronal != null) {
				somme = somme.add(tauxPatronal.multiply(new BigDecimal(result.getSalaireBrut())));
			}
		}
		result.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(somme));

		// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE
		result.setNetImposable(paieUtils.formaterBigDecimal(
				new BigDecimal(result.getSalaireBrut()).subtract(new BigDecimal(result.getTotalRetenueSalarial()))));

		// NET_A_PAYER = NET_IMPOSABLE -
		// SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		somme = new BigDecimal("0");
		for (Cotisation cotImp : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()) {
			somme = somme.add(cotImp.getTauxSalarial().multiply(new BigDecimal(result.getSalaireBrut())));
		}
		result.setNetAPayer(paieUtils.formaterBigDecimal(new BigDecimal(result.getNetImposable()).subtract(somme)));

		return result;
	}

}
