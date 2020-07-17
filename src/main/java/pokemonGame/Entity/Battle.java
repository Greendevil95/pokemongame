package pokemonGame.Entity;

import pokemonGame.Entity.Attacks.Attack;
import pokemonGame.Entity.Items.Item;
import pokemonGame.Entity.Pokemon.AbstractPokemon;
import pokemonGame.Entity.Pokemon.Pokemon;
import pokemonGame.Entity.Pokemon.WildPokemon;
import pokemonGame.Entity.User.User;
import pokemonGame.Enum.EntryHazard;
import pokemonGame.Enum.Weather;
import pokemonGame.Service.Formulas;

public class Battle {

    private int Stage = 1;

    private Weather weather;

    private EntryHazard entryHazard;

    private Pokemon usersPokemon;

    private AbstractPokemon enemyPokemon;

    public int getStage() {
        return Stage;
    }

    public void setStage(int stage) {
        Stage = stage;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    private Battle(Weather weather) {
        this.weather = weather;
    }

    public Battle(){
        this(Weather.CLEARSKY);
    }

    public EntryHazard getEntryHazard() {
        return entryHazard;
    }

    public void setEntryHazard(EntryHazard entryHazard) {
        this.entryHazard = entryHazard;
    }

    public Pokemon getUsersPokemon() {
        return usersPokemon;
    }

    public void setUsersPokemon(Pokemon usersPokemon) {
        this.usersPokemon = usersPokemon;
    }

    public AbstractPokemon getEnemyPokemon() {
        return enemyPokemon;
    }

    public void setEnemyPokemon(AbstractPokemon enemyPokemon) {
        this.enemyPokemon = enemyPokemon;
    }
}
