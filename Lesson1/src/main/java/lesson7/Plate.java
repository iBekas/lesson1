package lesson7;

public class Plate {

     private int food;
     private int maxFood;
     private final int MIN_FOOD = 0;

    public Plate(int food, int maxFood) {
        this.food = food;
        this.maxFood = maxFood;
    }

    public boolean plusFood (int feed) {
        if(this.food > maxFood) {
            System.out.println("Тарелка не резиновая, больше 100кг. не лезет!");
            return false;
        } else {
            this.food += feed;
            return  true;
        }
    }

    public boolean minusFood (int feed) {
        if(this.food < MIN_FOOD) {
            System.out.println("В тарелке нет такого количетсва еды. Ну вы и жрете!");
            return false;
        } else {
            this.food -= feed;
            return true;
        }
    }


    public int getFood() {
        return food;
    }

    public int getMaxFood() {
        return maxFood;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
