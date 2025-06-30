package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import main.Chicken;
import main.Parrot;
import main.Person;

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
    @Bean
    Parrot defaultParrot() {
        Parrot p = new Parrot();
        p.setName("Prima parry");
        return p;
    }

    @Bean
    Person person(Parrot parrot, Chicken chicken) {
        var p = new Person(chicken);
        p.setName("Ella");
        p.setParrot(parrot);
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
