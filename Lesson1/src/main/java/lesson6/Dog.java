package lesson6;

public class Dog extends Animal{

    static int amountDog = 0;

    public Dog(String name) {
        super("Пёс");
        this.name = name;
        amountDog++;
        amountAnimal++;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) System.out.printf("%s %s пробежал %d метров и умер.\n", this.type, this.name, distance);
        else if (distance < 0) System.out.printf("%s %s не умеет бегать задом на перед.\n", this.type, this.name);
        else super.run(distance);
    }

    @Override
    public void swim(int distance) {
        int maxDistance = 10;
        if (distance > maxDistance) System.out.printf("%s %s проплыл %d метров и пошел ко дну.\n", this.type, this.name, maxDistance);
        else if (distance < 0) System.out.printf("%s %s не понимает что ему делать.\n", this.type, this.name);
        else super.swim(distance);
    }

    static int amountDog() {return amountDog;}

    public static int amountDog2(Animal[] arr) {
        int amountDog2 = 0;
        for (Animal i: arr) {
            if (i instanceof Cat) amountDog2++;
        }
        return amountDog2;
    }

}
