package lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;
    private int halfSatiety = 0;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public boolean eat (Plate food){
        if (this.satiety == true) {
            System.out.printf("%s уже поел, больше не лезет!\n", this.name);
            return this.satiety;
        }
        if (food.minusFood(this.appetite - halfSatiety)) {
            halfSatiety = 0;
            System.out.printf("%s поел и довольный пошел ловить мышей!\n", this.name);
            return this.satiety = true;
        } else {
            halfSatiety = food.getFood();
            food.minusFood(halfSatiety);
            System.out.printf("%s съел %d еды, но он все еще голоден!\n", this.name, halfSatiety);
            return this.satiety;
        }
    }


    public int getAppetite() {
        return appetite;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    @Override
    public String toString() {
        if (this.satiety == true) return String.format("%s сытый и довольный!", this.name);
        else return String.format("%s голоден, скорее его накорми!\n", this.name);
    }


}

//halfSatiety = this.appetite - plate.getFood;