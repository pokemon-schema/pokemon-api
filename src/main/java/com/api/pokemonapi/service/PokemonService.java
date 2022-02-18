package com.api.pokemonapi.service;

import java.util.Optional;

import com.api.pokemonapi.entity.Pokemon;
import com.api.pokemonapi.repository.PokemonRepository;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    // poke-api
    private final RestTemplate restTemplate;
    String baseUrlPokemon = "https://pokeapi.co/api/v2/pokemon/";
    String baseUrlAbility = "https://pokeapi.co/api/v2/ability/";

    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPokemonJson() {
        String url = baseUrlPokemon;
        return this.restTemplate.getForObject(url, String.class);
    }

    public String findPokemonById(Long id) {
        String idStr = String.valueOf(id);
        String url = baseUrlPokemon + idStr; // http://localhost:8080/pokemons/id=1
        return this.restTemplate.getForObject(url, String.class);
    }

    public String findPokemonByName(String name) {
        String url = baseUrlPokemon + name; // http://localhost:8080/pokemons/name=ditto
        return this.restTemplate.getForObject(url, String.class);
    }

    public String findAbilityById(Long id) {
        String idStr = String.valueOf(id);
        String url = baseUrlAbility + idStr; // http://localhost:8080/ability/id=1
        return this.restTemplate.getForObject(url, String.class);
    }

    public String findAbilityByName(String name) {
        String url = baseUrlAbility + name; // http://localhost:8080/ability/name=stench
        return this.restTemplate.getForObject(url, String.class);
    }

}
