package dev.paie.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder un nouvel avantage
		Avantage avantage = new Avantage();
		avantage.setCode("av01");
		avantage.setMontant(new BigDecimal("100.00"));
		avantage.setNom("petite prime");
		avantageRepository.save(avantage);

		// vérifier qu'il est possible de récupérer le nouvel avantage via la
		// méthode findOne
		assertThat(avantageRepository.findOne(avantage.getId())).isEqualToComparingFieldByField(avantage);

		// modifier un avantage
		avantage.setMontant(new BigDecimal("200.00"));
		avantageRepository.save(avantage);

		// vérifier que les modifications sont bien prises en compte via la méthode
		// findOne
		assertThat(avantageRepository.findOne(avantage.getId())).isEqualToComparingFieldByField(avantage);
	}
}
