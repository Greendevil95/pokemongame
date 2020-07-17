package pokemonGame.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pokemonGame.Service.ServiceFillData;



@RestController
@RequestMapping("/test")
public class FillDataController {

    private final ServiceFillData serviceFillData;

    @Autowired
    public FillDataController(ServiceFillData serviceFillData) {
        this.serviceFillData = serviceFillData;
    }

    @GetMapping("/fill")
    public void fillData(){
    serviceFillData.fillData();
    }

    @GetMapping("/natures")
    public void fillNatures(){
        serviceFillData.fillNature();
    }

}
