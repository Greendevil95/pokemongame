package pokemonGame.Repository;

import org.springframework.stereotype.Repository;
import pokemonGame.Entity.Pokemon.Pokemon;

@Repository
public interface PokemonRepository extends CommonRepository<Pokemon> {

}
