package main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AnotherConfig;
import config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var context = 
            new AnnotationConfigApplicationContext(ProjectConfig.class, AnotherConfig.class);
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.sing());

        var parrot2 = context.getBean("parry", Parrot.class);
        parrot2.setName("Chirp");
        System.out.println(parrot2.sing());
        System.out.println(parrot.sing());

        var chicken = context.getBean(Chicken.class);
        chicken.setName("bukbuk");
        System.out.println(chicken.sing());
    }
}