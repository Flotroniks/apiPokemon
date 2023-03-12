object PokemonListSingleton {
    private var myData = listOf<Pokemon>()

    fun setData(data : List<Pokemon>) {
        myData = data
    }

    fun getData() : List<Pokemon> {
        return myData
    }
}
