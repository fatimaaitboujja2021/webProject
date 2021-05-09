package myproject.demo.ws;

import myproject.demo.bean.ListeGarde;
import myproject.demo.service.ListeGardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
 @RestController
@RequestMapping("/CHU/liste")

public class ListeGardeWs {

@Autowired
private ListeGardeService listeGardeService;
    @PostMapping("/")
    public  int save(@RequestBody ListeGarde listeGarde){
      return listeGardeService.save(listeGarde);
    }
    @DeleteMapping("/refdeListe/{refdeListe}")
    public int deleteByRef(@PathVariable String refdeListe){
        return listeGardeService.deleteByRef(refdeListe);
    }
    @GetMapping("/matricule/{matricule}")

    public List<ListeGarde> findByFonctionnaire_MatriculeSub(@PathVariable String matricule){
        return listeGardeService.findByFonctionnaire_MatriculeSub(matricule);
    }
    @GetMapping("/ref/{ref}")
    public ListeGarde findByRef(@PathVariable String ref){
        return listeGardeService.findByRef(ref);
    }

    @GetMapping("/duree/{duree}")
    public List<ListeGarde> findBydureDeGarde(@PathVariable int duree){

        return listeGardeService.findBydureDeGarde(duree);
    }
    @GetMapping("/date/{date}")

    public List<ListeGarde> findBydateGarde(@PathVariable Date date){
        return  listeGardeService.findBydateGarde(date);
    }













}
