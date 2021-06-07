package lesson13;

public abstract class CheckWinner {


    public static String bestCar(Car[] cars) {
        String bestCar = cars[0].getName();
        for (int i = 1; i < cars.length; i++) {
            long x = cars[0].getTimeFinish();
            if (cars[i].getTimeFinish() < x){
                x = cars[i].getTimeFinish();
                bestCar = cars[i].getName();
            }
        }
        return bestCar;
    }
}
