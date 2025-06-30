package main;
import org.springframework.stereotype.Component;

@Component
public class Chicken {
    String name;

    public void setName(String string) {
        this.name = string;
    }

    public String sing() {
        return this.name + "says cockedoodledooo!";
    }

    public String getName() {
        return name;
    }
}
