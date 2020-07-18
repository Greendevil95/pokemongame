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
import pokemonGame.Enum.VolatileBattleStatus;
import pokemonGame.Enum.VolatileStatus;
import pokemonGame.Repository.AttackRepository;
import pokemonGame.Repository.PokemonAttackRepository;
import pokemonGame.Repository.PokemonRepository;
import pokemonGame.Repository.WildPokemonRepository;

import java.util.Optional;

import static pokemonGame.Service.Formulas.*;

@Service
public class BattleServiceImpl implements BattleService {

    int randomCount = 0;

    private Battle battle = new Battle();

    private Formulas formulas = new Formulas();

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
        if(pokemonAttack.isPresent()) {
            if (pokemonAttack.get().getCurrentPP() > 0) {
                if (pokemonAttack.get().getAttack().getDamage() > 0) {
                    if (isHitTarget(attack.get(), battle)) {
                        float critModif = formulas.getCrit(attack.get(), battle.getUsersPokemon(), battle.getEnemyPokemon());
                        if (attack.get().getDamage() > 0) {
                            attackCount = getAttackCount(attack.get());
                            damage = formulas.calculateDamage(attack.get(), battle.getUsersPokemon(), battle.getEnemyPokemon(), battle.getWeather(), critModif);
                            if (attackCount == 1)
                                doDamage(damage, battle);
                            else for (int i = 0; i < attackCount; i++)
                                doDamage(damage, battle);
                            if (critModif > 1)
                                System.out.println("Критический удар!");
                        } else doDamage(calcDamageForOtherAttack(attack.get(), battle), battle);
                    } else System.out.println("Attack missed");
                }
            } else System.out.println("Недостаточно PP для использоваие атаки");
        } else System.out.println("Данной атаки не существует");
        return null;
    }

    private void doDamage(int damage, Battle battle){
        //if(isHitTarget())
            battle.getEnemyPokemon().getStats().setCurrentHP(battle.getEnemyPokemon().getStats().getCurrentHP() - damage);
       // else System.out.println("Attack missed");
    }

    private boolean isHitTarget(Attack attack, Battle battle){
        if(attack.getName().equals("Swift") || attack.getName().equals("Bide")) {
            return !battle.getEnemyPokemon().getVolatileBattleStatusSet().contains(VolatileBattleStatus.SEMIINVULNERABLE);
        }
                int hitChance = (int) (attack.getAccuracy() * formulas.getAccuracyModif(battle.getUsersPokemon().getStats().getAccuracyStatus()) * formulas.getEvasionModif(battle.getEnemyPokemon().getStats().getEvasionStatus()) * calcOtherModif(battle));
                if (hitChance < 30)
                    hitChance = 30;
        return randomValue(0,100) <= hitChance;
    }

    private float calcOtherModif(Battle battle){

        return 1;
    }

    private int calcDamageForOtherAttack(Attack attack, Battle battle){
        switch(attack.getName()) {
            case "Guillotine":
                int acc = ((battle.getUsersPokemon().getLevel() - battle.getEnemyPokemon().getLevel()) + 30);
                attack.setAccuracy(acc);
                return battle.getEnemyPokemon().getStats().getHP();
            case "Swords Dance":
                battle.getUsersPokemon().getStats().increaseAttack(2);
            case "Minimize":
                battle.getUsersPokemon().getStats().increaseEvasion(2);
                battle.getUsersPokemon().getVolatileBattleStatusSet().add(VolatileBattleStatus.MINIMIZE);
            case "Sand Attack":
                battle.getEnemyPokemon().getStats().decreaseAccurasy(1);

        }
        return 1;
    }

    public int getAttackCount(Attack attack){
        if(attack.getName().equals("Double Kick"))
            return 2;
        if(attack.getName().equals("Double Slap") || attack.getName().equals("Comet Punch")) {
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
        if (randomValue <= 10) {
            switch (attackName) {
                case "Thunder Punch":
                    battle.getEnemyPokemon().setStatusCondition(StatusCondition.PARALYSIS);
                    return battle;
                case "Ice Punch":
                        battle.getEnemyPokemon().setStatusCondition(StatusCondition.FREEZE);
                        return battle;
                case "Fire Punch":
                        battle.getEnemyPokemon().setStatusCondition(StatusCondition.BURN);
                        return battle;
            }
        }

        if(randomValue <= 30){
            switch (attackName) {
                case "Stomp":
                case "Headbutt":
                case "Rolling Kick":
                    battle.getEnemyPokemon().getVolatileStatusSet().add(VolatileStatus.FLINCH);
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
