package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dev.paie.entite.Grade;
import dev.paie.service.GradeServiceJdbcTemplate;

@Configuration
@Import({ Grade.class, GradeServiceJdbcTemplate.class })
public class DataSourceMySQLConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://bbgr5gpls-mysql.services.clever-cloud.com:3306/bbgr5gpls");
		dataSource.setUsername("u4as4uumsqlseqkn");
		dataSource.setPassword("XV8OwUCrFcfhtPhOASP");
		return dataSource;
	}

}
