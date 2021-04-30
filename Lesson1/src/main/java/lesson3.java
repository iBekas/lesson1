import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class lesson3 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Задание 3 - мещение эллементов массива на n, метод -arrShift;
        int[] arrForShift = {1, 2, 3, 4, 5};
        int shift = -2;
        System.out.print("Задание 3 - ");
        System.out.println(Arrays.toString(arrShift(arrForShift, shift)));
        System.out.println(" ");

        // Задание 2 выполнил в прошлом ДЗ

        // Задание 1 - игра, метод - game
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        game(words);

    }

    private static int[] arrShift(int[] arr, int shift) { // через жопу, но главное результат=)
        int[] temp = new int[arr.length];
        shift = -shift;
        for (int i = 0; i < arr.length; i++) {
            int x = arr.length - (shift - i);
            while (true) {
                if(x >= arr.length) {
                    x-=5;
                }else if (x<0) {
                    x+=5;
                }else break;
            }
            temp[x] = arr[i];
        }
        return temp;
    }


    private  static void game (String [] arr) {
        while (true) {
            char a;
            char b;
            Random random = new Random();
            int answer = random.nextInt(arr.length);
            System.out.print("Я загадал одно из этих слов - " + Arrays.toString(arr) + "\nКак ты думаешь какое слово я загадал? >>> ");
            String userAnswer = scanner.next();
            userAnswer = userAnswer.toLowerCase(Locale.ROOT);
            while (true) {
                if (arr[answer].equals(userAnswer)) {
                    System.out.println("Ты угадал!!!");
                    break;
                } else {
                    System.out.println("Ты не угадал. Попробуй еще раз, держи подсказку! Если буквы совпали, они появятся всмето #.");
                    for (int i = 0; i < 15; i++) {
                        String test1 = arr[answer] + "................."; // я знаю, что это ОЧЕНЬ изящное решение, но уже 12 ночи, сделайте поблажку=)
                        String test2 = userAnswer + ",,,,,,,,,,,,,,,,,";
                        a = test1.charAt(i);
                        b = test2.charAt(i);
                        if (a == b) System.out.print(a);
                        else System.out.print("#");
                    }
                    System.out.println(" ");
                    userAnswer = scanner.next();
                }
            }
            System.out.println("Еще разок? 1- да, 0 - нет.");
            int userChoice = scanner.nextInt();
            if (userChoice != 1) break;
        }
    }



}
