package lesson10;

import java.util.*;

public class TryCollection {

    public static Map <String, StringBuilder> phonebook = new HashMap<>();

    public static void main(String[] args) {

/* ЗАДАНИЕ 1, хотел сделать сортировку HashSet хотя бы по длине(в данном случае не придумал ничего адекватнее),
*  но если сначала ставлю аргументом сортировку, а потом добавляю List, теряются уникальные элементы,
* не могу понять в чем проблема. Подскажете?=) */

        List<String> doubleSet = new ArrayList<>(Arrays.asList("Один", "Два","Три","Четыре","Пять","Один","Шесть","Два","Семь","Пять","Три","Два","Четыре","Восемь","Девять","Один","Три"));
        Set<String> tempSet = new HashSet<>(doubleSet);
//        Set<String> tempSet = new TreeSet<>(Comparator.comparingInt(String::length));
//        tempSet.addAll(doubleSet);
        System.out.println("Уникальные слова: " + tempSet);

        for (String s : tempSet) {
            int counter = 0;
            for (String s1 : doubleSet) {
                if (s.equals(s1)) counter++;
            }
            System.out.printf("%s - количество повторений: %d\n", s, counter);


        }

// ЗАДАНИЕ 2

/* Я понимаю, что скорее всего ваше решение будет значительно менее нагружено,
но хоть где-то в текущей практике я же должен использовать StringBuilder=)
На самом деле не смог сделать конкатенацию строк без StringBuilder в куске ниже:
            if (stringStringEntry.getKey().equals(x)) stringStringEntry.getValue().append(", " + y);
Решение скорее всего банальное, но все равно не могу придумать как в данном случае складывать String,
 постоянно выдает ошибку(Идея тоже указывает на эту строку, что в ней что-то не так). Где я туплю?=)*/
        add("Петров", new StringBuilder("888888"));
        add("Сидоров", new StringBuilder("777777"));
        add("Петров", new StringBuilder("666666"));
        add("Иванов", new StringBuilder("555555"));
        add("Хасан", new StringBuilder("444444"));
        add("Моисеев", new StringBuilder("333333"));
        add("Сидоров", new StringBuilder("222222"));

        System.out.println(phonebook);

        get("Петров");
        get("Сидоров");

    }

    static void add(String x, StringBuilder y){
        for (Map.Entry<String, StringBuilder> stringStringEntry : phonebook.entrySet()) {
            if (stringStringEntry.getKey().equals(x)) stringStringEntry.getValue().append(", " + y);
        }
        phonebook.putIfAbsent(x, y);
    }

    static void get(String x){
        System.out.println("Доступные телефонные номера под фамилией " + x + ": " + phonebook.get(x));
    }


}


