package myproject.demo.ws;

import myproject.demo.bean.Etablissemment;
import myproject.demo.dao.EtablissemmentDao;
import myproject.demo.service.EtablissemmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/Fonctionnairee")
public class EtablissemmentWs {
    @PostMapping("/")
    public int save(@RequestBody Etablissemment etablissemment){
        return etablissemmentService.save(etablissemment);
    }
    @GetMapping("/intitule/{intitule}")
    public Etablissemment findByIntitule(@PathVariable String intitule) {
        return etablissemmentService.findByintitule(intitule);
    }


    @GetMapping("Pole/intitule/{intitule}")
    public Etablissemment findByPole_Intitule(@PathVariable String  intitule){
        return etablissemmentService.findByPole_Intitule(intitule);

    }

    @GetMapping("/")
    public List<Etablissemment> findAll() {
        return etablissemmentService.findAll();
    }
    @GetMapping("/aLong/{aLong}")

    public Etablissemment getOne(@PathVariable Long aLong) {
        return etablissemmentService.getOne(aLong);
    }
    @DeleteMapping("/intitule/{intitule}")
    public int deleteByIntitule(@PathVariable String intitule) {
        return etablissemmentService.deleteByintitule(intitule);
    }


    @Autowired
    private EtablissemmentService etablissemmentService;

}
