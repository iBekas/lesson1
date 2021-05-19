package lesson9;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TryException {

    private static String[][] arr;
    private static String[][] arr2;
    private static String[][] arr3;

    public static void main(String[] args) {

        arr = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        arr2 = new String[][] {
                {"1", "2", "3", "4"},
                {"1", "Two", "3", "4"},
                {"1", "i", "3", "4"},
                {"1", "2", "3", "Four"},
        };

        arr3 = new String[][] {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "Two", "3", "4"},
        };

        arrayExceptionHandling(arr);
        arrayExceptionHandling(arr2);
        arrayExceptionHandling(arr3);

    }

    private static void arrayExceptionHandling(String[][] arr) {
        try {
            arrayException(arr);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Размер массива не подходит под данный метод");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Измените указанную ячейку");
        }
    }


    private static void arrayException (String[][] arr) throws MyArraySizeException,MyArrayDataException {
        String[][] exampleArr = new String[4][4];
        if (!arraySize(arr, exampleArr)) throw new MyArraySizeException("Размер массива должен быть 4х4.");
        int sum = 0;
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
//                try {
//                    sum += Integer.parseInt(arr[x][y]);
//                } catch (NumberFormatException e) {
//                    System.out.printf("В ячейке [%d][%d] лежит некорректное значени - %s\n", x, y, arr[x][y]);
//                }
                try {
                    sum += Integer.parseInt(arr[x][y]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В ячейке [%d][%d] лежит некорректное значени - %s\n", x, y, arr[x][y]));
                }
            }
        }
        System.out.println("Сумма элементов массива = " + sum + ".");
    }

    static class MyArrayDataException extends NumberFormatException {
        public MyArrayDataException(String s) {
            super(s);

        }
    }

    static class MyArraySizeException extends ArrayIndexOutOfBoundsException {
        public MyArraySizeException(String s) {
            super(s);
        }
    }

    private static boolean arraySize (String[][] arr, String[][] arr2) {
        return Array.getLength(arr) == Array.getLength(arr2);
    }


}
