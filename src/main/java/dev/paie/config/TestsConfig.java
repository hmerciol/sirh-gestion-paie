package dev.paie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({ServicesConfig.class})
@ImportResource("jdd-config.xml")
public class TestsConfig {

}
