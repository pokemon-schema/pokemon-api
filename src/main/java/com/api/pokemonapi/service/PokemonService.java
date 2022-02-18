package com.api.pokemonapi.service;

import com.api.pokemonapi.repository.PokemonRepository;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    // repository
    private PokemonRepository pokemonRepository;

    // poke-api
    private final RestTemplate restTemplate;

    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPokemonJson() {
        String url = "https://pokeapi.co/api/v2/pokemon/1";
        return this.restTemplate.getForObject(url, String.class);
    }

}
