package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder un nouveau grade
		Grade grade = new Grade();
		grade.setCode("GR01");
		grade.setNbHeuresBase(new BigDecimal("149.68"));
		grade.setTauxBase(new BigDecimal("11.0862"));
		gradeService.sauvegarder(grade);

		// vérifier qu'il est possible de récupérer le nouveau grade via la méthode
		// lister
		assertThat(gradeService.lister()).filteredOn(gr -> gr.getId().equals(grade.getId())).first()
				.isEqualToComparingFieldByField(grade);

		// modifier un grade
		grade.setNbHeuresBase(new BigDecimal("150.23"));
		gradeService.mettreAJour(grade);

		// vérifier que les modifications sont bien prises en compte via la méthode
		// lister
		assertThat(gradeService.lister()).filteredOn(gr -> gr.getId().equals(grade.getId()))
				.extracting(gr -> gr.getNbHeuresBase()).contains(new BigDecimal("150.23"));
		
		gradeService.supprimer(grade);
	}
}
