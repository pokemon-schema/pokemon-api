package com.api.pokemonapi.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPokemonJson() {
        String url = "https://pokeapi.co/api/v2/pokemon";
        return this.restTemplate.getForObject(url, String.class);
    }

}
