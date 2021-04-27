public class lesson1 {
    public static void main(String[] args) {

        // Задание 1 - замена 1 на 0, 0 на 1, метод - arrOneZero
        int[] arr = {1,1,1,0,0,0,1,1,1};
        System.out.print("Задание 1 - ");
        arrOneZero(arr);

        // Задание 2 - заолнить цикл значениями, метод - arrPushNumber
        int[] arr2 = new int[8];
        System.out.println(" ");
        System.out.print("Задание 2 - ");
        arrPushNumber(arr2);

        // Задание 3 - числа меньше 6 * 2, метод - arrMultiply
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(" ");
        System.out.print("Задание 3 - ");
        arrMultiply(arr3);

        // Задание 4 - диагональные числа = 1, метод - arrDiagonal
        int[][] arr4 = new int[5][5];
        System.out.println(" ");
        System.out.println("Задание 4 - ");
        arrDiagonal(arr4);

        // Задание 5 - Максимальное и минимально значение в массиве, метод - arrMaxMin
        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 2};
        System.out.print("Задание 5 - ");
        arrMaxMin(arr5);

        // Задание 6 - Место, в котором сумма левой и правой части массива равны, метод - arrBalance
        int[] arr6 = {3, 2, 2, 1, 1, 2, 2, 5};
        System.out.print("Задание 6 - ");
        System.out.println(arrBalance(arr6));

        // Задание 7
        int[] arr7 = new int[5];
        System.out.print("Задание 7 - ");


    }

    private static void arrOneZero(int[] arr) {
        for( int i =0; i < arr.length; i++) {
            switch (arr[i]) {
                case 1:
                    arr[i] = 0;
                    System.out.print(arr[i] + " ");
                    break;
                case 0:
                    arr[i] = 1;
                    System.out.print(arr[i] + " ");
                    break;
            }
        }
    }

    private static void arrPushNumber(int[] arr){
        arr[0] = 0;
        System.out.print(arr[0] + " ");
        for(int i = 1; i < arr.length ; i++) {
            arr[i] = arr[i-1] +3;
            System.out.print(arr[i] + " ");
        }
    }

    private static void arrMultiply(int[] arr) {
        for(int i = 0; i < arr.length ; i++) {
            if (arr[i] < 6) arr[i] *= 2;
            System.out.print(arr[i] + " ");
        }
    }

    private static void arrDiagonal(int[][] arr) {
        int j = 0;
        int a = 0;
        int b = arr[j].length - 1;
        for(; j < arr.length ; j++) {
            for(int k = 0; k < arr[j].length ; k++) {
                if (j == k) arr[j][k] = 1;
                else arr[j][k] = 0;
                if(j==a && k==b) arr[j][k] =1;
                System.out.print(arr[j][k] + " ");
            }
            if(a< arr.length && b>0) {
                a++;
                b--;
            }
            System.out.println(" ");
        }
    }

    private static void arrMaxMin(int[] arr) {
        int x = arr[0];
        for (int i : arr) {
            if (x < arr[i]) x = arr[i];
        }
        System.out.print("Максимальное значение = " + x + ". ");
        for (int i : arr) {
            if (x > arr[i]) x = arr[i];
        }
        System.out.println("Минимальное значение = " + x + ".");
    }

    private static boolean arrBalance(int[] arr){
        int x = 0;
        int y = 0;
        int z = arr.length - 2;
        for ( int k = 2; k < arr.length; k++){
            for ( int i = 0; i <= arr.length -k; i++) {
                x += arr[i];
            }
            for (int j = arr.length - 1; j > z; j--) {
                y += arr[j];
            }
            if (z >=0) z -= 1;
            if (x == y) return true;
            x = 0;
            y = 0;
        }
        return false;
    }


    private static void arrShift(int[] arr){

    }
}