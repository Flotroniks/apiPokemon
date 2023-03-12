package com.flotroniks.apipokemon.component

import Pokemon
import PokemonListSingleton
import com.google.gson.Gson
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.io.File

@Component
class PokemonDataLoader(

) : ApplicationRunner {
val gson = Gson()
    override fun run(args: ApplicationArguments?) {
        //read the json file
        val jsonFile = File("json/pokemons.json")
        val jsonString = jsonFile.readText()
        val pokemonList = gson.fromJson(jsonString, Array<Pokemon>::class.java).toList()
        PokemonListSingleton.setData(pokemonList)
    }
}