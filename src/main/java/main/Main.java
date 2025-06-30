package main;
import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AnotherConfig;
import config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var context = 
            new AnnotationConfigApplicationContext(ProjectConfig.class, AnotherConfig.class);

        // Register the default bean
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.sing());

        // Register a bean using it's name
        var parrot2 = context.getBean("parry", Parrot.class);
        parrot2.setName("Chirp");
        System.out.println(parrot2.sing());
        System.out.println(parrot.sing());

        // Register a bean dynamically
        Parrot p = new Parrot();
        p.setName("Kewkew");
        Supplier<Parrot> parrotSupplier = () -> p;

        context.registerBean(
            "dynamicParrot",
            Parrot.class,
            parrotSupplier);

        var parrot3 = context.getBean("dynamicParrot", Parrot.class);
        System.out.println(parrot3.sing());
            
        // Register a bean defined using stereotype
        var chicken = context.getBean(Chicken.class);
        chicken.setName("bukbuk");
        System.out.println(chicken.sing());
    }
}