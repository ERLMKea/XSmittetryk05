package com.example.xsmittetryk05;

import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transaction;
import java.time.LocalDateTime;
import java.util.Arrays;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class XSmittetryk05ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        if (3>4) {
            fail("det går slet ikke");
        }
    }

    @Test
    void test2() {
        assertEquals("ABC", "ABC");
    }

    @Test
    void testArr() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertEquals(expected, numbers);
    }

    @Test
    void testArr2() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    void testArrNullPointerExcept() {
        int[] numbers = null;
        int[] expected = {1,3,4,12};
        try {
            Arrays.sort(numbers);

        } catch (NullPointerException nullerr) {
            System.out.println("Nullexp err=" +  nullerr);
        }
    }

    @Test
    void testArithmException() {
        assertThrows(ArithmeticException.class, () -> {
            int result = 3/0;
        });
    }

    @Test
    void testSortPerformance() {
        int[] numbers = {12, 23, 4};
        int[] actualResult = assertTimeout(ofSeconds(1), () -> {
            for (int i = 1; i <= 100000000; i++) {
                numbers[2] = i;
                Arrays.sort(numbers);
            }
            return numbers;
        });
        int[] expected = {1, 2, 100};
        expected[2] = 100000000;
        Arrays.sort(expected);
        assertArrayEquals(expected, numbers);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        int mmm = number % 2;
        System.out.println(mmm);
        assertTrue(mmm == 1);
    }

}
