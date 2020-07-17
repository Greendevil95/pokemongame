package pokemonGame.Entity.Attacks;

import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Pokemon.Pokemon;

import javax.persistence.*;

@Entity
public class PokemonAttack extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attack_id")
    private Attack attack;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @Column
    private boolean isActive;

    @Column(name = "general_PP")
    private int generalPP;

    @Column(name = "current_PP")
    private int currentPP;

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getGeneralPP() {
        return generalPP;
    }

    public void setGeneralPP(int generalPP) {
        this.generalPP = generalPP;
    }

    public int getCurrentPP() {
        return currentPP;
    }

    public void setCurrentPP(int currentPP) {
        this.currentPP = currentPP;
    }
}
