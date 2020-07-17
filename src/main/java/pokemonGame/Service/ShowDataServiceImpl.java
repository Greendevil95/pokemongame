package pokemonGame.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Entity.Pokemon.Pokemon;
import pokemonGame.Repository.PokemonInDexRepository;
import pokemonGame.Repository.PokemonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowDataServiceImpl implements ShowDataService {

    private final PokemonInDexRepository pokemonInDexRepository;

    private final PokemonRepository pokemonRepository;

    @Autowired
    public ShowDataServiceImpl(PokemonInDexRepository pokemonInDexRepository, PokemonRepository pokemonRepository) {
        this.pokemonInDexRepository = pokemonInDexRepository;
        this.pokemonRepository = pokemonRepository;
    }

   public void showPokemon(){
       List<PokemonInDex> pokemonInDexList;
               pokemonInDexList = (List<PokemonInDex>) pokemonInDexRepository.findAll();
               List<Pokemon> pokemons;
               pokemons = (List<Pokemon>) pokemonRepository.findAll();
       System.out.println(pokemonInDexList.get(0).getPokemonForms().size());
      System.out.println(pokemonInDexList.get(0).getPokemonForms().get(0).getPokemonInDex().getName());
       System.out.println(pokemonInDexList.get(0).getPokemonForms().get(1).getPokemonInDex().getName());
       System.out.println(pokemonInDexList.get(0).getPokemonForms().get(0).getPokemonForm().getName());
       System.out.println(pokemonInDexList.get(0).getPokemonForms().get(1).getPokemonForm().getName());
       //System.out.println(pokemonInDexList.get(0).getPokemonForms().get(2).getPokemonInDex().getName());
       //System.out.println(pokemonInDexList.get(1).getPokemonForms().get(0).getPokemonInDex().getName());
       System.out.println(pokemonInDexList.get(1).getPokemonForms().size());
       System.out.println(pokemonInDexList.get(2).getPokemonForms().get(0).getPokemonForm().getName());
       System.out.println(pokemonInDexList.get(2).getPokemonForms().size());
       System.out.println(pokemonInDexList.get(0));
       System.out.println(pokemonInDexList.get(1));
       System.out.println(pokemonInDexList.get(10));
       //System.out.println(pokemons.get(0).getPokemonInDex().getName());

    }
}
