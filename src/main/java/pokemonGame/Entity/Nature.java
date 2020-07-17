package pokemonGame.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pokemonGame.Entity.Pokemon.Pokemon;
import pokemonGame.Enum.Stats;

import javax.persistence.*;
import java.util.List;

@Entity
public class Nature extends AbstractEntity {

    @Column
    private String name;

    @Enumerated
    private Stats increaseStat;

    @Enumerated
    private Stats decreaseStat;

    @JsonIgnore
    @OneToMany(mappedBy = "nature", cascade = CascadeType.ALL)
    private List<Pokemon> pokemon;

    public Nature(String name, Stats increaseStat, Stats decreaseStat) {
        this.name = name;
        this.increaseStat = increaseStat;
        this.decreaseStat = decreaseStat;
    }
}
