package com.aslam.rest.webservices.restfulwebservices.helloworld;

public class HellWorldBean {
    private String message;

    public HellWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
