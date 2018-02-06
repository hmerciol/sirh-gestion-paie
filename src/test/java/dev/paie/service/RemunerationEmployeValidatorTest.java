package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.TestsConfig;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.RemunerationEmploye;

@ContextConfiguration(classes = { TestsConfig.class })
@RunWith(SpringRunner.class)
public class RemunerationEmployeValidatorTest {
	
	@Autowired
	private RemunerationEmploye employe;
	
	@Autowired
	private RemunerationEmployeValidator remEmplValid;
	
	@Test
	public void test_valider() {
		assertThat(remEmplValid.valider(employe)).isTrue();
		
		String matricule = employe.getMatricule();
		employe.setMatricule("");
		assertThat(remEmplValid.valider(employe)).isFalse();
		employe.setMatricule(matricule);
		
		Grade grade = employe.getGrade();
		employe.setGrade(null);
		assertThat(remEmplValid.valider(employe)).isFalse();
		employe.setGrade(grade);

		Entreprise entreprise = employe.getEntreprise();
		employe.setEntreprise(null);
		assertThat(remEmplValid.valider(employe)).isFalse();
		employe.setEntreprise(entreprise);
		
		employe.setProfilRemuneration(null);
		assertThat(remEmplValid.valider(employe)).isFalse();
	}

}
