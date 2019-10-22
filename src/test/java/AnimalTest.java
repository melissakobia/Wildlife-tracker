import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AnimalTest {
//    @Rule
//    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animalInstantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Lion");
        assertTrue(testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_Lion() {
        Animal testAnimal = new Animal("Lion");
        assertEquals("Lion", testAnimal.getName());
    }


}