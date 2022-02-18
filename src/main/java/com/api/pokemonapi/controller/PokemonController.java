package com.api.pokemonapi.controller;

import java.util.Optional;

import com.api.pokemonapi.entity.Pokemon;
import com.api.pokemonapi.repository.PokemonRepository;
import com.api.pokemonapi.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String selectById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @RequestMapping("/pokemons/name={name}")
    public String selectByName(@PathVariable(value = "name") String name) {
        return service.findByName(name);
    }

    // // repository
    // @Autowired
    // private PokemonRepository repository;

    // @GetMapping("/pokemons/id={id}")
    // public Optional<Pokemon> selectById(@PathVariable(value = "id") Long id) {
    // return repository.findById(id);
    // }
}
