import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimal_InstantiatesCorrectly_true() {
        EndangeredAnimal testAnimalEndangered = new EndangeredAnimal("Rhino");
        assertTrue(testAnimalEndangered instanceof EndangeredAnimal);

    }

    @Test
    public void getName_EndangeredAnimalInstantiatesWithName_Rhino() {
        EndangeredAnimal testAnimalEndangered = new EndangeredAnimal("Rhino");
        assertEquals("Rhino", testAnimalEndangered.getName());

    }

    @Test
    public void equalsReturnsTrueIfNameIsSame_true() {
        EndangeredAnimal testAnimalEndangered = new EndangeredAnimal("Rhino");
        EndangeredAnimal otherAnimalEndangered = new EndangeredAnimal("Rhino");
        assertTrue(testAnimalEndangered.equals(otherAnimalEndangered));

    }

    @Test
    public void save_returnsTrueIfDescriptionsAreSame_true() {
        EndangeredAnimal testAnimalEndangered = new EndangeredAnimal("Rhino");
        testAnimalEndangered.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testAnimalEndangered));
    }

    @Test
    public void save_assignsIdToEndangeredAnimals() {
        EndangeredAnimal testAnimalEndangered = new EndangeredAnimal("Rhino");
        testAnimalEndangered.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(), testAnimalEndangered.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimals_() {
        EndangeredAnimal testAnimalEndangered = new EndangeredAnimal("Rhino");
        EndangeredAnimal otherAnimalEndangered = new EndangeredAnimal("Elephant");
        testAnimalEndangered.save();
        otherAnimalEndangered.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testAnimalEndangered));
        assertTrue(EndangeredAnimal.all().get(1).equals(otherAnimalEndangered));
    }
}