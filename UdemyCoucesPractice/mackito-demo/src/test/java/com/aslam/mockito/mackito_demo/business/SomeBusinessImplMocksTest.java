package com.aslam.mockito.mackito_demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMocksTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    void findTheGreatestFromAllData_BasicCase(){
        when(dataServiceMock.retrieveData()).thenReturn( new int[] {25,15,20});
        assertEquals(25, someBusiness.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_OneCase(){
        when(dataServiceMock.retrieveData()).thenReturn( new int[] {32});
        assertEquals(32, someBusiness.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_EmptyArray(){
        when(dataServiceMock.retrieveData()).thenReturn( new int[] {});
        assertEquals(Integer.MIN_VALUE, someBusiness.findTheGreatestFromAllData());
    }
}


