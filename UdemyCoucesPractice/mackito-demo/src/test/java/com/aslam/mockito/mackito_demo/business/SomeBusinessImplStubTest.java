package com.aslam.mockito.mackito_demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SomeBusinessImplStubTest {
    @Test
    void findTheGreatestFromAllData_BasicCase(){
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(25,result);
    }
    @Test
    void findTheGreatestFromAllData_WithOneValue(){
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        int result = someBusiness.findTheGreatestFromAllData();
        assertEquals(20,result);
    }
}


class DataServiceStub1 implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] {25,15,20};
    }
}

class DataServiceStub2 implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] {20};
    }
}