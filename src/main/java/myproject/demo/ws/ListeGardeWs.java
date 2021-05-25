package myproject.demo.ws;

import myproject.demo.bean.Fonctionnaire;
import myproject.demo.bean.ListeGarde;
import myproject.demo.service.ListeGardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
 @RestController
@RequestMapping("/Chu/listeGardeWs")

public class ListeGardeWs {

@Autowired
private ListeGardeService listeGardeService;
     @GetMapping("/matriculesup/{matriculesup}")
     public List<ListeGarde> findByFonctionnaire_MatriculeSuperieur(@PathVariable String matriculesup) {
         return listeGardeService.findByFonctionnaire_MatriculeSuperieur(matriculesup);
     }

     @GetMapping("/minetmaxdate/{n}/{d}/{a}")
     public List<ListeGarde> findBydateminetmax(@PathVariable String n,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date d, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date a) {
         return listeGardeService.findBydateminetmax(n,d,a);
     }
     @GetMapping("/nombre/{n}")
     public int nombredefonc(@PathVariable String n) {
         return listeGardeService.nombredefonc(n);
     }
     @GetMapping("/typegarde/{n}")
     public int nombredefoncgarde(@PathVariable String n) {
         return listeGardeService.nombredefoncgarde(n);
     }
     @GetMapping("/statue/{n}")
     public int nombredefoncstatue(@PathVariable String n) {
         return listeGardeService.nombredefoncstatue(n);
     }

     @PutMapping("/")
     public ListeGarde update(@RequestBody ListeGarde listeGarde) {
         return listeGardeService.update(listeGarde);
     }
     @PostMapping("/delete-multiple-by-reference")
     public int deleteByReference(@RequestBody List<ListeGarde> listeGardes) {
         return listeGardeService.deleteByRef(listeGardes);
     }
     @PostMapping("/savemultiple")

     public int saveMultiple(@RequestBody List<ListeGarde> listeGardes) {
         return listeGardeService.saveMultiple(listeGardes);
     }

     @GetMapping("/")
     public List<ListeGarde> findAll() {
         return listeGardeService.findAll();
     }
    @PostMapping("/")
    public  int save(@RequestBody ListeGarde listeGarde){
      return listeGardeService.save(listeGarde);
    }
    @DeleteMapping("/reference/{refdeListe}")
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
