package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Import({ JpaConfig.class, DataSourceMySQLConfig.class, SecurityConfig.class })
@ComponentScan({ "dev.paie.service", "dev.paie.util", "dev.paie.entite" })
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
