package pokemonGame.Entity.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Items.Item;
import pokemonGame.Entity.Items.UserItem;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Entity.Pokemon.Pokemon;
import pokemonGame.Entity.UserDex;
import pokemonGame.Enum.Gender;

import javax.persistence.*;
import java.util.List;

@Table(name = "users")
@Entity
public class User extends AbstractEntity {

    @Column
    private String name;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name = "password", nullable = true)
    private String password;

    @Column
    private String nick;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private int age;

    @Column(length = 400)
    private String discription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Pokemon> pokemonList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserItem> itemList;

    @OneToOne
    private Team team;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserDex> userDex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<UserItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<UserItem> itemList) {
        this.itemList = itemList;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<UserDex> getUserDex() {
        return userDex;
    }

    public void setUserDex(List<UserDex> userDex) {
        this.userDex = userDex;
    }
}
