package myproject.demo.ws;

import myproject.demo.bean.Conge;
import myproject.demo.dao.CongeDao;
import myproject.demo.service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/CHU/congews")
public class CongeWs {
    @Autowired
    private CongeService congeService;
    @PostMapping("/")
    public int save(@RequestBody Conge conge){
       return congeService.save(conge);
    }
    @GetMapping("/type/{type}")

    public List<Conge> findBytypeConge(@PathVariable String type){
        return congeService.findBytypeConge(type);

    }
    @GetMapping("/dbf/{dateDebutConge}/{dateFinConge}")
    public   List<Conge> findByDateDebutCongeAndDateFinConge(@PathVariable Date dateDebutConge,@PathVariable Date dateFinConge){
        return congeService.findByDateDebutCongeAndDateFinConge(dateDebutConge,dateFinConge);
    }
    @GetMapping("/db/{dateDebutConge}")

    public List<Conge> findByDateDebutConge(@PathVariable Date dateDebutConge){
        return congeService.findByDateDebutConge(dateDebutConge);
    }
    @GetMapping("/MatriculeSub/{MatriculeSub}")

    public Conge findByFonctionnaireMatriculeSub(@PathVariable String MatriculeSub){
        return  congeService.findByFonctionnaireMatriculeSub(MatriculeSub);
    }
    @GetMapping("/df/{dateFinConge}")

    public List<Conge> findByDateFinConge(@PathVariable Date dateFinConge){
        return congeService.findByDateFinConge(dateFinConge);
    }
    @GetMapping("/ref/{ref}")

    public Conge findByRef(@PathVariable String ref){
        return congeService.findByRef(ref);
    }
    @DeleteMapping("/dateDebutConge/{dateDebutConge}")

    public int deleteByDateDebutConge(@PathVariable Date dateDebutConge){
        return  congeService.deleteByDateDebutConge(dateDebutConge);
    }

}
