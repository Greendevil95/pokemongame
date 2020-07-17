package pokemonGame.Repository;


import pokemonGame.Entity.Attacks.Attack;
import pokemonGame.Entity.Attacks.PokemonAttack;

import java.util.Optional;

public interface AttackRepository extends CommonRepository<Attack> {

    Optional<Attack> findByName(String attackName);


}
