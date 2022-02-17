package com.api.pokemonapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    RestService service;

    @RequestMapping("/")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("/posts")
    public String listAllPosts() {
        return service.getPokemonJson();
    }

}
