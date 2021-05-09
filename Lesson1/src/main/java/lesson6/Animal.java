package lesson6;

public abstract class Animal {

    static int amountAnimal = 0;

    protected String name;
    protected String type;

    public Animal(String type) {
        this.type = type;
    }

    public void run (int distance) {
        System.out.printf("%s %s пробежал %d метров.\n", this.type, this.name, distance);
    }

    public void swim (int distance) {
        System.out.printf("%s %s проплыл %d метров.\n", this.type, this.name, distance);
    }

    static int amountAnimal() {return amountAnimal;}

    static int amountAnimal2(Animal[] arr) {
        int counter = 0;
        for (Animal i: arr) {
            if (i instanceof Animal) counter++;
        }
        return counter;
    }
}
