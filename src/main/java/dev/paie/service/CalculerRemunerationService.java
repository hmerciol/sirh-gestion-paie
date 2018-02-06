package dev.paie.service;

import java.util.Map;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

public interface CalculerRemunerationService {
	
	/**
	 * Calcule les différents champs d'un bulletin de salaire.
	 * @param bulletin Le bulletin de salaire.
	 * @return Les résultats du calcul.
	 */
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);

	/**
	 * Associer les bulletins de salaire à leur calcul.
	 * @return La liste des bulletins et leur résultat.
	 */
	Map<BulletinSalaire, ResultatCalculRemuneration> mapCalculer(); 
}
