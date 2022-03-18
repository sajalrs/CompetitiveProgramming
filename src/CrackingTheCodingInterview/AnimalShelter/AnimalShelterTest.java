package CrackingTheCodingInterview.AnimalShelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalShelterTest {
    AnimalShelterQueue animalShelter;
    @BeforeEach
    public void setup(){
        animalShelter = new AnimalShelter();
    }

    @Test
    public void test1(){
        AnimalShelter animals = new AnimalShelter();
        animals.enqueue(new Cat());
        Animal dog = new Dog();
        animals.enqueue(dog);
        animals.enqueue(new Cat());
        animals.enqueue(new Cat());
        animals.enqueue(new Dog());
        assertEquals(dog,animals.dequeueDog());
    }

    @Test
    public void test2(){
        AnimalShelter animals = new AnimalShelter();
        Animal cat = new Cat();
        animals.enqueue(cat);
        Animal dog = new Dog();
        animals.enqueue(dog);
        animals.enqueue(new Cat());
        animals.enqueue(new Cat());
        animals.enqueue(new Dog());
        assertEquals(cat,animals.dequeueAny());
    }


    @Test
    public void test3(){
        AnimalShelter animals = new AnimalShelter();
        Animal cat = new Cat();
        animals.enqueue(cat);
        Animal dog = new Dog();
        animals.enqueue(dog);
        animals.enqueue(new Cat());
        animals.enqueue(new Cat());
        animals.enqueue(new Dog());
        assertEquals(cat,animals.dequeueCat());
    }
}
