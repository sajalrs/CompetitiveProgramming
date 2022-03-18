package CrackingTheCodingInterview.AnimalShelter;

import java.util.LinkedList;

public class AnimalShelter implements AnimalShelterQueue {
    private LinkedList<Animal> list;

    AnimalShelter() {
        list = new LinkedList<>();
    }

    @Override
    public void enqueue(Animal animal) {
        list.addFirst(animal);
    }

    @Override
    public Animal dequeueAny() {
        return list.removeLast();
    }

    @Override
    public Dog dequeueDog() {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) instanceof Dog) return (Dog) list.remove(i);
        }
        return null;
    }

    @Override
    public Cat dequeueCat() {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) instanceof Cat) return (Cat) list.remove(i);
        }
        return null;
    }
}
