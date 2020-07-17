package pokemonGame.Entity.Attacks;


import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Items.Item;

import javax.persistence.*;

@Table(name = "tm_and_hm_attacks")
@Entity
public class TMAndHMAttack extends AbstractEntity {

    @OneToOne
    private Attack attack;

    @Column
    private boolean isHM = false;

    @OneToOne
    @JoinColumn(name = "tm_or_hm_item_id")
    private Item TmOrHmItem;

}
