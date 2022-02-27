package com.api.pokemonapi.service;

import com.api.pokemonapi.entity.Pokemon;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    // poke-api
    private final RestTemplate restTemplate;

    // pager
    Integer offset = 0;
    Integer limit = 5;
    String pager = "?offset=" + offset + "&limit=" + limit;

    // pokemon
    String baseUrlPokemon = "https://pokeapi.co/api/v2/pokemon/";
    String imgUrlPokemon = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";
    // ability
    String baseUrlAbility = "https://pokeapi.co/api/v2/ability/";
    // type
    String baseUrlType = "https://pokeapi.co/api/v2/type/";

    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // all pokemons (pager)
    public String findPokemon() {
        this.limit = 1;
        String url = this.baseUrlPokemon + this.pager; // https://pokeapi.co/api/v2/pokemon/?offset=0&limit=1
        return this.restTemplate.getForObject(url, String.class);
    }

    // pokemon id
    public String findPokemonById(Long id) {
        String idStr = String.valueOf(id);
        String url = this.baseUrlPokemon + idStr; // http://localhost:8080/pokemons/id/1
        return this.restTemplate.getForObject(url, String.class);
    }

    // pokemon name
    public String findPokemonByName(String name) {
        String url = this.baseUrlPokemon + name; // http://localhost:8080/pokemons/name/ditto
        return this.restTemplate.getForObject(url, String.class);
    }

    // ability id
    public String findAbilityById(Long id) {
        String idStr = String.valueOf(id);
        String url = this.baseUrlAbility + idStr; // http://localhost:8080/ability/id/1
        return this.restTemplate.getForObject(url, String.class);
    }

    // ability name
    public String findAbilityByName(String name) {
        String url = this.baseUrlAbility + name; // http://localhost:8080/ability/name/stench
        return this.restTemplate.getForObject(url, String.class);
    }

}
