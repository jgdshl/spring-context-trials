package main;

public class Parrot {
    private String name;

    public String sing() {
        return name + " " + "sings";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
