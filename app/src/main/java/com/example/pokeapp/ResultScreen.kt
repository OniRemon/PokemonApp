package com.example.pokeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pokeapp.component.PokemonImage
import com.example.pokeapp.data.model.PokeInfo

@Composable
fun ResultScreen(
    navController: NavController,
    id: String?,
) {
    val viewModel: ResultViewModel = viewModel()
    val pokemonInfo = viewModel.pokemonInfo.collectAsState()

    id?.toLongOrNull()?.let {
        viewModel.fetchPokemonInfo(it)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(text = "結果画面")
        Text(text = "ID: $id")

        pokemonInfo.value?.let {
            PokemonImage(pokeInfo = it)
        } ?: run {
            Text(text = "ポケモン情報を取得中")
        }

    }
}