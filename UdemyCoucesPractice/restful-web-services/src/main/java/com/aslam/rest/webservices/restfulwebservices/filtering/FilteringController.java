package com.aslam.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        /**
         * For Dynamic filtering use MappingJacksonValue
         */

        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        //  MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        return someBean;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
    }
}
