package pokemonGame.Entity.Pokemon;

import pokemonGame.Entity.Items.Item;
import pokemonGame.Entity.Location;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Enum.StatusCondition;

import javax.persistence.*;
import java.util.List;

@Entity
public class WildPokemon extends AbstractPokemon {

    @Column
    private int maxLevel;

    @Column
    private int minLevel;

    @OneToOne
    private Item itemForCatching;

    @OneToMany
    private List<Item> drops;

    @ManyToOne
    private Location location;

    @Override
    public Integer getLevel() {
        if(super.getLevel() == null) {
            maxLevel -= minLevel;
            return (int) (Math.random() * ++maxLevel) + minLevel;
        }
        else return  super.getLevel();
    }


    public List<Item> getDrops() {
        return drops;
    }

    public void setDrops(List<Item> drops) {
        this.drops = drops;
    }

    public Item getItemForCatching() {
        return itemForCatching;
    }

    public void setItemForCatching(Item itemForCatching) {
        this.itemForCatching = itemForCatching;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
