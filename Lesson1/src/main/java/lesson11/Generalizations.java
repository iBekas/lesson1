package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generalizations {
    public static void main(String[] args) {

        String[] arr = {"Один","Два","Три","Четыре"};
        changePlace(arr,"Два","Четыре"); //ВОПРОС 1: если я вместо "Два" ставлю "Один" или arr[0], binarySearch выдает иднекс -3 вместо 0. Не могу понять в чем проблема. При этом во втором примере ниже такой проблемы не наблюдается.
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = {1,2,3,4};
        changePlace(arr2,1,4);
        System.out.println(Arrays.toString(arr2));

        List <?> listArr = new ArrayList<>(changeArr(arr)); //ВОПРОС 3: после добавления массива через метод, где мы возвращем тип T, listArr станет типом Т, или так и останется обжектом?
        System.out.println(listArr);



//        ArrayList<Orange> listOrange = new ArrayList<>(Arrays.asList(new Orange(2), new Orange(1)));


        Box<Orange> box = new Box();
        box.plusFruit(new Orange(2));
        box.plusFruit(new Orange(1));
//        box.plusFruit(listOrange);
        System.out.println(box.getWeight());

        Box<Apple> box2 = new Box();
        box2.plusFruit(new Apple(2));
        box2.plusFruit(new Apple(1));
        System.out.println(box2.getWeight());

        Box<Apple> box3 = new Box();
        box3.plusFruit(new Apple(2));
        box3.plusFruit(new Apple(1));
        System.out.println(box3.getWeight());

        System.out.println(box.compare(box2));

        box2.emptyBox(box3);
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());

        box3.emptyBox(box2);
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());





    }

    private static <T> void changePlace (T[] arr, T x, T y){
        try { //можно было еще через лист и .set("Два","Четыре") переназначать, но понял это уже поздно.
            int temp = Arrays.binarySearch(arr, y);
            arr[Arrays.binarySearch(arr, x)] = y; //ВОПРОС 2: если х не найден, здесь выскакивает исключение, почему в этом случае строка ниже все равно выполняется?
            arr[temp] = x;
        } catch (ClassCastException e) {
            System.err.println("Запрошенные элементы массива не соответствуют типу массива.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Не найдено значение для замены.");
            arr[Arrays.binarySearch(arr, y)] = x;
        }
    }

    private static <T> List<T> changeArr (T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
        //идея подсказала, что нижний вариант фигня=)
//        for (T t : arr) {
//            list.add(t);
//        }
//        return list;
    }


}
