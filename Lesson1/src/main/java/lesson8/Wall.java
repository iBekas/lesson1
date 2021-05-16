package lesson8;

public class Wall implements Marker{

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public boolean action (Jumping person) {
        if (person == null) return false;
        if (this.height <= person.getMaxJump()) {
            person.jump();
            return true;
        } else {
            System.out.println(person.toString() + " не справился.");
            return false;
        }
    }


}
