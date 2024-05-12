package com.aslam.learnspringframework.example.a3;



import org.springframework.stereotype.Component;

import java.lang.Math;
import java.util.Arrays;
@Component
public class BusinessCalculationService {
    private DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retriveData()).max().orElse(0);
    }
}
