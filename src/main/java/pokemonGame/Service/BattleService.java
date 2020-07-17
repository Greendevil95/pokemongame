package pokemonGame.Service;

import pokemonGame.Entity.Battle;
import pokemonGame.Entity.Location;
import pokemonGame.Entity.Pokemon.AbstractPokemon;
import pokemonGame.Entity.Pokemon.Pokemon;

public interface BattleService {

    Battle attack(String attackName, Battle battle);

    Battle startBattle(Pokemon userPokemon, AbstractPokemon abstractPokemon, Location location);

    void escape();

    void useItem();

    void throwBall();


}
