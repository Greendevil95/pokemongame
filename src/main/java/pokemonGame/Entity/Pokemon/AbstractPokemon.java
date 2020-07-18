package pokemonGame.Entity.Pokemon;

import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Attacks.PokemonAttack;
import pokemonGame.Entity.Items.Item;
import pokemonGame.Entity.Nature;
import pokemonGame.Entity.Pokedex.Ability;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Enum.Gender;
import pokemonGame.Enum.StatusCondition;
import pokemonGame.Enum.VolatileBattleStatus;
import pokemonGame.Enum.VolatileStatus;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@MappedSuperclass
public abstract class AbstractPokemon extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokemon_in_dex_id")
    private PokemonInDex pokemonInDex;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ability_id")
    private Ability ability;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private StatusCondition statusCondition;

    @Column
    private String name;

    @Embedded
    private Stats stats;

    @Column
    //@Transient
    private Integer level;

    @Column
    private String IVCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemon")
    private List<PokemonAttack> attackMoves;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nature_id")
    private Nature nature;

    @Column
    private boolean shiny;

    @ElementCollection(targetClass = VolatileStatus.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "volatile_status", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Enumerated(EnumType.STRING)
    private Set<VolatileStatus> volatileStatusSet;

    @ElementCollection(targetClass = VolatileBattleStatus.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "volatile_battle_status", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Enumerated(EnumType.STRING)
    private Set<VolatileBattleStatus> volatileBattleStatusSet;

    public PokemonInDex getPokemonInDex() {
        return pokemonInDex;
    }

    public void setPokemonInDex(PokemonInDex pokemonInDex) {
        this.pokemonInDex = pokemonInDex;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public StatusCondition getStatusCondition() {
        return statusCondition;
    }

    public void setStatusCondition(StatusCondition statusCondition) {
        this.statusCondition = statusCondition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIVCode() {
        return IVCode;
    }

    public void setIVCode(String IVCode) {
        this.IVCode = IVCode;
    }

    public List<PokemonAttack> getAttackMoves() {
        return attackMoves;
    }

    public void setAttackMoves(List<PokemonAttack> attackMoves) {
        this.attackMoves = attackMoves;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public boolean isShiny() {
        return shiny;
    }

    public void setShiny(boolean shiny) {
        this.shiny = shiny;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Set<VolatileStatus> getVolatileStatusSet() {
        return volatileStatusSet;
    }

    public void setVolatileStatusSet(Set<VolatileStatus> volatileStatusSet) {
        this.volatileStatusSet = volatileStatusSet;
    }

    public Set<VolatileBattleStatus> getVolatileBattleStatusSet() {
        return volatileBattleStatusSet;
    }

    public void setVolatileBattleStatusSet(Set<VolatileBattleStatus> volatileBattleStatusSet) {
        this.volatileBattleStatusSet = volatileBattleStatusSet;
    }


}

