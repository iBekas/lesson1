package lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


class LoggerAndTestTest {



    @CsvFileSource (files = "testLoggerAndTestTest/tests_data.csv")
    @ParameterizedTest
    static void massAfterFour(Integer[] arrTrue, Integer[] arrTest){
        Assertions.assertArrayEquals(arrTrue,arrTest);
    }


    @CsvSource({"'1, 7', '1, 2, 3, 4, 1, 7'"}) // Все, сдаюсь. Может решение и очевидно, но как записать и разделить два массива нет ни в гайде по junit, ни на форумах англо и русско говорящих. Я попробовал десяток вариантов, всегда "No test were found". Соответственно и в файл тоже поместить не смог. Как правильно записать два массива, что метод их принял?
    @ParameterizedTest
    static void massAfterFour2(Integer[] arrTrue, Integer[] arrTest){
        Assertions.assertArrayEquals(arrTrue,arrTest);
    }

    @org.junit.jupiter.api.Test
    void afterFour() {
        Integer[] arr = {1, 7};
        Integer[] arr1 = {1, 2, 3, 4, 1, 7};
        Assertions.assertArrayEquals(arr, LoggerAndTest.afterFour(arr1));
    }

    @org.junit.jupiter.api.Test
    void oneOrFour() {
        int[] arr1 = {1, 1, 4, 1, 1, 4};
        Assertions.assertTrue(LoggerAndTest.oneOrFour(arr1));
    }
}