package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.TestsConfig;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;

@ContextConfiguration(classes = { TestsConfig.class })
@RunWith(SpringRunner.class)
public class BulletinSalaireValidatorTest {

	@Autowired
	private BulletinSalaire bulletin;
	
	@Autowired
	private BulletinSalaireValidator bulSalValid;
	
	@Test
	public void test_valider() {
		Periode periode = bulletin.getPeriode();
		bulletin.setPeriode(null);
		assertThat(bulSalValid.valider(bulletin)).isFalse();
		bulletin.setPeriode(periode);
		
		BigDecimal prime = bulletin.getPrimeExceptionnelle();
		bulletin.setPrimeExceptionnelle(null);
		assertThat(bulSalValid.valider(bulletin)).isFalse();
		bulletin.setPrimeExceptionnelle(prime);

		RemunerationEmploye employe = bulletin.getRemunerationEmploye();
		bulletin.setRemunerationEmploye(null);
		assertThat(bulSalValid.valider(bulletin)).isFalse();
		bulletin.setRemunerationEmploye(employe);
	}

}
