package pokemonGame.Entity.User;

import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Pokemon.Pokemon;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Team extends AbstractEntity {

    @OneToOne
    private User user;
    @OneToOne
    private Pokemon pokemonOne;
    @OneToOne
    private Pokemon pokemonTwo;
    @OneToOne
    private Pokemon pokemonThree;
    @OneToOne
    private Pokemon pokemonFour;
    @OneToOne
    private Pokemon pokemonFithe;
    @OneToOne
    private Pokemon pokemonSix;


}
