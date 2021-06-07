package lesson11;

public abstract class Fruit {
    protected String typeFruit;
    protected double weight;

    public Fruit(String typeFruit) {
        this.typeFruit = typeFruit;
    }

    public double getWeight() {
        return this.weight;
    }
}
