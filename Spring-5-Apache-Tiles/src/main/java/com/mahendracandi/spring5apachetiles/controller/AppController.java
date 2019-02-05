package com.mahendracandi.spring5apachetiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * all return value from this method treated as tiles-view
 * it's happen coz TilesViewResolver
 */
@Controller
@RequestMapping("/")
public class AppController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(ModelMap model){
        return "home";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productsPage(ModelMap model){
        return "products";
    }

    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
    public String contactUsPage(ModelMap model){
        return "contactus";
    }
}
