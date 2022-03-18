package CrackingTheCodingInterview.AnimalShelter;

public interface AnimalShelterQueue {
    void enqueue(Animal animal);

    Animal dequeueAny();

    Dog dequeueDog();

    Cat dequeueCat();
}
