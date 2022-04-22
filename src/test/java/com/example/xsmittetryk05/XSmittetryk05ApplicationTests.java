package com.example.xsmittetryk05;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
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
}
