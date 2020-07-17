package pokemonGame.Entity.Items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Enum.ItemType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Item extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String ruName;

    @Column
    private String discription;

    @Column
    private String ruDiscription;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Column
    private String imagePath;

    @JsonIgnore
    @OneToMany
    private List<UserItem> userItemList;

    @Column
    private boolean transferable;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuName() {
        return ruName;
    }

    public void setRuName(String ruName) {
        this.ruName = ruName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getRuDiscription() {
        return ruDiscription;
    }

    public void setRuDiscription(String ruDiscription) {
        this.ruDiscription = ruDiscription;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }




}
