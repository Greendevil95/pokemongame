package pokemonGame.Entity.Pokedex;


import pokemonGame.Entity.AbstractEntity;
import pokemonGame.Entity.Items.Item;
import pokemonGame.Enum.EvolutionWay;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class PokemonForm extends AbstractEntity {

    @Column
    private Integer formNumber;

    @ManyToOne
    @JoinColumn(name = "pokemon_in_dex_id")
    private PokemonInDex pokemonInDex;

    @Enumerated(value = EnumType.STRING)
    private EvolutionWay evolutionWay;

    @ManyToOne
    private Item EvolutionItem;

    @ManyToOne
    @JoinColumn(name = "pokemon_form_id")
    private PokemonInDex pokemonForm;

    public PokemonForm(Integer formNumber, PokemonInDex pokemonInDex, PokemonInDex pokemonForm) {
        this.formNumber = formNumber;
        this.pokemonInDex = pokemonInDex;
        this.pokemonForm = pokemonForm;
    }

    public PokemonForm() {
    }

    public Integer getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(Integer formNumber) {
        this.formNumber = formNumber;
    }

    public PokemonInDex getPokemonForm() {
        return pokemonForm;
    }

    public void setPokemonForm(PokemonInDex pokemonForm) {
        this.pokemonForm = pokemonForm;
    }

    public PokemonInDex getPokemonInDex() {
        return pokemonInDex;
    }

    public void setPokemonInDex(PokemonInDex pokemonInDex) {
        this.pokemonInDex = pokemonInDex;
    }

    public EvolutionWay getEvolutionWay() {
        return evolutionWay;
    }

    public void setEvolutionWay(EvolutionWay evolutionWay) {
        this.evolutionWay = evolutionWay;
    }

    public Item getEvolutionItem() {
        return EvolutionItem;
    }

    public void setEvolutionItem(Item evolutionItem) {
        EvolutionItem = evolutionItem;
    }
}
