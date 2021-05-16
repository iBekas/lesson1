package lesson8;

public class Treadmill implements Marker {

    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public boolean action (Jumping person) {
        if (person == null) return false;
        else if (this.length <= person.getMaxRun()) {
            person.run();
            return true;
        } else {
            System.out.println(person.toString() + " не справился.");
            return false;
        }
    }
}
