package tests;

import config.AnotherConfig;
import config.ProjectConfig;
import main.Parrot;
import main.Chicken;
import main.Carrot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Supplier;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class, AnotherConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that a Parrot instance " +
            "with the attribute name having the value Koko " +
            "has been added to the Spring context.")
    public void testKokoIsInTheSpringContext() {
        Parrot p = context.getBean(Parrot.class);

        assertEquals("Koko", p.getName());
    }

    @Test
    @DisplayName("Test that the String 'hello' " +
            "has been added to the Spring context.")
    public void testHelloIsInTheSpringContext() {
        String s = context.getBean(String.class);

        assertEquals("Hello", s);
    }

    @Test
    @DisplayName("Test that the Integer 10 " +
            "has been added to the Spring context.")
    public void test10IsInTheSpringContext() {
        Integer i = context.getBean(Integer.class);

        assertEquals(10, i);
    }

    @Test
    @DisplayName("Test that Chicken is loadable " +
        "Via Component Scan")
    public void testChickenIsLoadable(){
        var chick = context.getBean(Chicken.class);
        chick.setName("cockedoodledoo!");
        assertEquals("cockedoodledoo!", chick.getName());
    }
}
