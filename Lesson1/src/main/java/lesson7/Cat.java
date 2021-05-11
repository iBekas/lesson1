package lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public boolean eat (Plate food){
        if (food.minusFood(this.appetite)) {
            System.out.printf("%s поле и довольный пошел ловить мышей!\n", this.name);
            return this.satiety = true;
        } else {
            System.out.printf("%s отказывается смотреть на эти жалкие крохи!\n", this.name);
            return this.satiety;
        }
    }


    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", satiety=" + satiety +
                '}';
    }


}
