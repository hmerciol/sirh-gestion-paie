package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import dev.paie.util.PaieUtils;

@Configuration
@ComponentScan("dev.paie.service")
@ComponentScan("dev.paie.entite")
@Import({PaieUtils.class})
@ImportResource("classpath:jdd-config.xml")
public class ServicesConfig {

}
