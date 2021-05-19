package myproject.demo.ws;

import myproject.demo.bean.Pole;
import myproject.demo.dao.PoleDao;
import myproject.demo.service.EtablissemmentService;
import myproject.demo.service.PoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CHU/Fonctionnaireee")
public class PoleWs {
@Autowired
    private PoleService poleService;

    @PostMapping("/")

    public int save(@RequestBody Pole pole){
        return poleService.save(pole);
    }

    @GetMapping("/intitule/{intitule}")

   public Pole findByintitule(@PathVariable String intitule){
        return   poleService.findByintitule(intitule);
    }
//    @GetMapping("/Etablissemmentintitule/{intitule}")
//
//    public Pole findByEtablissemmentintitule(@PathVariable String intitule){
//        return  poleService.findByEtablissemmentintitule(intitule);
//    }

    @GetMapping("/sintitule/{sintitule}")
    public Pole findByServhopital_Intitule(String sintitule){
        return poleService.findByServhopital_Intitule(sintitule);
    }
    @DeleteMapping("/intitule/{intitule}")

    public int deleteByintitule(@PathVariable String intitule){
        return  poleService.deleteByintitule(intitule);
    }
//    @DeleteMapping("/Etablissemmentintitule/{intitule}")
//
//    public int deleteByEtablissemmentintitule(@PathVariable String intitule){
//
//        return poleService.deleteByEtablissemmentintitule(intitule);
//    }


}
