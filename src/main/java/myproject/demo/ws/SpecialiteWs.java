package myproject.demo.ws;

import myproject.demo.bean.Specialite;
import myproject.demo.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/specialite")

public class SpecialiteWs { ;
@Autowired
private SpecialiteService specialiteService;
    @GetMapping("/matricule/{matricule}")

    public Specialite findByFonctionnaire_MatriculeSub(@PathVariable String matricule){
        return specialiteService.findByFonctionnaire_MatriculeSub(matricule);
    }
    @GetMapping("specialite/intitule/{intitule}")

    public Specialite findByintitule(@PathVariable String intitule) {
        return specialiteService.findByintitule(intitule);
    }

    @DeleteMapping("/intitule/{intitule}")

    public int deleteByintitule(@PathVariable String intitule) {
        return specialiteService.deleteByintitule(intitule);
    }

    @PostMapping("/")
    public int save(@RequestBody Specialite specialite) {

        if (specialite.getIntitule() == null)
            return -1;
        else
            specialiteService.save(specialite);
        return 1;
    }
    @GetMapping("/")

    public List<Specialite> findAll(){
        return specialiteService.findAll();
    }
    @GetMapping("/ref/{ref}")
    public Specialite findByRef(@PathVariable String ref){
        return specialiteService.findByRef(ref);
    }


}
