package lesson7;

public class CatHouse {
    public static void main(String[] args) {

        Cat[] cats = {
             new Cat("Барбарис", 10),
             new Cat("Жорик", 15),
             new Cat("Геннадий", 3),
             new Cat("Карабас-Обжирас", 99),
        };

        Plate plate = new Plate(100, 300);

        cats[0].eat(plate);





    }
}
