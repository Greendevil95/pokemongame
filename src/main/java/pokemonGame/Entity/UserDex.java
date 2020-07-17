package pokemonGame.Entity;

import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Entity.User.User;
import pokemonGame.Enum.DexSeenStat;

import javax.persistence.*;

@Entity
public class UserDex extends AbstractEntity {

    @ManyToOne
    private User user;

    @OneToOne
    private PokemonInDex pokemonInDex;

    @Enumerated(value = EnumType.STRING)
    private DexSeenStat dexSeenStat;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PokemonInDex getPokemonInDex() {
        return pokemonInDex;
    }

    public void setPokemonInDex(PokemonInDex pokemonInDex) {
        this.pokemonInDex = pokemonInDex;
    }

    public DexSeenStat getDexSeenStat() {
        return dexSeenStat;
    }

    public void setDexSeenStat(DexSeenStat dexSeenStat) {
        this.dexSeenStat = dexSeenStat;
    }
}
