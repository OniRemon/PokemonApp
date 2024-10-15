package com.example.pokeapp.data.model

data class PokeInfo(
    val id: String,
    val name: String,
    val imageUrl : String,
    val type: List<String>,
    val height: String,
    val weight: String,
    val isFavorite: Boolean?,
)