package com.example.xsmittetryk05.mockito;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoList {

    @Test
    void test1() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    void test2() {
        List<String> listMock = mock(List.class);
        listMock.add("hej");
        when(listMock.get(0)).thenReturn("firstelem");
        assertEquals("firstelem", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    void anyintTest() {
        List<String> listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("anyelem");
        for (int i = 0; i<10; i++) {
            assertEquals("anyelem", listMock.get(i));
        }
    }

    @Test
    void anyint2Test() {
        List<String> listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("anyelem");
        when(listMock.get(5)).thenThrow(new RuntimeException(("jeg kan ikke klare 5")));
        assertThrows(RuntimeException.class, () -> {
            for (int i = 0; i<6; i++) {
                assertEquals("anyelem", listMock.get(i));
            }
        });
    }


}
