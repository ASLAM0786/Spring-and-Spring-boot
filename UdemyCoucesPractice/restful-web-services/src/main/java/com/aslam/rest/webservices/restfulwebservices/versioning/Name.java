package com.aslam.rest.webservices.restfulwebservices.versioning;

public class Name {

    private String firstname;
    private String lastname;

    public Name(String lastname, String firstname) {
        super();
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
