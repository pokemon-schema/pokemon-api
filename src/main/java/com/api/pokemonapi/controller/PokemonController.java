package com.api.pokemonapi.controller;

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

    @RequestMapping("/")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("/pokemons")
    public String listAllPokemons() {
        return service.getPokemonJson();
    }

    @RequestMapping("/pokemons/id={id}")
    public String selectPokemonById(@PathVariable(value = "id") Long id) {
        return service.findPokemonById(id);
    }

    @RequestMapping("/pokemons/name={name}")
    public String selectPokemonByName(@PathVariable(value = "name") String name) {
        return service.findPokemonByName(name);
    }

    @RequestMapping("/ability/id={id}")
    public String selectAbilityById(@PathVariable(value = "id") Long id) {
        return service.findAbilityById(id);
    }

    @RequestMapping("/ability/name={name}")
    public String selectAbilityByName(@PathVariable(value = "name") String name) {
        return service.findAbilityByName(name);
    }

    // // repository
    // @Autowired
    // private PokemonRepository repository;

    // @GetMapping("/pokemons/id={id}")
    // public Optional<Pokemon> selectById(@PathVariable(value = "id") Long id) {
    // return repository.findById(id);
    // }
}
