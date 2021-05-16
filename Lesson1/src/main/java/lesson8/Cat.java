package lesson8;

public class Cat implements Jumping{

    private String name;
    private final String TYPE = "Cat";
    private int maxJump = 6;
    private int maxRun = 70;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public void jump() {
        System.out.printf("%s %s подняд хвост и преодолел высоту.\n", TYPE, this.name);
    }

    @Override
    public void run() {
        System.out.printf("%s %s встопорщил усы и пробежал по дорожке.\n", TYPE, this.name);
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
