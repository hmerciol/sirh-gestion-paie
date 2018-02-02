package dev.paie.repository;

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
public class CotisationRepositoryTest {

	@Autowired
	private CotisationRepository cotisationRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder une nouvelle cotisation
		Cotisation cotisation = new Cotisation();
		cotisation.setCode("COT01");
		cotisation.setLibelle("cotisation test");
		cotisation.setTauxPatronal(new BigDecimal("0.012030"));
		cotisation.setTauxSalarial(new BigDecimal("0.009612"));
		cotisationRepository.save(cotisation);

		// vérifier qu'il est possible de récupérer la nouvelle cotisation via la
		// méthode lister
		assertThat(cotisationRepository.findOne(cotisation.getId())).isEqualToComparingFieldByField(cotisation);

		// modifier une cotisation
		cotisation.setTauxSalarial(new BigDecimal("0.021003"));
		cotisationRepository.save(cotisation);

		// vérifier que les modifications sont bien prises en compte via la méthode
		// lister
		assertThat(cotisationRepository.findOne(cotisation.getId())).isEqualToComparingFieldByField(cotisation);
	}
}
