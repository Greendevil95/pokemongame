package pokemonGame.Entity.Pokemon;

import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Attacks.PokemonAttack;
import pokemonGame.Entity.Items.Item;
import pokemonGame.Entity.Nature;
import pokemonGame.Entity.Pokedex.Ability;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Enum.Gender;
import pokemonGame.Enum.StatusCondition;

import javax.persistence.*;
import java.util.List;

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

    @Column
    private Integer attack;

    @Column
    private Integer defense;

    @Column
    private Integer HP;

    @Column
    private Integer speed;

    @Column
    private Integer specDefence;

    @Column
    private Integer specAttack;

    @Column
    private Integer level;

    @Column
    private String IVCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemon")
    private List<PokemonAttack> attackMoves;

    @Column
    private int currentHP;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nature_id")
    private Nature nature;

    @Column
    private boolean shiny;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpecDefence() {
        return specDefence;
    }

    public void setSpecDefence(int specDefence) {
        this.specDefence = specDefence;
    }

    public int getSpecAttack() {
        return specAttack;
    }

    public void setSpecAttack(int specAttack) {
        this.specAttack = specAttack;
    }

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

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public void setSpecDefence(Integer specDefence) {
        this.specDefence = specDefence;
    }

    public void setSpecAttack(Integer specAttack) {
        this.specAttack = specAttack;
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

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
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
}

