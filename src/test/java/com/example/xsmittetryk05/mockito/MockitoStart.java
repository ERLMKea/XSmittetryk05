package com.example.xsmittetryk05.mockito;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoStart {

    @Test
    void testMock() {
        Map mapMock = mock(Map.class);
        mapMock.put("hej", "viggo");
        //assertEquals(1, mapMock.size());
        when(mapMock.get("hej")).thenReturn("viggo");
        assertEquals(0, mapMock.size());
        assertEquals("viggo", mapMock.get("hej"));

    }




}
