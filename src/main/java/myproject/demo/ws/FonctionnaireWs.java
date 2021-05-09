package myproject.demo.ws;


import myproject.demo.bean.*;
import myproject.demo.service.FonctionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/Fonctionnairews")
public class FonctionnaireWs {


@Autowired
private FonctionnaireService fonctionnaireService;
    @GetMapping("/ref/{ref}")
    public Fonctionnaire findByRef(@PathVariable String ref){
        return fonctionnaireService.findByRef(ref);
    }

    @PostMapping("/")

    public int save (@RequestBody Fonctionnaire fonctionnaire){
       return fonctionnaireService.save(fonctionnaire);
    }
    @GetMapping("/matriculeSub/{matriculeSub}")

    public Fonctionnaire findBymatriculeSub(@PathVariable String matriculeSub){
        return fonctionnaireService.findBymatriculeSub(matriculeSub);
    }
    @GetMapping("/matriculeSuperieur/{matriculeSuperieur}")
    public     List<Fonctionnaire> findBymatriculeSuperieur(@PathVariable String matriculeSuperieur){
        return fonctionnaireService.findBymatriculeSuperieur(matriculeSuperieur);
    }
    @GetMapping("/intitule/{intitule}")

    public List<Fonctionnaire> findBySpecialiteIntitule(@PathVariable String intitule){
        return  fonctionnaireService.findBySpecialiteIntitule(intitule);
    }
    @GetMapping("/validiterGarde/{validiterGarde}")
    public List<Fonctionnaire> findByvaliditerGarde(@PathVariable boolean validiterGarde){
        return fonctionnaireService.findByvaliditerGarde(validiterGarde);
    }
    @DeleteMapping("/matricule/{matricule}")

    public int deleteBymatriculeSub(@PathVariable String matricule){
        return fonctionnaireService.deleteBymatriculeSub(matricule);
    }

}
