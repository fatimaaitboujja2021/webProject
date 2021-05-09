package myproject.demo.ws;

import myproject.demo.bean.Fonction;
import myproject.demo.service.FonctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CHU/fonction")
public class Fonctionws {
    @Autowired
    private FonctionService fonctionService;
    @GetMapping("fonction/MatriculeSub/{MatriculeSub}")

    public     Fonction findByFonctionnaire_MatriculeSub(@PathVariable String MatriculeSub){
        return fonctionService.findByFonctionnaire_MatriculeSub(MatriculeSub);
    }
    @GetMapping("/ref/{ref}")
    public Fonction findByRef(@PathVariable String ref){
        return fonctionService.findByRef(ref);
    }


    @GetMapping("fonction/intitule/{intitule}")

    public Fonction findByintitule(@PathVariable String intitule) {
        return fonctionService.findByintitule(intitule);
    }

    @DeleteMapping("/intitule/{intitule}")

    public int deleteByintitule(@PathVariable String intitule) {
        return fonctionService.deleteByintitule(intitule);
    }
    @PostMapping("/")

    public int save(@RequestBody Fonction fonction) {

        if (fonction.getIntitule() == null)
            return -1;
        else
            fonctionService.save(fonction);
        return 1;
    }


}
