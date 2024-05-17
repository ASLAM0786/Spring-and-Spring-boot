package com.aslam.springboot.myfirstwebapp.controller;

import com.aslam.springboot.myfirstwebapp.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    // @Autowired
    private final AuthenticationService authenticationService;


    public WelcomeController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap modelMap) {
        modelMap.put("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String RedirectToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name", name);
        model.put("password", password);
        //Authentication
        //Valid user: name = aslam, password  = dummy
        if (authenticationService.authenticate(name, password)) {
            return "welcome";
        }

        model.put("errorMessage", "Invalid Credential, Please try with valid credential");
        return "login";
    }
}
