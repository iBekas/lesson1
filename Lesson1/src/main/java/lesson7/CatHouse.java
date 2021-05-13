package lesson7;

public class CatHouse {
    private static Plate plate = new Plate(80, 300);

    public static void main(String[] args) {

        Cat[] cats = {
             new Cat("Барбарис", 10),
             new Cat("Жорик", 15),
             new Cat("Геннадий", 3),
             new Cat("Карабас-Обжирас", 99),
        };


        System.out.println(plate.toString());

//        cats[0].eat(plate);
//        System.out.println(plate.toString());
//        System.out.println(cats[0].toString());

        catDinner(cats);
        plate.plusFood(200);
        catDinner(cats);
        System.out.println(plate.getFood());
    }

    private static void catDinner (Cat[] arr){
        for (Cat cat : arr) {
           cat.eat(plate);
           System.out.println(cat.toString());
        }

    }


}
