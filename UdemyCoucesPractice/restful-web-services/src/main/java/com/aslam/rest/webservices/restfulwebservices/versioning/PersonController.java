package com.aslam.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This file help to understand How many ways we can achieve versioning of an APi's
 */

@RestController
public class PersonController {
    @GetMapping(path = "/v1/persons")
    public Person1 getFirstVersionOfPerson() {
        return new Person1("Bob charlie");
    }

    @GetMapping(path = "/v2/persons")
    public Person2 getSecondVersionOfPerson() {
        return new Person2(new Name("Bob ", "charlie"));
    }

    @GetMapping(path = "/persons", params = "version=1")
    public Person1 getFirstVersionOfPersonRequestParameter() {
        return new Person1("Bob charlie");
    }

    @GetMapping(path = "/persons", params = "version=2")
    public Person2 getSecondVersionOfPersonRequestParameter() {
        return new Person2(new Name("Bob ", "charlie"));
    }

    @GetMapping(path = "/persons/header", headers = "X-API-VERSION=1")
    public Person1 getFirstVersionOfPersonRequestHeader() {
        return new Person1("Bob charlie");
    }

    @GetMapping(path = "/persons/header", headers = "X-API-VERSION=2")
    public Person2 getSecondVersionOfPersonRequestHeader() {
        return new Person2(new Name("Bob ", "charlie"));
    }

    @GetMapping(path = "/persons/header", produces = "application/vnd.company.app-v1+json")
    public Person1 getFirstVersionOfPersonAcceptHeader() {
        return new Person1("Bob charlie");
    }

    @GetMapping(path = "/persons/header", produces = "application/vnd.company.app-v2+json")
    public Person2 getSecondVersionOfPersonAcceptHeader() {
        return new Person2(new Name("Bob ", "charlie"));
    }
}
