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
//@AttributeOverride(name = "level", column = @Column(name = "level"))
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

    public Integer getHappiness() {
        return Happiness;
    }

    public void setHappiness(Integer happiness) {
        Happiness = happiness;
    }

    public Integer getFreeEV() {
        return freeEV;
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

    public String getCatcher() {
        return Catcher;
    }

    public void setCatcher(String catcher) {
        Catcher = catcher;
    }

    public Integer getExpirience() {
        return Expirience;
    }

    public void setExpirience(Integer expirience) {
        Expirience = expirience;
    }

    public Integer getTotalExpirience() {
        return totalExpirience;
    }

    public void setTotalExpirience(Integer totalExpirience) {
        this.totalExpirience = totalExpirience;
    }

    public Integer getExpToLvl() {
        return expToLvl;
    }

    public void setExpToLvl(Integer expToLvl) {
        this.expToLvl = expToLvl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
