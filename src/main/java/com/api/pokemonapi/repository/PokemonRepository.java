package com.api.pokemonapi.repository;

import java.util.List;
import java.util.Optional;

import com.api.pokemonapi.entity.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findAllByName(String name);

    Optional<Pokemon> findByName(String name);

}
