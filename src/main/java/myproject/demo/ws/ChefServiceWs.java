package myproject.demo.ws;


import myproject.demo.bean.chefservice;
import myproject.demo.service.ChefServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Chu/chefServiceWs")
public class ChefServiceWs {
    @Autowired
    private ChefServiceService chefServiceService;
    @GetMapping("/matricule/{matricule}")

    public chefservice findByMatricule(@PathVariable String matricule){

        return chefServiceService.findByMatricule(matricule);
    }


    @PutMapping("/")
    public chefservice update(@RequestBody chefservice chefService) {
        return chefServiceService.update(chefService);
    }
    @PostMapping("/delete-multiple-by-reference")
    public int deleteByReference(@RequestBody List<chefservice> chefservices) {
        return chefServiceService.deleteByRef(chefservices);
    }
    @GetMapping("/")

    public List<chefservice> findAll() {
        return chefServiceService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody chefservice chefService){
       return chefServiceService.save(chefService);
    }


    @GetMapping("/ref/{ref}")

    public chefservice findByRef(@PathVariable String ref){
        return chefServiceService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public  int deleteByRef(@PathVariable String ref){
        return chefServiceService.deleteByRef(ref);
    }
}
