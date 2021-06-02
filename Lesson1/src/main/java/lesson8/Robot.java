package lesson8;

public class Robot implements Jumping{

    private String name;
    private final String TYPE = "Robot";
    private int maxJump = 50;
    private int maxRun = 100;

    public Robot(String name) {
        this.name = name;
    }

    public Robot(String name, int maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    @Override
    public void jump() {
        System.out.printf("%s %s напряг свои поршни и преодолел высоту.\n", TYPE, this.name);
    }

    @Override
    public void run() {
        System.out.printf("%s %s заскрипел заклепками и пробежал по дорожке.\n", TYPE, this.name);
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
