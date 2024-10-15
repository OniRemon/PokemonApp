package com.example.pokeapp.data

import com.example.pokeapp.data.model.PokeInfo

interface PokemonRepository {
    fun getPokemonInfo(id: Long): PokeInfo?
}