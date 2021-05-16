package lesson8;

public class Human implements Jumping{

    private String name;
    private final String TYPE = "Human";
    private int maxJump = 3;
    private int maxRun = 42;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public void jump() {
        System.out.printf("%s %s напряг свои мышцы и преодолел высоту.\n", TYPE, this.name);
    }

    @Override
    public void run() {
        System.out.printf("%s %s надел счастливую майку и пробежал по дорожке.\n", TYPE, this.name);
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public String toString() {
        return String.format("%s %s",TYPE, this.name);
    }


}
