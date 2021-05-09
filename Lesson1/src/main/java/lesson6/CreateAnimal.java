package lesson6;

public class CreateAnimal {
    public static void main(String[] args) {

        Animal[] zoo = {
           new Cat("Бегемот"),
           new Dog("Бальтазар"),
           new Cat("Леопольд"),
           new Dog("Вольт"),
        };

        runningAnimals(zoo, -90);
        swimmingAnimals(zoo, 11);
        amountAnimal(zoo);
        amountAnimal_2();
        amountAnimal_3(zoo);
    }

    private static void runningAnimals(Animal[] arr, int distance){
        for (Animal i: arr) i.run(distance);
    }

    private static void swimmingAnimals(Animal[] arr, int distance){
        for (Animal i: arr) i.swim(distance);
    }

    private static void amountAnimal(Animal[] arr) { //классическая реализация
        int counterCat = 0;
        int counterDog = 0;
        int sum;
        for (Animal i: arr) {
            if (i instanceof Cat) counterCat++;
            if (i instanceof Dog) counterDog++;
        }
        sum = counterCat + counterDog;
        System.out.printf("В нашем зоопарке: котов - %dшт. , псов - %dшт..\nИтого - %d животных.\n",counterCat, counterDog, sum);
    }

    private static void amountAnimal_2(){ //реализация через счетчик в классах
        int counterCat = Cat.amountCat();
        int counterDog = Dog.amountDog();
        int allAnimals = Animal.amountAnimal();
        System.out.printf("В нашем зоопарке: котов - %dшт. , псов - %dшт..\nИтого - %d животных.\n",counterCat, counterDog, allAnimals);
    }

    private static void amountAnimal_3(Animal[] arr) { // еще одна реализация через методы в классах, но второй вариант мне нравится больше
        int counterDog = Dog.amountDog2(arr);
        int counterCat = Cat.amountCat2(arr);
        int allAnimals = Animal.amountAnimal2(arr); // или просто сумма верхних
        System.out.printf("В нашем зоопарке: котов - %dшт. , псов - %dшт..\nИтого - %d животных.\n",counterCat, counterDog, allAnimals);
    }

}
