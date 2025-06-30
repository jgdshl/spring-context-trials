package main;
import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AnotherConfig;
import config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var context = 
            new AnnotationConfigApplicationContext(ProjectConfig.class, AnotherConfig.class);

            beanBasics(context);
            wiringExample(context);
   }

    static void beanBasics(AnnotationConfigApplicationContext context) {
        System.out.println("*** Bean Basics ***");

        // Register the default bean
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.sing());

        // Register a bean using its name
        var parrot2 = context.getBean("parry", Parrot.class);
        parrot2.setName("Chirp");
        System.out.println(parrot2.sing());

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

    static void wiringExample(AnnotationConfigApplicationContext context) {
        System.out.println("*** Wiring Examples ***");

        var person = context.getBean(Person.class);
        System.out.println("Person Bean's name : " + person.getName());

        var parrot = context.getBean(Parrot.class);
        System.out.println("Parrot Bean's name : " + parrot.getName());

        System.out.println("Person bean's parrot's name : " + person.getParrot().getName());

        System.out.println("Person's chicken's name : " + person.getChicken().getName());

    }
}