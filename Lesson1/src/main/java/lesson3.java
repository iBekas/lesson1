import java.util.Scanner;

public class lesson3 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Задание 3 - мещение эллементов массива на n, метод -arrShift;
        int[] arrForShift = {1, 2, 3, 4, 5};
        int shift = 2;
        System.out.print("Задание 3 - ");
        arrShift(arrForShift, shift);

        // Задание 1 - игра, метод - game
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        game(words);
    }

    private static void arrShift(int[] arr, int shift) {
        for (int i = 0; i < arr.length; i++) {
            int x = arr.length - (shift - i);
            while (true) {
                if(x >= arr.length && x>0) {
                    x-=5;
                }else if (x<0) {
                    x+=5;
                }else if (x>=0 && x< arr.length) {
                    break;
                }
            }
            arr[i] = arr[x];

        }
    }


    private  static void game (String [] arr) {

    }

}
