package com.example.pokeapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class PokemonInfoResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "sprites") val sprites: PokemonSpriteResponse,
    @Json(name = "types") val types: List<PokemonTypeResponse>,
    @Json(name = "height") val height: Long,
    @Json(name = "weight") val weight: Long,
    @Json(name = "stats") val stats: List<PokemonStatResponse>
)

fun PokemonInfoResponse.toPokeInfo(): PokeInfo {
    return PokeInfo(
        id = id.toString(),
        name = name,
        imageUrl = sprites.other.officialArtwork.imageUrl ?: "",
        type = types.map { it.type.name },
        height = "${height / 10}.${height % 10}",
        weight = "${weight / 10}.${weight % 10}",
        isFavorite = false
    )
}

@JsonClass(generateAdapter = true)
data class PokemonSpriteResponse(
    @Json(name = "other") val other: PokemonSpriteOtherResponse
)

@JsonClass(generateAdapter = true)
data class PokemonSpriteOtherResponse(
    @Json(name = "official-artwork") val officialArtwork: PokemonSpriteOfficialArtworkResponse
)

@JsonClass(generateAdapter = true)
data class PokemonSpriteOfficialArtworkResponse(
    @Json(name = "front_default") val imageUrl: String?
)

@JsonClass(generateAdapter = true)
data class PokemonTypeResponse(
    @Json(name = "type") val type: PokemonTypeDetailResponse
)

@JsonClass(generateAdapter = true)
data class PokemonTypeDetailResponse(
    @Json(name = "name") val name: String
)


@JsonClass(generateAdapter = true)
data class PokemonStatResponse(
    @Json(name = "base_stat") val baseStat: Long,
    @Json(name = "stat") val stat: PokemonStatDetailResponse
)

@JsonClass(generateAdapter = true)
data class PokemonStatDetailResponse(
    @Json(name = "name") val name: String
)