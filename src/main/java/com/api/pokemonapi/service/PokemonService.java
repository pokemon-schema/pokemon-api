package com.api.pokemonapi.service;

import java.util.Optional;

import com.api.pokemonapi.entity.Pokemon;
import com.api.pokemonapi.repository.PokemonRepository;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    // poke-api
    private final RestTemplate restTemplate;
    String baseUrl = "https://pokeapi.co/api/v2/";

    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPokemonJson() {
        String url = baseUrl + "pokemon/";
        return this.restTemplate.getForObject(url, String.class);
    }

    public String findById(Long id) {
        String idStr = String.valueOf(id);
        String url = baseUrl + "pokemon/" + idStr; // http://localhost:8080/pokemons/id=1
        return this.restTemplate.getForObject(url, String.class);
    }

}
