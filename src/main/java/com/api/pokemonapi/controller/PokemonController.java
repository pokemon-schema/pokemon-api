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

    // home api endpoint
    @RequestMapping("/") // http://localhost:8080/
    public String helloWorld() {
        return "pokemon-api v1.0.0 - by amyszko";
    }

    // pokemon endpoints
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

    // ability endpoints
    @RequestMapping("/ability/id/{id}") // http://localhost:8080/ability/id/1
    public String selectAbilityById(@PathVariable(value = "id") Long id) {
        return service.findAbilityById(id);
    }

    @RequestMapping("/ability/name/{name}") // http://localhost:8080/ability/name/stench
    public String selectAbilityByName(@PathVariable(value = "name") String name) {
        return service.findAbilityByName(name);
    }

    // type endpoints
    @RequestMapping("/type/id/{id}") // http://localhost:8080/type/id/1
    public String selectTypeById(@PathVariable(value = "id") Long id) {
        return service.findTypeById(id);
    }

    @RequestMapping("/type/name/{name}") // http://localhost:8080/type/name/stench
    public String selectTypeByName(@PathVariable(value = "name") String name) {
        return service.findTypeByName(name);
    }

}
