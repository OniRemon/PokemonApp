package com.example.pokeapp.data

import com.example.pokeapp.data.model.PokeInfo
import com.example.pokeapp.data.model.toPokeInfo

class PokemonRepositoryImpl(private val apiClient: PokemonApiClient) : PokemonRepository {
    override fun getPokemonInfo(id: Long): PokeInfo? {
        val response = apiClient.getPokemonInfo(id)
        return response?.toPokeInfo()
    }
}