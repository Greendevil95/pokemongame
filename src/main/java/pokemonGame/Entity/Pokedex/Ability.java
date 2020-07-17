package pokemonGame.Entity.Pokedex;

import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Entity.Pokemon.Pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ability extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String discription;

    @Column
    private String ruDiscription;

    @Column
    private int generation;

    @ManyToMany(mappedBy = "abilities")
    private List<PokemonInDex> pokemonInDexList;

    @ManyToOne
    @JoinColumn(name = "ability_id")
    private Pokemon pokemon;

    /*@JsonIgnore
    @OneToMany(mappedBy = "ability")
    private List<Pokemon> pokemonList;*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}
