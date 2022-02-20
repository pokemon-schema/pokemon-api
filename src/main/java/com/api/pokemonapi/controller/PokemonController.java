package com.api.pokemonapi.controller;

import javax.servlet.http.HttpServletResponse;

import com.api.pokemonapi.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin
public class PokemonController {

    // service
    @Autowired
    private PokemonService service;

    @RequestMapping("/") // http://localhost:8080/
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("/pokemon") // http://localhost:8080/pokemon
    public String listAllPokemons() {
        return service.findPokemon();
    }

    @RequestMapping("/pokemon/id/{id}") // http://localhost:8080/pokemon/id/1
    public String selectPokemonById(@PathVariable(value = "id") Long id) {
        return service.findPokemonById(id);
    }

    @RequestMapping("/pokemon/name/{name}") // http://localhost:8080/pokemon/name/ditto
    public String selectPokemonByName(@PathVariable(value = "name") String name) {
        return service.findPokemonByName(name);
    }

    @RequestMapping("/ability/id/{id}") // http://localhost:8080/ability/id/1
    public String selectAbilityById(@PathVariable(value = "id") Long id) {
        return service.findAbilityById(id);
    }

    @RequestMapping("/ability/name/{name}") // http://localhost:8080/ability/name/stench
    public String selectAbilityByName(@PathVariable(value = "name") String name) {
        return service.findAbilityByName(name);
    }

}
