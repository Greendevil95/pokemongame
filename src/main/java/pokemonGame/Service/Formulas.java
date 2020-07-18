package pokemonGame.Service;

import pokemonGame.Entity.Battle;
import pokemonGame.Entity.Game;
import pokemonGame.Entity.Items.Item;
import pokemonGame.Entity.Attacks.Attack;
import pokemonGame.Entity.Location;
import pokemonGame.Entity.Pokedex.PokemonForm;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Entity.Pokemon.AbstractPokemon;
import pokemonGame.Entity.Pokemon.Pokemon;
import pokemonGame.Entity.Pokemon.WildPokemon;
import pokemonGame.Entity.User.User;
import pokemonGame.Entity.UserDex;
import pokemonGame.Enum.*;

import java.util.Random;

public class Formulas {

    int psevdRandCount = 0;

    public int statCalculating(int base, int IV, int EV, int level, int nature) {
        return ((((2 * base + IV + (EV / 4)) * level) / 100) + 5) * nature;
    }

    public int hpCalculating(int base, int IV, int EV, int level) {
        return ((((2 * base + IV + (EV / 4)) * level) / 100) + level + 10);
    }

    public int calculateExpToLvl(int expGroup, int lvl) {
        switch (expGroup) {
            case (1):
                if (lvl <= 50) {
                    return ((int) Math.pow(lvl, 3) * (100 - lvl)) / 50;
                } else if (lvl <= 68) {
                    return ((int) Math.pow(lvl, 3) * (150 - lvl)) / 100;
                } else if (lvl <= 98) {
                    return ((int) Math.pow(lvl, 3) * ((1911 - 10 * lvl) / 3)) / 500;
                } else
                    return ((int) Math.pow(lvl, 3) * (160 - lvl)) / 100;
            case (2):
                return (int) (4 * Math.pow(lvl, 3)) / 5;
            case (3):
                return (int) Math.pow(lvl, 3);
            case (4):
                return (int) (((1.2) * Math.pow(lvl, 3)) - (15 * Math.pow(lvl, 2)) + (100 * lvl) - 140);
            case (5):
                return (int) (5 * Math.pow(lvl, 3)) / 4;
        }
        return 0;
    }

    public int calculateDamage(Attack attack, Pokemon pokemon, AbstractPokemon enemyPokemon, Weather weather, float critModif) {

        Random random = new Random();
        double min = 0.85;
        double max = 1;
        double randomValue = min + (max - min) * random.nextDouble();

        int pokemonAttack;
        int pokemonDefence;

        if (attack.getAttackType() == AttackType.PHYSICAL) {
            pokemonAttack = pokemon.getStats().getAttack() * getStatModif(pokemon.getStats().getAttackStatus());
            pokemonDefence = enemyPokemon.getStats().getDefense() * getStatModif(pokemon.getStats().getDefenseStatus());
        } else {
            pokemonAttack = pokemon.getStats().getSpecAttack() * getStatModif(pokemon.getStats().getSpecAttackStatus());
            pokemonDefence = enemyPokemon.getStats().getSpecDefence() * getStatModif(pokemon.getStats().getSpecDefenceStatus());
        }


        double modifier = (int) Math.floor(getWatherModif(weather, attack) * randomValue * critModif * getStabModif(attack, pokemon) * getBurnModif(pokemon, attack)) * getTypeModif(attack, pokemon) * getOtherModif(attack, pokemon);

        return (int) Math.floor((((((((float) 2 * pokemon.getLevel()) / 5) + 2) * attack.getDamage() * pokemonAttack / pokemonDefence) / 50) + 2) * modifier);
    }

    public int getAccuracyModif(int modif){
        switch (modif) {
            case -6:
                return 3 / 9;
            case -5:
                return 3 / 8;
            case -4:
                return 3 / 7;
            case -3:
                return 3 / 6;
            case -2:
                return 3 / 5;
            case -1:
                return 3 / 4;
            case 1:
                return 4 / 3;
            case 2:
                return 5 / 3;
            case 3:
                return 6 / 3;
            case 4:
                return 7 / 3;
            case 5:
                return 8 / 3;
            case 6:
                return 9 / 3;
            default:
                return 1;
        }
    }

    public int getEvasionModif(int modif){
        switch (modif) {
            case 6:
                return 3 / 9;
            case 5:
                return 3 / 8;
            case 4:
                return 3 / 7;
            case 3:
                return 3 / 6;
            case 2:
                return 3 / 5;
            case 1:
                return 3 / 4;
            case -1:
                return 4 / 3;
            case -2:
                return 5 / 3;
            case -3:
                return 6 / 3;
            case -4:
                return 7 / 3;
            case- 5:
                return 8 / 3;
            case -6:
                return 9 / 3;
            default:
                return 1;
        }
    }



    private int getStatModif(int modifValue) {
        switch (modifValue) {
            case -6:
                return 2 / 8;
            case -5:
                return 2 / 7;
            case -4:
                return 2 / 6;
            case -3:
                return 2 / 5;
            case -2:
                return 2 / 4;
            case -1:
                return 2 / 3;
            case 1:
                return 3 / 2;
            case 2:
                return 4 / 2;
            case 3:
                return 5 / 2;
            case 4:
                return 6 / 2;
            case 5:
                return 7 / 2;
            case 6:
                return 8 / 2;
            default:
                return 1;
        }
    }

    private double getBurnModif(Pokemon pokemon, Attack attack) {
        if (pokemon.getStatusCondition().equals(StatusCondition.BURN) && attack.getAttackType().equals(AttackType.PHYSICAL)) {
            if (pokemon.getAbility().getName().equals("guts"))
                return 1.5;
            else return 0.5;
        } else return 1.0;

    }

    private float getOtherModif(Attack attack, Pokemon pokemon) {

        return getOtherModForAbility() * getOtherModForAttack(attack) * getOtherModForItem();
    }

    private float getOtherModForAttack(Attack attack) {
        //if (attack.getName().equals())
        return 1;
    }

    private float getOtherModForAbility() {
        return 1;
    }

    private float getOtherModForItem() {
        return 1;
    }

    private float getStabModif(Attack attack, Pokemon pokemon) {
        if (attack.getType().equals(pokemon.getPokemonInDex().getTypeOne()) || attack.getType().equals(pokemon.getPokemonInDex().getTypeTwo())) {
            if (pokemon.getAbility().getName().equals("adapability"))
                return 2.0F;
            else return 1.5F;
        } else return 1.0F;
    }

    private double getTypeModif(Attack attack, Pokemon pokemon) {
        return (pokemon.getPokemonInDex().getTypeTwo() != null) ? (getTypeMod(attack.getType(), pokemon.getPokemonInDex().getTypeOne()) * getTypeMod(attack.getType(), pokemon.getPokemonInDex().getTypeTwo())) : getTypeMod(attack.getType(), pokemon.getPokemonInDex().getTypeOne());
    }

    private double getTypeMod(Type pokemonType, Type attackType) {
        switch (attackType) {
            case NORMAL:
                if (pokemonType == Type.GHOST)
                    return 0;
                else if (pokemonType == Type.ROCK || pokemonType == Type.STEEL)
                    return 0.5;
                else return 1.0;
            case FIRE:
                if (pokemonType == Type.WATER || pokemonType == Type.FIRE || pokemonType == Type.ROCK || pokemonType == Type.DRAGON)
                    return 0.5;
                else if (pokemonType == Type.BUG || pokemonType == Type.GRASS || pokemonType == Type.STEEL || pokemonType == Type.ICE)
                    return 2.0;
                else return 1.0;
            case WATER:
                if (pokemonType == Type.WATER || pokemonType == Type.GRASS || pokemonType == Type.DRAGON)
                    return 0.5;
                else if (pokemonType == Type.FIRE || pokemonType == Type.ROCK || pokemonType == Type.GROUND)
                    return 2.0;
                else return 1.0;
            case GROUND:
                if (pokemonType == Type.FLYING)
                    return 0;
                else if (pokemonType == Type.GRASS || pokemonType == Type.BUG)
                    return 0.5;
                else if (pokemonType == Type.FIRE || pokemonType == Type.ELECTRIC || pokemonType == Type.POISON || pokemonType == Type.ROCK || pokemonType == Type.STEEL)
                    return 2.0;
                else return 1.0;
            case GHOST:
                if (pokemonType == Type.NORMAL)
                    return 0;
                else if (pokemonType == Type.DARK)
                    return 0.5;
                else if (pokemonType == Type.PSYCHIC || pokemonType == Type.GHOST)
                    return 2.0;
                else return 1.0;
            case ICE:
                if (pokemonType == Type.WATER || pokemonType == Type.FIRE || pokemonType == Type.ICE || pokemonType == Type.STEEL)
                    return 0.5;
                else if (pokemonType == Type.DRAGON || pokemonType == Type.GRASS || pokemonType == Type.FLYING || pokemonType == Type.GROUND)
                    return 2.0;
                else return 1.0;
            case STEEL:
                if (pokemonType == Type.FIRE || pokemonType == Type.WATER || pokemonType == Type.ELECTRIC || pokemonType == Type.STEEL)
                    return 0.5;
                else if (pokemonType == Type.ICE || pokemonType == Type.ROCK || pokemonType == Type.FAIRY)
                    return 2;
                else return 1.0;
            case FIGHTING:
                if (pokemonType == Type.GHOST)
                    return 0;
                else if (pokemonType == Type.POISON || pokemonType == Type.PSYCHIC || pokemonType == Type.BUG || pokemonType == Type.FLYING || pokemonType == Type.FAIRY)
                    return 0.5;
                else if (pokemonType == Type.STEEL || pokemonType == Type.NORMAL || pokemonType == Type.ROCK || pokemonType == Type.DARK || pokemonType == Type.ICE)
                    return 2.0;
                else return 1.0;
            case DRAGON:
                if (pokemonType == Type.FAIRY)
                    return 0;
                else if (pokemonType == Type.STEEL)
                    return 0.5;
                else if (pokemonType == Type.DRAGON)
                    return 2.0;
                else return 1.0;
            case FLYING:
                if (pokemonType == Type.ROCK || pokemonType == Type.ELECTRIC || pokemonType == Type.STEEL)
                    return 0.5;
                else if (pokemonType == Type.BUG || pokemonType == Type.GRASS || pokemonType == Type.FIGHTING)
                    return 2.0;
                else return 1.0;
            case POISON:
                if (pokemonType == Type.STEEL)
                    return 0;
                else if (pokemonType == Type.POISON || pokemonType == Type.GROUND || pokemonType == Type.GHOST || pokemonType == Type.ROCK)
                    return 0.5;
                else if (pokemonType == Type.GRASS || pokemonType == Type.FAIRY)
                    return 2.0;
                else return 1.0;
            case ROCK:
                if (pokemonType == Type.GROUND || pokemonType == Type.FIGHTING || pokemonType == Type.STEEL)
                    return 0.5;
                else if (pokemonType == Type.FLYING || pokemonType == Type.ICE || pokemonType == Type.BUG || pokemonType == Type.FIRE)
                    return 2.0;
                else return 1.0;
            case BUG:
                if (pokemonType == Type.POISON || pokemonType == Type.FIGHTING || pokemonType == Type.STEEL || pokemonType == Type.FLYING || pokemonType == Type.FIRE || pokemonType == Type.GHOST || pokemonType == Type.FAIRY)
                    return 0.5;
                else if (pokemonType == Type.PSYCHIC || pokemonType == Type.GRASS || pokemonType == Type.DARK)
                    return 2.0;
                else return 1.0;
            case GRASS:
                if (pokemonType == Type.GRASS || pokemonType == Type.FIRE || pokemonType == Type.POISON || pokemonType == Type.DRAGON || pokemonType == Type.FLYING || pokemonType == Type.STEEL || pokemonType == Type.BUG)
                    return 0.5;
                else if (pokemonType == Type.WATER || pokemonType == Type.ROCK || pokemonType == Type.GROUND)
                    return 2.0;
                else return 1.0;
            case ELECTRIC:
                if (pokemonType == Type.GROUND)
                    return 0;
                else if (pokemonType == Type.ELECTRIC || pokemonType == Type.GRASS || pokemonType == Type.DRAGON)
                    return 0.5;
                else if (pokemonType == Type.WATER || pokemonType == Type.FLYING)
                    return 2.0;
                else return 1.0;
            case PSYCHIC:
                if (pokemonType == Type.DARK)
                    return 0;
                else if (pokemonType == Type.STEEL || pokemonType == Type.PSYCHIC)
                    return 0.5;
                else if (pokemonType == Type.POISON || pokemonType == Type.FIGHTING)
                    return 2.0;
                else return 1.0;
            case DARK:
                if (pokemonType == Type.FIGHTING || pokemonType == Type.DARK || pokemonType == Type.FAIRY)
                    return 0.5;
                else if (pokemonType == Type.PSYCHIC || pokemonType == Type.GHOST)
                    return 2;
                else return 1.0;
            case FAIRY:
                if (pokemonType == Type.FIRE || pokemonType == Type.POISON || pokemonType == Type.STEEL)
                    return 0.5;
                else if (pokemonType == Type.FIGHTING || pokemonType == Type.DRAGON || pokemonType == Type.DARK)
                    return 2;
                else return 1.0;
            default:
                return 1;
        }
    }

    private double getWatherModif(Weather weather, Attack attack) {
        double weatherModif;
        if ((weather == Weather.RAIN && attack.getType() == Type.WATER) || (weather == Weather.SUNNY && attack.getType() == Type.FIRE))
            weatherModif = 1.5;
        else if ((weather == Weather.RAIN && attack.getType() == Type.FIRE) || (weather == Weather.SUNNY && attack.getType() == Type.WATER))
            weatherModif = 0.5;
        else weatherModif = 1;

        return weatherModif;
    }

    private int getCritChanceForAttack(Attack attack) {
        if (attack.getName().equals("Aeroblast") || attack.getName().equals("Air Cutter") || attack.getName().equals("Razor Leaf") || attack.getName().equals("Attack Order") || attack.getName().equals("Blaze Kick")
                || attack.getName().equals("Crabhammer") || attack.getName().equals("Cross Chop") || attack.getName().equals("Cross Poison") || attack.getName().equals("Drill Run") || attack.getName().equals("Karate Chop")
                || attack.getName().equals("Leaf Blade") || attack.getName().equals("Night Slash") || attack.getName().equals("Poison Tail") || attack.getName().equals("Psycho Cut") || attack.getName().equals("Razor Wind")
                || attack.getName().equals("Shadow Blast") || attack.getName().equals("Shadow Claw") || attack.getName().equals("Sky Attack") || attack.getName().equals("Slash") || attack.getName().equals("Snipe Shot")
                || attack.getName().equals("Spacial Rend") || attack.getName().equals("Stone Edge"))
            return 1;
        else if (attack.getName().equals("10,000,000 Volt Thunderbol") || attack.getName().equals("Focus Energy"))
            return 2;
        else if (attack.getName().equals("Wicked Blow") || attack.getName().equals("Surging Strikes") || attack.getName().equals("Storm Throw") || attack.getName().equals("Frost Breath") || attack.getName().equals("Zippy Zap"))
            return 3;
        else return 0;
    }

    private int getCritForItemOrAbility(Pokemon pokemon, AbstractPokemon emptyPokemon) {
        if (pokemon.getAbility().getName().equals("merciless") || emptyPokemon.getStatusCondition().equals(StatusCondition.POISON))
            return 3;
        if (pokemon.getAbility().getName().equals("Super Luck")) {
            if (pokemon.getItem().getName().equals("Razor Claw") || pokemon.getItem().getName().equals("Scope Lens"))
                return 2;
            else return 1;
        } else return 0;
    }

    public float getCrit(Attack attack, Pokemon pokemon, AbstractPokemon emptyPokemon) {
        int critStage = getCritChanceForAttack(attack) + getCritForItemOrAbility(pokemon, emptyPokemon);
        float critChance;
        float randomValue = new Random().nextFloat();
        if (critStage == 0)
            critChance = 1 / 16.0F;
        else if (critStage == 1)
            critChance = 1 / 8.0F;
        else if (critStage == 2)
            critChance = 1 / 2.0F;
        else if (critStage >= 3)
            critChance = 1;
        else critChance = 1 / 16.0F;
        if (critChance >= randomValue) {
            if (pokemon.getAbility().getName().equals("sniper"))
                return 2.25F;
            else return 1.5F;
        } else return 1;

    }


    public boolean isCatch(WildPokemon wildPokemon, Pokemon userPokemon, Item pokeball, Battle battle, User user, int psevdRandCount) {

        int catchRate = wildPokemon.getPokemonInDex().getCatchRate();

        if (pokeball.getName().equals("Heavy Ball")) {
            if (wildPokemon.getPokemonInDex().getWeght() < 100)
                catchRate -= 20;
            else if (wildPokemon.getPokemonInDex().getWeght() >= 200 && wildPokemon.getPokemonInDex().getWeght() < 300)
                catchRate += 20;
            else if (wildPokemon.getPokemonInDex().getWeght() >= 300)
                catchRate += 30;
        }

        if (catchRate < 0)
            catchRate = 1;

        int randomValue = randomValue(0, 255);

        //int catchRateModif = (int) ((catchRate * getBallRate(pokeball, wildPokemon, userPokemon, battle, user) * getStatusModif(wildPokemon)) * (wildPokemon.getHP() / wildPokemon.getCurrentHP())) / 255;

        int catchRateModif = (int) ((((3 * wildPokemon.getStats().getHP() - 2 * wildPokemon.getStats().getCurrentHP()) * catchRate * getBallRate(pokeball, wildPokemon, userPokemon, battle, user)) / (3 * wildPokemon.getStats().getHP())) * getStatusModif(wildPokemon)) + psevdRandCount;

        System.out.println("catchRate = " + catchRateModif);
        System.out.println(randomValue);
        System.out.println("count = " + psevdRandCount);
        System.out.println("stage = " + battle.getStage());
        return catchRateModif >= randomValue;
    }

    private float getBallRate(Item pokeball, WildPokemon wildPokemon, Pokemon userPokemon, Battle battle, User user) {
        if (pokeball.getItemType().equals(ItemType.POKEBALL)) {
            switch (pokeball.getName()) {
                case ("Poke Ball"):
                case ("Heavy Ball"):
                case ("Luxury Ball"):
                case ("Premier Ball"):
                    return 1;
                case ("Great Ball"):
                case ("Safari Ball"):
                    return 1.5F;
                case ("Ultra Ball"):
                    return 3;
                case ("Master Ball"):
                    return 255;
                case ("Fast Ball"):
                    if (wildPokemon.getStats().getSpeed() > 100)
                        return 4;
                    else return 1;
                case ("Level Ball"):
                    if (userPokemon.getLevel() <= wildPokemon.getLevel())
                        return 1;
                    else if (userPokemon.getLevel() < wildPokemon.getLevel() * 2)
                        return 2;
                    else if (userPokemon.getLevel() < wildPokemon.getLevel() * 4)
                        return 4;
                    else if (userPokemon.getLevel() >= wildPokemon.getLevel() * 4)
                        return 8;
                case ("Lure Ball"):
                    if (wildPokemon.getItemForCatching().getName().equals("Old Rod") || wildPokemon.getItemForCatching().getName().equals("Good Rod") || wildPokemon.getItemForCatching().getName().equals("Super Rod"))
                        return 5;
                    else return 1;
                case ("Friend Ball"): //add 200 friendship
                    return 1;
                case ("Moon Ball"):
                    for (PokemonForm pokemonForm : wildPokemon.getPokemonInDex().getPokemonForms()) {
                        if (pokemonForm.getEvolutionItem().getName().equals("Moon Stone"))
                            return 4;
                    }
                    return 1;
                case ("Net Ball"):
                    if (wildPokemon.getPokemonInDex().getTypeList().contains(Type.WATER) || wildPokemon.getPokemonInDex().getTypeList().contains(Type.BUG))
                        return 3.5F;
                    else return 1;
                case ("Nest Ball"):
                    if (wildPokemon.getLevel() < 30)
                        return (41 - wildPokemon.getLevel()) / 10;
                    else return 1;
                case ("Timer Ball"):
                    if (battle.getStage() >= 10)
                        return 4;
                    else return 1 + battle.getStage() * 0.3F;
                case ("Repeat Ball"):
                    for (UserDex userDex : user.getUserDex()) {
                        if (userDex.getPokemonInDex().equals(wildPokemon.getPokemonInDex()))
                            return 3.5f;
                    }
                    return 1;
                case ("Dive Ball"):
                    if (wildPokemon.getLocation().getLocationType().equals(LocationType.WATER) || wildPokemon.getItemForCatching().getName().equals("Old Rod") || wildPokemon.getItemForCatching().getName().equals("Good Rod") || wildPokemon.getItemForCatching().getName().equals("Super Rod"))
                        return 3.5F;
                    else return 1;
                case ("Dusk Ball"):
                    if (wildPokemon.getLocation().getLocationType().equals(LocationType.CAVE) || Game.getTimesOfDay().equals(TimesOfDay.NIGHT))
                        return 3.5F;
                    else return 1;
                case ("Quick Ball"):
                    if (battle.getStage() == 1)
                        return 5;
                    else return 1;

            }
        } else throw new IllegalArgumentException("Selected item is not a ball");
        return 0;
    }

    private float getStatusModif(WildPokemon wildPokemon) {
        if (wildPokemon.getStatusCondition() == null)
            return 1;
        if (wildPokemon.getStatusCondition().equals(StatusCondition.POISON) || wildPokemon.getStatusCondition().equals(StatusCondition.BADLYPOISONED) || wildPokemon.getStatusCondition().equals(StatusCondition.BURN) || wildPokemon.getStatusCondition().equals(StatusCondition.PARALYSIS))
            return 1.5F;
        else if (wildPokemon.getStatusCondition().equals(StatusCondition.FREEZE) || wildPokemon.getStatusCondition().equals(StatusCondition.SLEEP))
            return 2;
        else return 1;
    }

    public int getCatchChance() {
        return 1;
    }

    public static int randomValue(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public int calculateExpForWildPokemon(boolean luckyEgg, int lvl, int baseExp, boolean isInBattle,
                                          int happiness) {
        double happy;
        int s;
        double luckyEggExp;

        if (luckyEgg) luckyEggExp = 1.5;
        else luckyEggExp = 1;

        if (happiness > 127)
            happy = 1.4;
        else happy = 1;

        if (isInBattle)
            s = 1;
        else s = 2;

        return (int) (lvl * baseExp * happy * luckyEggExp) / (s * 7);

    }


}
