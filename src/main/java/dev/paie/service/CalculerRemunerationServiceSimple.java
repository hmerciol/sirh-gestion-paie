package dev.paie.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private ResultatCalculRemuneration result;

	@Autowired
	private PaieUtils paieUtils;
	
	@Autowired
	private BulletinSalaireRepository bulletinRepo;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		// SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
		result.setSalaireDeBase(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye().getGrade()
				.getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase())));

		// SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
		result.setSalaireBrut(paieUtils
				.formaterBigDecimal(new BigDecimal(result.getSalaireDeBase()).add(bulletin.getPrimeExceptionnelle())));

		// TOTAL_RETENUE_SALARIALE =
		// SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		result.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye()
				.getProfilRemuneration().getCotisationsNonImposables().stream().map(Cotisation::getTauxSalarial)
				.filter(Objects::nonNull).map(taux -> taux.multiply(new BigDecimal(result.getSalaireBrut())))
				.reduce((t1, t2) -> t1.add(t2)).orElse(new BigDecimal("0"))));

		// TOTAL_COTISATIONS_PATRONALES =
		// SOMME(COTISATION_NON_IMPOSABLE.TAUX_PATRONAL*SALAIRE_BRUT)
		result.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye()
				.getProfilRemuneration().getCotisationsNonImposables().stream().map(Cotisation::getTauxPatronal)
				.filter(Objects::nonNull).map(taux -> taux.multiply(new BigDecimal(result.getSalaireBrut())))
				.reduce((t1, t2) -> t1.add(t2)).orElse(new BigDecimal("0"))));

		// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE
		result.setNetImposable(paieUtils.formaterBigDecimal(
				new BigDecimal(result.getSalaireBrut()).subtract(new BigDecimal(result.getTotalRetenueSalarial()))));

		// NET_A_PAYER = NET_IMPOSABLE -
		// SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		result.setNetAPayer(paieUtils.formaterBigDecimal(new BigDecimal(result.getNetImposable())
				.subtract(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
						.map(Cotisation::getTauxSalarial).filter(Objects::nonNull)
						.map(taux -> taux.multiply(new BigDecimal(result.getSalaireBrut())))
						.reduce((t1, t2) -> t1.add(t2)).orElse(new BigDecimal("0")))));

		return result;
	}
	
	@Override
	@Transactional
	public Map<BulletinSalaire, ResultatCalculRemuneration> mapCalculer() {
		Map<BulletinSalaire, ResultatCalculRemuneration> mapBulletinsResults = new HashMap<>();
		for(BulletinSalaire bulletin : bulletinRepo.findAll()) {
			mapBulletinsResults.put(bulletin, calculer(bulletin));
		}
		return mapBulletinsResults;
	}

}
