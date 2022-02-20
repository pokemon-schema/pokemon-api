package com.api.pokemonapi.dto;

import com.api.pokemonapi.entity.Pokemon;
import com.api.pokemonapi.repository.PokemonRepository;
import com.api.pokemonapi.service.PokemonService;

public class PokemonDTO extends Pokemon {
    PokemonService pokemonService;
    PokemonRepository pokemonRepository;

}