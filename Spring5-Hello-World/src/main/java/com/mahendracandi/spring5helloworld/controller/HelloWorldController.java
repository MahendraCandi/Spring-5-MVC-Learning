package com.mahendracandi.spring5helloworld.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorldController {
    private final static Logger log = Logger.getLogger(HelloWorldController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap modelMap){
        log.info("----------Masuk ke sayHello() method----------");
        modelMap.addAttribute("greeting", "Hello world from Spring MVC");
        return "welcome";
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap modelMap){
        log.info("----------Masuk ke sayHelloAgain() method----------");
        modelMap.addAttribute("greeting", "Hello world again, from Spring MVC");
        return "welcome";
    }
}
