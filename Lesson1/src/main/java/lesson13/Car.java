package lesson13;


import java.util.concurrent.BrokenBarrierException;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private long timeStart;
    private long timeFinish;



    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            RaceThreads.readyCheck.await();
            Thread.sleep(100); // если это еще тут, значит я не понял, почему один из потоков постоянно обгоняетя "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"
            this.timeStart = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        this.timeFinish = System.currentTimeMillis() - timeStart; //несколько раз проверить, ошибок не нашел. У кого первого вывело в консоль "закончил этап: Дорога 40 метров" тот и победитель.
        try {
            RaceThreads.finishCheck.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getTimeFinish() {
        return timeFinish;
    }


}
