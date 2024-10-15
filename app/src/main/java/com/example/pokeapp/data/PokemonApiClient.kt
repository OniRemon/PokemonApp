package com.example.pokeapp.data

import android.util.Log
import com.example.pokeapp.data.model.PokemonInfoResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class PokemonApiClient {

    private val client = OkHttpClient()
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun getPokemonInfo(id: Long): PokemonInfoResponse? {
        val request = Request.Builder()
            .url("https://pokeapi.co/api/v2/pokemon/$id")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                if (response.code == 404) {
                    Log.e("getPokemonInfo", "ポケモンIDが存在しません。 id = $id")
                    return null
                }
                throw IOException("Unexpected code $response")
            }
            val responseBody = response.body?.string() ?: ""
            Log.d("tag", "response = $responseBody")
            val jsonAdapter = moshi.adapter(PokemonInfoResponse::class.java)
            return jsonAdapter.fromJson(responseBody)
//            Log.d("tag", "response = ${response.body.toString()}")
//
//            val jsonAdapter = moshi.adapter(PokemonInfoResponse::class.java)
//            return jsonAdapter.fromJson(response.body?.string() ?: "")
        }
    }
}