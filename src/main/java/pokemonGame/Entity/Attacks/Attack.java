package pokemonGame.Entity.Attacks;

import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Entity.Pokemon.Pokemon;
import pokemonGame.Enum.AttackType;
import pokemonGame.Enum.Type;

import javax.persistence.*;

@Entity
@Table(name = "attacks")
public class Attack extends AbstractEntity{

    @Column(name = "attack_name")
    private String name;

    @Column(name = "ru_attack_name")
    private String ruName;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column
    private int damage;

    @Column(length = 100)
    private int accuracy;

    @Column
    private int PP;

    @Enumerated(EnumType.STRING)
    private AttackType attackType;

    @Column
    private String discription;

    @Column
    private String ruDiscription;

    @Column
    private Integer priority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokemon_in_dex_id")
    private PokemonInDex pokemonInDex;


    public Attack(String name, Type type, int damage, int accuracy, int PP, AttackType attackType) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.accuracy = accuracy;
        this.PP = PP;
        this.attackType = attackType;
    }

    public Attack(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
