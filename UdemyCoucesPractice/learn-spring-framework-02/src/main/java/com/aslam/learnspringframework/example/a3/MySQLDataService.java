package com.aslam.learnspringframework.example.a3;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService{
    @Override
    public int[] retriveData() {
        return new int [] {12,14,3,58};
    }
}
