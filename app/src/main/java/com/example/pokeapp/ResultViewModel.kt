package com.example.pokeapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.data.PokemonApiClient
import com.example.pokeapp.data.PokemonRepositoryImpl
import com.example.pokeapp.data.model.PokeInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ResultViewModel(): ViewModel() {
    private val apiClient = PokemonApiClient()
    private val repository = PokemonRepositoryImpl(apiClient)

    private val _pokemonInfo = MutableStateFlow<PokeInfo?>(null)
    val pokemonInfo: StateFlow<PokeInfo?> get() = _pokemonInfo

    fun fetchPokemonInfo(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val pokemonInfo = repository.getPokemonInfo(id)

            Log.d("resultViewModel", "pokemonInfo = $pokemonInfo")
            _pokemonInfo.value = pokemonInfo
        }
    }
}