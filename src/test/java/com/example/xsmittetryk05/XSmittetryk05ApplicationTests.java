package com.example.xsmittetryk05;

import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transaction;
import java.time.LocalDateTime;
import java.util.Arrays;

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


}
