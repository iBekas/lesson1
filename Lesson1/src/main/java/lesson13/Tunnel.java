package lesson13;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                RaceThreads.tunnel.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
//                RaceThreads.tunnel.acquire(); кажется, что захват должен быть тут, это логичнее. Но тогда, тот кто первый или второй прошел первую дорогу, не всегда успевали попасть в тунель, переодически их кто-то обгонял, что мне не понятно, почему так?
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                RaceThreads.tunnel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
