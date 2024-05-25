package com.aslam.mockito.mackito_demo.business;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData(){
        int[] data = dataService.retrieveData();
        int greatestValue = Integer.MIN_VALUE;
        for(int val:data){
            if(greatestValue<val){
                greatestValue = val;
            }
        }
        return greatestValue;
    }
}

interface DataService{
    int[] retrieveData();
}