package com.aslam.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int Age){};
record Person2(String name, int Age, Address address){};
record Address(String city, String state){};

@Configuration
public class HelloWorldSpringConfiguration {

  @Bean
  public String name(){
    return "Aslam";
  }

  @Bean

  public int Age(){
      return 27;
  }

  @Bean
  public Person person(){
    var person = new Person("Ansari", 23);
    return person;
  }

   @Bean
  public Person2 person2MtodCall(){
    var person = new Person2(name(), Age(),address());
    return person;
  }

   @Bean
  public Person2 person3MtodCall(String name, int age, Address address){
    var person = new Person2(name, age, address);
    return person;
  }


   @Bean(name = "address2")
  public Address address(){
    var address = new Address("Maharajganj", "U.P");
    return address;
  }
}
