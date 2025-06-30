package main;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
    private Parrot parrot;
    private String name;

    // @Autowired // usually done only in proof of concepts. Realistically, used in constructors. 
    //  Not preferred to autowire here, because final cannot be used without initial value
    private final Chicken chicken;

    @Autowired
    public Person(Chicken chicken) {
        this.chicken = chicken;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public Chicken getChicken() {
        return chicken;
    }

    // Setters
    public void setParrot(Parrot p) {
        parrot = p;
    }

    public void setName(String name) {
        this.name = name;
    }
}
