package lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {

    private T[] somethingFruit;
    private ArrayList<T> fruitAtList;//ВОПРОС 4: если вместо ArrayList, пишу List все ломается. Почему?

    public Box() {
       this.fruitAtList = new ArrayList<>();
    }

//    public Box(T... somethingFruit) { //как вариант
//        this.somethingFruit = somethingFruit;
//        this.fruitAtList = new ArrayList<>(Arrays.asList(this.somethingFruit));
//    }
//
//    Не получается реализовать, яблочная коробка спокойно принимает апельсиновый лист.
//    public Box(ArrayList<T> fruitAtList) {
//        this.fruitAtList = fruitAtList;
//    }

    public void plusFruit (T fruit){
        this.fruitAtList.add(fruit);
// Даже удалять не буду строчки ниже, это признание в глупости, забыл объявить тип коробки=)
//        if (!fruit.typeFruit.equals(fruitAtList.get(0).typeFruit)) {
//            System.out.println("Коробка выплюнула ваш фрукт.");
//            this.fruitAtList.remove(fruit);
//        }
    }


    public void plusFruit (ArrayList<T> fruitAtList){
        this.fruitAtList.addAll(fruitAtList);
    }

    public double getWeight() {
        double sum = 0;
        for (T t : this.fruitAtList) {
           sum += t.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }


    public void emptyBox(Box<T> box) {
        box.fruitAtList.addAll(this.fruitAtList);
        this.fruitAtList.clear();

//И еще раз забыл объявить тип, ниже был вариант для обжектов...жалко просто удалить, столько сил затрачено=)
//        try {
//            if (this.fruitAtList.get(0).typeFruit.equals(box.fruitAtList.get(0).typeFruit)) {
//                box.fruitAtList.addAll(this.fruitAtList);
//                this.fruitAtList.clear();
//            } else System.out.println("Вам попалась привередливая коробка, не хочет отпускать свои фрукты.");
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("В коробке и так ничего нет.");
//        }
    }

}
