package lesson13;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class RaceThreads {

    public static final int CARS_COUNT = 4;
    public static CyclicBarrier readyCheck = new CyclicBarrier(CARS_COUNT+1);
    public static CyclicBarrier finishCheck = new CyclicBarrier(CARS_COUNT+1);
    public static Semaphore tunnel = new Semaphore(2);


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }


        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        readyCheck.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        finishCheck.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("Победитель - " + CheckWinner.bestCar(cars) + "!");

//        for (int i = 0; i < cars.length; i++) {
//            System.out.println(cars[i].getTimeFinish());
//        }


    }
}

