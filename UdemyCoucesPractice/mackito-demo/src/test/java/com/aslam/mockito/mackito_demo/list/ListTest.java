package com.aslam.mockito.mackito_demo.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    void simpleTest(){
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(4);
        assertEquals(4,mockList.size());
        assertEquals(4,mockList.size());
        assertEquals(4,mockList.size());
    }

    @Test
    void multipleReturnTest(){
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(4).thenReturn(2);
        assertEquals(4,mockList.size());
        assertEquals(2,mockList.size());
        assertEquals(2,mockList.size());
        assertEquals(2,mockList.size());
    }

    @Test
    void specificParameterTest(){
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("Some String");
        assertEquals("Some String",mockList.get(0));
        assertEquals("Some String",mockList.get(0));
    }

    @Test
    void genericcParameterTest(){
        List mockList = mock(List.class);
        when(mockList.get(Mockito.anyInt())).thenReturn("Some Other String");
        assertEquals("Some Other String",mockList.get(0));
        assertEquals("Some Other String",mockList.get(1));
        assertEquals("Some Other String",mockList.get(2));
        assertEquals("Some Other String",mockList.get(3));
    }
}
