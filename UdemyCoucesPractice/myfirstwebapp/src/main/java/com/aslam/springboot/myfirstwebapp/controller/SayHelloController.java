package com.aslam.springboot.myfirstwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello ! What are you learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHTML(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<head>");
        stringBuffer.append("<title> My First HTML Page using  Spring Boot </title>");
        stringBuffer.append("</head>");
        stringBuffer.append("<body>");
        stringBuffer.append("My First HTML page using This Tech");
        stringBuffer.append("</body>");
        stringBuffer.append("</html>");

        return stringBuffer.toString();
    }

    //JSP --sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("say-hello-jsp")

    public String sayHelloJsp() {
        return "sayHello";
    }

}
