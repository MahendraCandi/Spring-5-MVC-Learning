package com.mahendracandi.spring5mvcrestservicehelloworld.controller;

import com.mahendracandi.spring5mvcrestservicehelloworld.domain.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// perbedaan antara @Controller dengan @RestController adalah
// @Controller return view, respon berupa html
// @RestController return berupa object/pojo, yang akan di convert ke json atau xml
@RestController
public class RestControllerHelloWorld {

    @RequestMapping("/")
    public String welcome(){
        return "Welcome to REST Template example";
    }

    // akses url atau end point ini dengan akhiran .json -> untuk melihat hasil balikan berupa json
    @RequestMapping("/hello/{playerName}")
    public Message message(@PathVariable String playerName){
        Message message = new Message(playerName, "Hello " + playerName + ", nice to see you join");
        return message;
    }
}
