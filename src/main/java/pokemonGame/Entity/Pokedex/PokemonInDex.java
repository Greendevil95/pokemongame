package pokemonGame.Entity.Pokedex;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Pokemon.AbstractPokemon;
import pokemonGame.Entity.Attacks.Attack;
import pokemonGame.Entity.Location;
import pokemonGame.Entity.Pokemon.Pokemon;
import pokemonGame.Enum.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon_in_dex")
public class PokemonInDex extends AbstractEntity {

    @Column
    private Integer number;

    @Enumerated(EnumType.STRING)
    private Type typeOne;

    @Enumerated(EnumType.STRING)
    private Type typeTwo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemonInDex")
    private List<PokemonForm> pokemonForms;

    @Column(length = 800)
    private String discription;

    @Column(length = 800)
    private String ruDiscription;

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


    /* @ElementCollection(targetClass = Ability.class, fetch = FetchType.EAGER)
     @CollectionTable(name = "abilities", joinColumns = @JoinColumn(name = "pokemonInDex_id"))
     @Enumerated(EnumType.STRING)*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "possible_ability",
            joinColumns = @JoinColumn(name = "pokemon_in_dex_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private List<Ability> abilities;

    @Column
    private Float weght;

    @Column
    private Float height;

    @Column
    private Integer expGroup;

    @Column
    private String imagePath;

    @Column
    private Integer baseExp;

    @Column
    private Integer catchRate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemonInDex")
    private List<Attack> possibleTMAndHM;

    @Transient
    private List<Attack> eggMoves;
    @Transient
    private List<Attack> moveTutorMoves;
    @Transient
    private List<Attack> lvlUpMoves;

    @Column
    private Integer generation;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemonInDex")
    private List<Pokemon> pokemonList;

    @OneToMany
    private List<Location> locations;

   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemonInDex")
    private List<PokemonInDex> nextFroms;*/

    public PokemonInDex() {
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Type getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(Type typeOne) {
        this.typeOne = typeOne;
    }

    public Type getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(Type typeTwo) {
        this.typeTwo = typeTwo;
    }

    public List<PokemonForm> getPokemonForms() {
        return pokemonForms;
    }

    public void setPokemonForms(List<PokemonForm> pokemonForms) {
        this.pokemonForms = pokemonForms;
    }

    public String getRuDiscription() {
        return ruDiscription;
    }

    public void setRuDiscription(String ruDiscription) {
        this.ruDiscription = ruDiscription;
    }

    public List<Attack> getEggMoves() {
        return eggMoves;
    }

    public void setEggMoves(List<Attack> eggMoves) {
        this.eggMoves = eggMoves;
    }

    public List<Attack> getMoveTutoeMoves() {
        return moveTutorMoves;
    }

    public void setMoveTutoeMoves(List<Attack> moveTutorMoves) {
        this.moveTutorMoves = moveTutorMoves;
    }

    public List<Attack> getLvlUpMoves() {
        return lvlUpMoves;
    }

    public void setLvlUpMoves(List<Attack> lvlUpMoves) {
        this.lvlUpMoves = lvlUpMoves;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Float getWeght() {
        return weght;
    }

    public void setWeght(Float weght) {
        this.weght = weght;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public int getExpGroup() {
        return expGroup;
    }

    public void setExpGroup(int expGroup) {
        this.expGroup = expGroup;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getBaseExp() {
        return baseExp;
    }

    public void setBaseExp(int baseExp) {
        this.baseExp = baseExp;
    }

    public int getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(int catchRate) {
        this.catchRate = catchRate;
    }

    public List<Attack> getPossibleTMAndHM() {
        return possibleTMAndHM;
    }

    public void setPossibleTMAndHM(List<Attack> possibleTMAndHM) {
        this.possibleTMAndHM = possibleTMAndHM;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getHP() {
        return HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getSpecDefence() {
        return specDefence;
    }

    public void setSpecDefence(Integer specDefence) {
        this.specDefence = specDefence;
    }

    public Integer getSpecAttack() {
        return specAttack;
    }

    public void setSpecAttack(Integer specAttack) {
        this.specAttack = specAttack;
    }

    public void setExpGroup(Integer expGroup) {
        this.expGroup = expGroup;
    }

    public void setBaseExp(Integer baseExp) {
        this.baseExp = baseExp;
    }

    public void setCatchRate(Integer catchRate) {
        this.catchRate = catchRate;
    }

    public List<Attack> getMoveTutorMoves() {
        return moveTutorMoves;
    }

    public void setMoveTutorMoves(List<Attack> moveTutorMoves) {
        this.moveTutorMoves = moveTutorMoves;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Type> getTypeList(){
        List<Type> types = new ArrayList<>();
        types.add(typeOne);
        if (typeTwo != null)
            types.add(typeTwo);
        return types;
    }
}
