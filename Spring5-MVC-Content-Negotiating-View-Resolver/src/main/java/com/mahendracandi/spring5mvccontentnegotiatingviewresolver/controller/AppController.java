package com.mahendracandi.spring5mvccontentnegotiatingviewresolver.controller;

import com.mahendracandi.spring5mvccontentnegotiatingviewresolver.model.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    @RequestMapping(value = "/tukang-pizza/{pizzaName}", method = RequestMethod.GET)
    public String getPizza(@PathVariable String pizzaName, ModelMap modelMap){
        List<String> topings = new ArrayList<>();
        topings.add("Muhsroom");
        topings.add("Paprika");

        Pizza pizza = new Pizza(pizzaName, "KEJU", topings);
        modelMap.addAttribute("pizza", pizza);
        return "Pizza";
    }
}
