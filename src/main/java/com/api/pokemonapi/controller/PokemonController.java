package com.api.pokemonapi.controller;

import com.api.pokemonapi.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @Autowired
    PokemonService service;

    @RequestMapping("/")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("/pokemons")
    public String listAllPokemons() {
        return service.getPokemonJson();
    }

}
