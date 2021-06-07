package lesson14;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoggerAndTest {


    public static final Logger LOGGER = LogManager.getLogger(); // выводит в консоль только fatal, папку не создает. 40 минут мучений ничего не дали, уже просто скопировал ваши настройки, все равно тоже самое...



    public static void main(String[] args) {
//        LOGGER.info("Info");
//        LOGGER.fatal("Fatal");



        Integer[] arr = {1, 2, 3, 4, 8, 7};
        afterFour(arr);
        System.out.println(Arrays.toString(afterFour(arr)));

        int[] arr2 = {1, 1, 1, 4};
        System.out.println(oneOrFour(arr2));



    }

    public static Integer[] afterFour(Integer... arr) throws RuntimeException {
        List <Integer> list = new ArrayList<>(Arrays.asList(arr));
        try {
            if (!list.contains(4)) throw new RuntimeException("Where 4, Billy???");
            while (list.contains(4)) {
                int count = list.indexOf(4) +1;
                while (count-- > 0) {
                    list.remove(0);
                }
            }
            Integer[] intArr = new Integer[list.size()];
            for (int i = 0; i < intArr.length ; i++) {
                intArr[i] = list.get(i);
            }
            return intArr;
        } catch (RuntimeException e) {
            LOGGER.throwing(Level.FATAL, e);// почему он catch дважды в консоль выводит? Тоже не смог найти логичного объяснения...
        }
        return arr;
    }

    public static boolean oneOrFour(int... arr) {
        boolean check; //Idea говорит, что check - никогда не используется.
        for (int i : arr) {
            if(!(i == 1||i == 4)) return false;
        }
        for (int i : arr) {
            if (i == 1){
                check = true; // если я здесь уберу check = true, тогда далее не смогу проверить действительно ли была ежиница. Или я не прав?
                break;
            }
        }
        if (check = false) return false;

        for (int i : arr) {
            if (i == 4){
                check = true;
                break;
            }
        }
        if (check = false) return false;

        return true;
    }
}
