package dev.paie.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class GradeRepositoryTest {

	@Autowired
	private GradeRepository gradeRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder un nouveau grade
		Grade grade = new Grade();
		grade.setCode("GR01");
		grade.setNbHeuresBase(new BigDecimal("149.68"));
		grade.setTauxBase(new BigDecimal("11.086200"));
		gradeRepository.save(grade);

		// vérifier qu'il est possible de récupérer le nouveau grade via la méthode
		// lister
		assertThat(gradeRepository.findOne(grade.getId())).isEqualToComparingFieldByField(grade);

		// modifier un grade
		grade.setNbHeuresBase(new BigDecimal("150.23"));
		gradeRepository.save(grade);

		// vérifier que les modifications sont bien prises en compte via la méthode
		// lister
		assertThat(gradeRepository.findOne(grade.getId())).isEqualToComparingFieldByField(grade);
	}
}
