package pokemonGame.Repository;

import pokemonGame.Entity.Pokedex.PokemonInDex;

public interface PokemonInDexRepository extends CommonRepository<PokemonInDex> {

    PokemonInDex findFirstByNumber(Integer number);
}
