package pokemonGame.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pokemonGame.Service.ShowDataService;

@RestController
@RequestMapping("/show")
public class ShowDataController {

    private final ShowDataService showDataService;

    @Autowired
    public ShowDataController(ShowDataService showDataService) {
        this.showDataService = showDataService;
    }

    @GetMapping("/pokemon")
    public void showPokemon(){
        showDataService.showPokemon();
    }
}
