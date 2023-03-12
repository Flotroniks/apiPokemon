package com.flotroniks.apipokemon.controller

import Pokemon
import PokemonListSingleton
import com.google.gson.Gson
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/pokemon")
class PokemonController {
    val gson = Gson()
    @GetMapping
    @ResponseBody
    fun hello(): List<Pokemon>
        = PokemonListSingleton.getData()

    @GetMapping("/limit/{limit}")
    @ResponseBody
    fun hello(@PathVariable limit:Long)
        = PokemonListSingleton.getData().subList(0,limit.toInt())



    @GetMapping("/{nameOrId}")
    @ResponseBody
    fun getByName(@PathVariable nameOrId: String?): Pokemon? {
        //check if it's a number
        val id = nameOrId?.toIntOrNull()
        return if (id != null) {
            PokemonListSingleton.getData().find {
                it.pokedexId == id
            }
        }else{
            PokemonListSingleton.getData().find {
                it.name.lowercase(Locale.getDefault()) == (nameOrId?.lowercase(Locale.getDefault()) ?: "")
            }
        }
    }

    @GetMapping("/generation/{generation}")
    fun getByGeneration(@PathVariable generation: Int?): String {
        return "You are in the Pokemon API with  /generation  = $generation"
    }

    @GetMapping("/type/{type}")
    fun getByType(@PathVariable type: String?): String {
        return "You are in the Pokemon API with  /type  = $type"
    }




}