package CrackingTheCodingInterview;

public interface AnimalShelterQueue {
    void enqueue(AnimalShelter.Animal animal);

    AnimalShelter.Animal dequeueAny();

    AnimalShelter.Dog dequeueDog();

    AnimalShelter.Cat dequeueCat();
}
