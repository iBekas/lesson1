package lesson12;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Threads {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            float[] arr = new float[SIZE];
            Arrays.fill(arr, 1);
            long a = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Таракан №1 прошел дистанцию за: " + (System.currentTimeMillis() - a));
        });

// Это я перемудрил, пока разбирался. Удалять жалко)
//        Thread t2 = new Thread(() -> {
//            float[] arr = new float[SIZE];
//            float[] a1 = new float[HALF];
//            float[] a2 = new float[HALF];
//            Arrays.fill(arr, 1);
//
//            long a = System.currentTimeMillis();
//            AtomicInteger x = new AtomicInteger(0);
//            final Object mon = new Object();
//            AtomicLong time2 = new AtomicLong();
//            AtomicLong time1 = new AtomicLong();
//
//            new Thread(() -> {
//                long b = System.currentTimeMillis();
//                synchronized (mon) {
//                    try {
//                        while (x.get() != 0) {
//                            mon.wait();
//                        }
//                        System.arraycopy(arr, 0, a1, 0, HALF);
//                        x.set(1);
//                        mon.notifyAll();
//
//                        for (int i = 0; i < HALF; i++) {
//                            a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                        }
//
//                        while (x.get() != 0) {
//                            mon.wait();
//                        }
//                        System.arraycopy(a1, 0, arr, 0, HALF);
//                        x.set(1);
//                        System.out.println(arr[3]);
//                        mon.notifyAll();
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//               time1.set(System.currentTimeMillis() - b);
//            }).start();
//
//            new Thread(() -> {
//                long c = System.currentTimeMillis();
//                synchronized (mon) {
//                    try {
//                        while (x.get() != 1) {
//                            mon.wait();
//                        }
//                        System.arraycopy(arr, 0, a2, 0, HALF);
//                        x.set(0);
//                        mon.notifyAll();
//
//                        for (int i = 0; i < HALF; i++) {
//                            a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                        }
//
//                        while (x.get() != 1) {
//                            mon.wait();
//                        }
//                        System.arraycopy(a2, 0, arr, HALF, HALF);
//                        x.set(0);
//                        System.out.println(arr[5_000_012]);
//                        mon.notifyAll();
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                time2.set(System.currentTimeMillis() - c);
//                System.out.println(time2);
//            }).start();
//
//            System.out.println(arr[3]);
//            System.out.println(arr[5_000_012]);
//
//            System.out.println("Таракан №2 прошел дистанцию за: " + (System.currentTimeMillis() - a));
//        });


        Thread t2 = new Thread(() -> {
            float[] arr = new float[SIZE];
            float[] a1 = new float[HALF];
            float[] a2 = new float[HALF];
            Arrays.fill(arr, 1);

//Чтобы вывелось нормально время расчета, сработал только этот вариант. Но есть ощущение, что я где-то накосячил, расчеты в потоке t1 и t2 отличаются. И скорость увеличилась на 46%, подозрительно.
//Не стал использовать синхронизацию и соответственно wait/notify в этом варианте, так как потоки вроде как читают и записывают в разные места и конфликтов не должно быть. Надеюсь моя логика верна.

            FutureTask<Long> fT1 = new FutureTask<>(() -> {
                long a = System.currentTimeMillis();
                System.arraycopy(arr, 0, a1, 0, HALF);
                for (int i = 0; i < HALF; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a1, 0, arr, 0, HALF);
                return System.currentTimeMillis() - a;
            });

            FutureTask<Long> fT2 = new FutureTask<>(() -> {
                long a = System.currentTimeMillis();
                System.arraycopy(arr, 0, a2, 0, HALF);
                for (int i = 0; i < HALF; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a2, 0, arr, HALF, HALF);
                return System.currentTimeMillis() - a;
            });

            new Thread(fT1).start();
            new Thread(fT2).start();

//            Вопрос: почему он выводит 1.0, если я использую принт в этом месте? Потоки то уже завершили склейку по идее.
//            System.out.println(arr[3]);
//            System.out.println(arr[5_000_012]);

            try {
                System.out.println("Таракан №2 прошел дистанцию за: " + (fT1.get() + fT2.get()));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(arr[3]);
            System.out.println(arr[5_000_012]);
        });

        System.out.println("На старт, внимание, марш!!!");
        t1.start();
        t2.start();



    }
}
