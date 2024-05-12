package com.aslam.learnspringframework.example.a3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDBDataService implements DataService{
    @Override
    public int[] retriveData() {
        return new int[] {1,2,3,4};
    }
}
