package com.example.pokeapp.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.pokeapp.data.model.PokeInfo

@Composable
fun PokemonImage(pokeInfo: PokeInfo) {
    Column {
        AsyncImage(
            model = pokeInfo.imageUrl,
            contentDescription = "pokemonImage"
        )

        Row {
            Text(text = "ID: ${pokeInfo.id}")
        }
        Row {
            Text(text = "名前: ${pokeInfo.name}")
        }
        Row {
            Text(text = "タイプ: ${pokeInfo.type[0]}")
            if (pokeInfo.type.size == 2) {
                Text(text = pokeInfo.type[1])
            }
        }
        Row {
            Text(text = "高さ: ${pokeInfo.height}m")
        }
        Row {
            Text(text = "重さ: ${pokeInfo.weight}kg")
        }

    }
}