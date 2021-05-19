package myproject.demo.ws;

import myproject.demo.bean.Servhopital;
import myproject.demo.bean.Specialite;
import myproject.demo.service.ServhopitalService;
import myproject.demo.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/servhopitalWs")

public class ServhopitalWs { ;
    @Autowired
    private ServhopitalService servhopitalService;

    @GetMapping("/intitule/{intitule}")
    public Servhopital findByintitule(@PathVariable String intitule) {
        return servhopitalService.findByintitule(intitule);
    }

    @DeleteMapping("/intitule/{intitule}")
    public int deleteByintitule(@PathVariable String intitule) {
        return servhopitalService.deleteByintitule(intitule);
    }
    @GetMapping("/")
    public List<Servhopital> findAll(){
        return servhopitalService.findAll();
    }
    @GetMapping("/ref/{ref}")
    public Servhopital findByRef(@PathVariable String ref){
        return servhopitalService.findByRef(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody Servhopital servhopital) {

        return servhopitalService.save(servhopital);
    }


    @GetMapping("/matricule/{matricule}")
    public Servhopital findByFonctionnaire_MatriculeSuperieur(@PathVariable String matricule){
        return servhopitalService.findByFonctionnaire_MatriculeSuperieur(matricule);
    }

}
