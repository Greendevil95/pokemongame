package pokemonGame.Entity.Items;

import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Items.Item;
import pokemonGame.Entity.Pokemon.Pokemon;
import pokemonGame.Entity.User.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserItem extends AbstractEntity {

    @ManyToOne
    private Item item;

    @ManyToOne
    private User user;

    @OneToOne
    private Pokemon pokemon;

    @Column
    private int count;


}
