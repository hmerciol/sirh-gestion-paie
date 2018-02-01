package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder une nouvelle cotisation
		Cotisation cotisation = new Cotisation();
		cotisation.setId(1);
		cotisation.setCode("COT01");
		cotisation.setLibelle("cotisation test");
		cotisation.setTauxPatronal(new BigDecimal("0.012030"));
		cotisation.setTauxSalarial(new BigDecimal("0.009612"));
		cotisationService.sauvegarder(cotisation);

		// vérifier qu'il est possible de récupérer la nouvelle cotisation via la
		// méthode lister
		assertThat(cotisationService.lister()).filteredOn(cot -> cot.getId().equals(1)).first()
				.isEqualToComparingFieldByField(cotisation);

		// modifier une cotisation
		cotisation.setTauxSalarial(new BigDecimal("0.021003"));
		cotisationService.mettreAJour(cotisation);

		// vérifier que les modifications sont bien prises en compte via la méthode
		// lister
		assertThat(cotisationService.lister()).filteredOn(cot -> cot.getId().equals(1))
				.extracting(cot -> cot.getTauxSalarial()).contains(new BigDecimal("0.021003"));

		cotisationService.supprimer(cotisation);
	}
}
