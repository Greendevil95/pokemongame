package pokemonGame.Entity;

import pokemonGame.Enum.LocationType;
import pokemonGame.Enum.Region;
import pokemonGame.Enum.Weather;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Location extends AbstractEntity {

    @Column
    private String name;

    @Column
    private Region region;

    @OneToMany
    private List<NPC> npc;

    @OneToMany
    private List<Location> transitions;

    @Column
    private Weather weather;

    @Enumerated
    private LocationType locationType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<NPC> getNpc() {
        return npc;
    }

    public void setNpc(List<NPC> npc) {
        this.npc = npc;
    }

    public List<Location> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Location> transitions) {
        this.transitions = transitions;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }
}
