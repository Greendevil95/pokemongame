package pokemonGame.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokemonGame.Entity.Attacks.Attack;
import pokemonGame.Entity.Attacks.PokemonAttack;
import pokemonGame.Entity.Battle;
import pokemonGame.Entity.Location;
import pokemonGame.Entity.Pokemon.AbstractPokemon;
import pokemonGame.Entity.Pokemon.Pokemon;
import pokemonGame.Entity.Pokemon.WildPokemon;
import pokemonGame.Enum.StatusCondition;
import pokemonGame.Repository.AttackRepository;
import pokemonGame.Repository.PokemonAttackRepository;
import pokemonGame.Repository.PokemonRepository;
import pokemonGame.Repository.WildPokemonRepository;

import java.util.Optional;

import static pokemonGame.Service.Formulas.randomValue;

@Service
public class BattleServiceImpl implements BattleService {

    int randomCount = 0;

    Battle battle = new Battle();

    final private AttackRepository attackRepository;

    final private PokemonRepository pokemonRepository;

    final private WildPokemonRepository wildPokemonRepository;

    final private PokemonAttackRepository pokemonAttackRepository;

    @Autowired
    public BattleServiceImpl(AttackRepository attackRepository, PokemonRepository pokemonRepository, WildPokemonRepository wildPokemonRepository, PokemonAttackRepository pokemonAttackRepository) {
        this.attackRepository = attackRepository;
        this.pokemonRepository = pokemonRepository;
        this.wildPokemonRepository = wildPokemonRepository;
        this.pokemonAttackRepository = pokemonAttackRepository;
    }

    @Override
    public Battle attack(String attackName, Battle battle) {
        int attackCount;
        int damage;
        Optional<Attack> attack = attackRepository.findByName(attackName);
        Optional<PokemonAttack> pokemonAttack = Optional.empty();
        Formulas formulas = new Formulas();
        if(attack.isPresent()) {
            pokemonAttack = pokemonAttackRepository.findById(attack.get().getId());
        }
        if(pokemonAttack.isPresent()){
            if(pokemonAttack.get().getCurrentPP() > 0)
                if(pokemonAttack.get().getAttack().getDamage() > 0) {
                    float critModif = formulas.getCrit(attack.get(), battle.getUsersPokemon(),battle.getEnemyPokemon());
                    if(attack.get().getDamage() > 0) {
                        attackCount = getAttackCount(attack.get());
                        damage = formulas.calculateDamage(attack.get(), battle.getUsersPokemon(), battle.getEnemyPokemon(), battle.getWeather(), critModif);
                    }
                    if(critModif > 1)
                        System.out.println("Критический удар!");
                }
        }
        return null;
    }

    public int getAttackCount(Attack attack){
        if(attack.getName().equals("Double Slap")) {
            int randomValue = randomValue(0, 100);
            if (randomValue <= 33.3F)
                return 2;
            else if (randomValue <= 66.6F)
                return  3;
            else if (randomValue <= 82.4)
                return  4;
            else return 5;
        } else return 1;
    }


    public   Battle setStatus(String attackName, Battle battle){
        int randomValue = randomValue(0, 100);
        switch (attackName) {
            case ("Thunder Punch"):
                //if (randomValue(0, 100) <= 10) {
                    battle.getEnemyPokemon().setStatusCondition(StatusCondition.PARALYSIS);
                    return battle;
                //}
            case ("Ice Punch"):
                if (randomValue <= 10) {
                    battle.getEnemyPokemon().setStatusCondition(StatusCondition.FREEZE);
                    return battle;
                }
            case ("Fire Punch"):
                if (randomValue <= 10) {
                    battle.getEnemyPokemon().setStatusCondition(StatusCondition.BURN);
                    return battle;
                }
        }


   return null;
    }

    private void isDeath(){
        randomCount = 0;

    }


    @Override
    public Battle startBattle(Pokemon userPokemon, AbstractPokemon abstractPokemon, Location location) {
        Battle battle = new Battle();
        battle.setUsersPokemon(userPokemon);
        battle.setWeather(location.getWeather());
        battle.setEnemyPokemon(abstractPokemon);
        return battle;
    }

    @Override
    public void escape() {

    }

    @Override
    public void useItem() {

    }

    @Override
    public void throwBall() {

    }
}
