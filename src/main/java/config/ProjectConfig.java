package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import main.Parrot;

@Configuration
// @ComponentScan(basePackages = "main")
public class ProjectConfig {

    @Bean(name = "parry")
    Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Primary
    Parrot defaultParrot() {
        Parrot p = new Parrot();
        p.setName("Prima parry");
        return p;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
    
}
