package com.mahendracandi.spring5helloworldannotationsexample.controller;

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
    public String sayHello(ModelMap model){
        log.info("MASUK KE SAY HELLO");
        model.addAttribute("greeting", "Hello world Spring 5");
        return "welcome";
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model){
        log.info("MASUK KE SAY HELLO AGAIIN");
        model.addAttribute("greeting", "Hello world again");
        return "welcome";
    }
}
