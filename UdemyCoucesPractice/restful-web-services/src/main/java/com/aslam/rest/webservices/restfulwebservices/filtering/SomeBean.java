package com.aslam.rest.webservices.restfulwebservices.filtering;

/**
 * Static Filtering example using JsonIgnore for filed level and JsonIgnoreProperties for class levels
 * in class level we can either single value or arrays of values to include more filed
 */
//@JsonIgnoreProperties("field1")
//@JsonIgnoreProperties({"field1","field2"})
public class SomeBean {
    private String field1;

    //@JsonIgnore
    private String field2;

    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}