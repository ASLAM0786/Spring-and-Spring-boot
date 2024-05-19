package com.aslam.rest.webservices.restfulwebservices.versioning;

public class Person2 {
    private final Name name;

    public Person2(Name name) {
        super();
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name=" + name +
                '}';
    }
}
