public class lesson1 {
    public static void main(String[] args) {

        // Задание 2
        byte byteVar = 2;
        short shortVar = 256;
        int intVar = 59876;
        long longVar = 4_000_000_000L;

        double doubleVar = 3.14;
        float floatVar = 5.876f;

        char charVar = 'a';

        boolean booleanVar = true;

        // Задание 3- task3
        float a = 1.1f;
        float b = 2.1f;
        float c = 3.2f;
        float d = 4.3f;
        System.out.println("Задание 3 - " + task3(a, b, c, d));

        // Задание 4- task4
        int number1 = 5;
        int number2 = 3;
        System.out.println("Задание 4 - " +task4(number1, number2));

        // Задание 5- task5
        int number3 = -5;
        System.out.print("Задание 5 - ");
        task5(number3);

        // Задание 6 - task6
        int number4 = -5;
        System.out.println("Задание 6 - " + task6(number4));

        // Задание 7 - task7
        String name = "Дмитрий";
        System.out.print("Задание 7 - ");
        task7(name);

        // Задание 8 - task8
        int year = 1600;
        System.out.println("Задание 8 - " + task8(year));
    }



    static float task3 (float a, float b, float c, float d) {
        float f = (float) (a * (b + (c / d)));
        return f;
    }


    static boolean task4 (int a, int b) {
        int c = a+b;
        if (c >= 10 && c <= 20){
            return true;
        } else {
            return false;
        }
    }


    static void task5 (int x) {
        if (x >= 0){
            System.out.println("Число " + x + " положительное");
        } else {
            System.out.println("Число " + x + " отрицательное");
        }
    }

    static boolean task6 (int x) {
        if (x >= 0){
            return false;
        } else {
            return true;
        }
    }

    static void task7 (String x) {
        System.out.println("Привет, " + x);
    }

    static String task8 (int x) {
        double y = (double)x;
        String i = "високосный";
        String z = "не високосный";
        if (y%4 == 0 && y%100 != 0) {
            return i;
        } else if (y%400 == 0){
            return i;
        } else {
            return z;
        }
    }



}




