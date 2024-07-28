package Queue;

import java.util.ArrayList;

public class QueueAnimal {
    // Animals are stored in an ArrayList, but the behaviour is that of a Queue
    ArrayList<Animal> animalQueue;

    public QueueAnimal() {
        animalQueue = new ArrayList<Animal>();
    }

    public boolean isEmpty() {
        return animalQueue.isEmpty();
    }

    public void enqueue(Animal newAnimal) {
        animalQueue.add(newAnimal);
    }

    // This one is simple - just take the animal at the front of the queue
    public Animal dequeueAny() {
        Animal firstAnimal = animalQueue.removeFirst();;
        System.out.println("Retrieved " + firstAnimal);
        return firstAnimal;
    }

    // This one is not simple
    public Animal dequeueCat() {
        // Make a queue of all dogs that were passed over
        ArrayList<Animal> dogs = new ArrayList<>();

        // Start taking animals from the front of the queue
        // Dogs are added to the 'skipped dogs' queue
        Animal retrieved = null;
        while (!animalQueue.isEmpty()) {
            Animal nextAnimal = animalQueue.removeFirst();
            if (nextAnimal.isCat()) {
                retrieved = nextAnimal;
                System.out.println("Retrieved " + nextAnimal);
                break;
            } else {
                dogs.add(nextAnimal);
            }
        }

        // Add the skipped dogs back into the animal queue
        if (!dogs.isEmpty())
            animalQueue.addAll(dogs);

        return retrieved;
    }

    // This is dequeueCat with slight changes
    public Animal dequeueDog() {
        ArrayList<Animal> cats = new ArrayList<>();

        Animal retrieved = null;
        while (!animalQueue.isEmpty()) {
            Animal nextAnimal = animalQueue.removeFirst();
            if (!nextAnimal.isCat()) {
                retrieved = nextAnimal;
                System.out.println("Retrieved " + nextAnimal);
                break;
            } else {
                cats.add(nextAnimal);
            }
        }

        // Add the skipped dogs back into the animal queue
        if (!cats.isEmpty())
            animalQueue.addAll(cats);

        return retrieved;
    }
}
