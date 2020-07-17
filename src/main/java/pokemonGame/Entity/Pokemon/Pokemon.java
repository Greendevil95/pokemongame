package pokemonGame.Entity.Pokemon;

import pokemonGame.Entity.Attacks.PokemonAttack;
import pokemonGame.Entity.Items.Item;
import pokemonGame.Entity.Nature;
import pokemonGame.Entity.Pokedex.Ability;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Entity.User.User;
import pokemonGame.Enum.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokemon")
public class Pokemon extends AbstractPokemon {


    @Column
    private  Integer Happiness;

    @Column
    private Integer freeEV;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemon")
    private List<PokemonAttack> reserveAttackMoves;

    @Column
    private String Catcher;

    @Column
    private Integer Expirience;

    @Column
    private Integer totalExpirience;

    @Column
    private Integer expToLvl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private boolean isTradable = true;

    @Column
    private boolean breedable = false;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Item ball;

    public Pokemon() {
    }


    public int getHappiness() {
        return Happiness;
    }

    public void setHappiness(int happiness) {
        Happiness = happiness;
    }


    public int getFreeEV() {
        return freeEV;
    }

    public void setFreeEV(int freeEV) {
        this.freeEV = freeEV;
    }

    public String getCatcher() {
        return Catcher;
    }

    public void setCatcher(String catcher) {
        Catcher = catcher;
    }

    public int getExpirience() {
        return Expirience;
    }

    public void setExpirience(int expirience) {
        Expirience = expirience;
    }

    public int getTotalExpirience() {
        return totalExpirience;
    }

    public void setTotalExpirience(int totalExpirience) {
        this.totalExpirience = totalExpirience;
    }

    public int getExpToLvl() {
        return expToLvl;
    }

    public void setExpToLvl(int expToLvl) {
        this.expToLvl = expToLvl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setHappiness(Integer happiness) {
        Happiness = happiness;
    }

    public void setFreeEV(Integer freeEV) {
        this.freeEV = freeEV;
    }

    public List<PokemonAttack> getReserveAttackMoves() {
        return reserveAttackMoves;
    }

    public void setReserveAttackMoves(List<PokemonAttack> reserveAttackMoves) {
        this.reserveAttackMoves = reserveAttackMoves;
    }

    public void setExpirience(Integer expirience) {
        Expirience = expirience;
    }

    public void setTotalExpirience(Integer totalExpirience) {
        this.totalExpirience = totalExpirience;
    }

    public void setExpToLvl(Integer expToLvl) {
        this.expToLvl = expToLvl;
    }

    public boolean isTradable() {
        return isTradable;
    }

    public void setTradable(boolean tradable) {
        isTradable = tradable;
    }

    public boolean isBreedable() {
        return breedable;
    }

    public void setBreedable(boolean breedable) {
        this.breedable = breedable;
    }

    public Item getBall() {
        return ball;
    }

    public void setBall(Item ball) {
        this.ball = ball;
    }
}
