package lesson6;

public class Cat extends Animal {

    static int amountCat = 0;

    public Cat(String name) {
        super("Кот");
        this.name = name;
        amountCat++;
        amountAnimal++;
    }

    @Override
    public void run(int distance) {
        if (distance > 200) System.out.printf("%s %s пробежал %d метров и умер.\n", this.type, this.name, distance);
        else if (distance < 0) System.out.printf("%s %s не умеет бегать задом на перед.\n", this.type, this.name);
        else super.run(distance);
    }

    @Override
    public void swim(int distance) {
        if (distance >= 0) System.out.printf("%s %s запрыгнул в воду и пошел ко дну.\n", this.type, this.name);
        else if (distance < 0) System.out.printf("%s %s не понимает что ему делать.\n", this.type, this.name);
        else super.swim(distance);
    }

    static int amountCat() {return amountCat;}

    public static int amountCat2(Animal[] arr) {
        int counterCat = 0;
        for (Animal i: arr) {
            if (i instanceof Cat) counterCat++;
        }
        return counterCat;
    }
}
