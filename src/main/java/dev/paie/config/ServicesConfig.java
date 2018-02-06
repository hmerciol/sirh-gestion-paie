package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import({JpaConfig.class, DataSourceMySQLConfig.class})
@ComponentScan({ "dev.paie.service", "dev.paie.util", "dev.paie.entite"}) //, "dev.paie.console" })
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {

}
