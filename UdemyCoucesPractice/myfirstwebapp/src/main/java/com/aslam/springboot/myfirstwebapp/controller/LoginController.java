package com.aslam.springboot.myfirstwebapp.controller;

import com.aslam.springboot.myfirstwebapp.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {
    private final Logger logger  = LoggerFactory.getLogger(getClass());

  // @Autowired
    private AuthenticationService authenticationService;


    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String RedirectToWelcomePage(@RequestParam String name, @RequestParam String password,ModelMap model){
        model.put("name",name);
        model.put("password",password);
        //Authentication
        //Valid user: name = aslam, password  = dummy
        if(authenticationService.authenticate(name,password)){
            return "welcome";
        }

        model.put("errorMessage","Invalid Credential, Please try with valid credential");
       return "login";
    }
}
