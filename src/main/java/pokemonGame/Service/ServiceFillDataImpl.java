package pokemonGame.Service;

import au.com.bytecode.opencsv.CSVReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import pokemonGame.Entity.Nature;
import pokemonGame.Entity.Attacks.Attack;
import pokemonGame.Entity.Pokedex.PokemonForm;
import pokemonGame.Entity.Pokedex.PokemonInDex;
import pokemonGame.Enum.AttackType;
import pokemonGame.Enum.Stats;
import pokemonGame.Enum.Type;
import pokemonGame.Repository.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceFillDataImpl implements ServiceFillData {


    private final PokemonRepository pokemonRepository;

    private final PokemonInDexRepository pokemonInDexRepository;

    private final NatureRepository natureRepository;

    private final AttackRepository attackRepository;

    private final PokemonFormRepository pokemonFormRepository;

    public ServiceFillDataImpl(PokemonRepository pokemonRepository, PokemonInDexRepository pokemonInDexRepository, NatureRepository natureRepository, AttackRepository attackRepository, PokemonFormRepository pokemonFormRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonInDexRepository =  pokemonInDexRepository;
        this.natureRepository = natureRepository;
        this.attackRepository = attackRepository;
        this.pokemonFormRepository = pokemonFormRepository;
    }

    public void fillData(){
        pokemonInDexRepository.saveAll(CSVParcer());
        pokemonFormRepository.saveAll(fillForm());

    }

    @Override
    public void fillNature() {
        String[] str = {"Adamant",
                "Bashful",
                "Bold",
                "Brave",
                "Calm",
                "Careful",
                "Docile",
                "Gentle",
                "Hardy",
                "Hasty",
                "Impish",
                "Jolly",
                "Lax",
                "Lonely",
                "Mild",
                "Modest",
                "Naive",
                "Naughty",
                "Quiet",
                "Quirky",
                "Rash",
                "Relaxed",
                "Sassy",
                "Serious",
                "Timid"
        };

    List<Nature> natures = new ArrayList<>();
    natures.add(new Nature(str[0], Stats.ATTACK, Stats.SPECATTACK));
        natures.add(new Nature(str[1], Stats.SPECATTACK, Stats.SPECATTACK));
        natures.add(new Nature(str[2], Stats.DEFENCE, Stats.ATTACK));
        natures.add(new Nature(str[3], Stats.ATTACK, Stats.SPEED));
        natures.add(new Nature(str[4], Stats.SPECDEFENCE, Stats.ATTACK));
        natures.add(new Nature(str[5], Stats.SPECDEFENCE, Stats.SPECATTACK));
        natures.add(new Nature(str[6], Stats.DEFENCE, Stats.DEFENCE));
        natures.add(new Nature(str[7], Stats.SPECDEFENCE, Stats.DEFENCE));
        natures.add(new Nature(str[8], Stats.ATTACK, Stats.ATTACK));
        natures.add(new Nature(str[9], Stats.SPEED, Stats.DEFENCE));
        natures.add(new Nature(str[10], Stats.DEFENCE, Stats.SPECATTACK));
        natures.add(new Nature(str[11], Stats.SPEED, Stats.SPECATTACK));
        natures.add(new Nature(str[12], Stats.DEFENCE, Stats.SPECDEFENCE));
        natures.add(new Nature(str[13], Stats.ATTACK, Stats.DEFENCE));
        natures.add(new Nature(str[14], Stats.SPECATTACK, Stats.DEFENCE));
        natures.add(new Nature(str[15], Stats.SPECATTACK, Stats.ATTACK));
        natures.add(new Nature(str[16], Stats.SPEED, Stats.SPECDEFENCE));
        natures.add(new Nature(str[17], Stats.ATTACK, Stats.SPECDEFENCE));
        natures.add(new Nature(str[18], Stats.SPECATTACK, Stats.SPEED));
        natures.add(new Nature(str[19], Stats.SPECDEFENCE, Stats.SPECDEFENCE));
        natures.add(new Nature(str[20], Stats.SPECATTACK, Stats.SPECDEFENCE));
        natures.add(new Nature(str[21], Stats.DEFENCE, Stats.SPEED));
        natures.add(new Nature(str[22], Stats.SPECDEFENCE, Stats.SPEED));
        natures.add(new Nature(str[23], Stats.SPEED, Stats.SPEED));
        natures.add(new Nature(str[24], Stats.SPEED, Stats.ATTACK));
        natureRepository.saveAll(natures);

    }

    @Override
    public void fillAttacks() {
            try {
                Document document = Jsoup.connect("https://bulbapedia.bulbagarden.net/wiki/List_of_moves").get();
                Elements ps = document.select("table.sortable.roundy");
                List<String> stringList = new ArrayList<>();
                for (Element element : ps.select("td")) {
                    //System.out.println(element.text());
                    stringList.add(element.text());
                }

                for(int i = 1; i<stringList.size(); i= i+9) {
                    int generation;
                    switch (stringList.get(i+8)){
                        case  "I" :
                            generation = 1;
                            break;
                        case  "II":
                            generation = 2;
                            break;
                        case "III":
                            generation = 3;
                            break;
                        case "IV":
                            generation = 4;
                            break;
                        case "V":
                            generation =5;
                            break;
                        case "VI":
                        case "VI*":
                            generation = 6;
                            break;
                        case "VII":
                        case "VII*":
                            generation = 7;
                            break;
                        case "VIII":
                        case "VIII*":
                            generation = 8;
                            break;
                    }
                    if(stringList.get(i+1).contains("*")){
                        StringBuilder stringBuffer = new StringBuilder(stringList.get(i+1));
                        stringList.set(i+1,stringBuffer.delete(stringList.get(i+1).length()-1,100).toString());
                    }
                    if(stringList.get(i+5).contains("*")){
                        StringBuilder stringBuffer = new StringBuilder(stringList.get(i+5));
                        stringList.set(i+5,stringBuffer.delete(stringList.get(i+5).length()-1,100).toString());
                    }
                    if(stringList.get(i+6).contains("*")){
                        StringBuilder stringBuffer = new StringBuilder(stringList.get(i+6));
                        stringList.set(i+6,stringBuffer.delete(stringList.get(i+6).length()-1,100).toString());
                    }
                    if(stringList.get(i+7).contains("*")){
                        StringBuilder stringBuffer = new StringBuilder(stringList.get(i+7));
                        stringList.set(i+7,stringBuffer.delete(stringList.get(i+7).length()-1,100).toString());
                    }
                    attackRepository.save(new Attack(stringList.get(i+1), Type.valueOf(stringList.get(i+2).toUpperCase()), Integer.parseInt(stringList.get(i+6)), Integer.parseInt(stringList.get(i+7)),Integer.parseInt(stringList.get(i+5)), AttackType.valueOf(stringList.get(i+2).toUpperCase())));
                    System.out.println(stringList.get(i) + " " + stringList.get(i + 1) + " " + stringList.get(i + 2) + " " + stringList.get(i + 3) + " " + stringList.get(i + 5) + " " + stringList.get(i + 6) + " " + stringList.get(i + 7) + " " + stringList.get(i + 8));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    private List<PokemonInDex> CSVParcer() {
        ArrayList<PokemonInDex> pokemons = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("pokemon.csv"), ',', '"', 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] nextLine = new String[0];
        for (int i = 0; i<166;i++) {
            try {
                assert reader != null;
                if ((nextLine= reader.readNext()) == null) {
                    break;
                }
                PokemonInDex pokemonInDex = new PokemonInDex();
                pokemonInDex.setNumber(Integer.parseInt(nextLine[0]));
                pokemonInDex.setName(nextLine[1]);
                pokemonInDex.setTypeOne(Type.valueOf(nextLine[2].toUpperCase()));
                if (nextLine[3] != null && !nextLine[3].equals(""))
                pokemonInDex.setTypeTwo(Type.valueOf(nextLine[3].toUpperCase()));
                pokemonInDex.setDefense(Integer.parseInt(nextLine[7]));
                pokemonInDex.setHP(Integer.parseInt(nextLine[5]));
                pokemonInDex.setSpecAttack(Integer.parseInt(nextLine[8]));
                pokemonInDex.setSpecDefence(Integer.parseInt(nextLine[9]));
                pokemonInDex.setSpeed(Integer.parseInt(nextLine[10]));
                pokemonInDex.setAttack(Integer.parseInt(nextLine[6]));
                pokemonInDex.setGeneration(Integer.parseInt(nextLine[11]));
                pokemonInDex.setPokemonForms(new ArrayList<PokemonForm>());
                pokemons.add(pokemonInDex);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  pokemons;
    }

    private List<PokemonForm> fillForm(){
        ArrayList<PokemonForm> pokemons = new ArrayList<>();
        pokemons.add(new PokemonForm(2,pokemonInDexRepository.findFirstByNumber(1),pokemonInDexRepository.findFirstByNumber(2)));
        pokemons.add(new PokemonForm(3,pokemonInDexRepository.findFirstByNumber(1),pokemonInDexRepository.findFirstByNumber(3)));
        return pokemons;

    }
}
