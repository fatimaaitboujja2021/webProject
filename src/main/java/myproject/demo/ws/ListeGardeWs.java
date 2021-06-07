package myproject.demo.ws;

import myproject.demo.bean.Fonctionnaire;
import myproject.demo.bean.ListeGarde;
import myproject.demo.service.ListeGardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
 @RestController
@RequestMapping("/Chu/listeGardeWs")

public class ListeGardeWs {

@Autowired
private ListeGardeService listeGardeService;
     @GetMapping("/matriculesupA/{matriculesup}")
     public List<ListeGarde> findByFonctionnaire_MatriculeSuperieurA(@PathVariable String matriculesup) {
         return listeGardeService.findByFonctionnaire_MatriculeSuperieurA(matriculesup);
     }
     @GetMapping("/matriculesupG/{matricule}")

     public List<ListeGarde> findByFonctionnaire_MatriculeSuperieurG(@PathVariable String matricule) {
         return listeGardeService.findByFonctionnaire_MatriculeSuperieurG(matricule);
     }

     @GetMapping("/IndemniteAstreinte/{ref}")
     public List<ListeGarde> findByIndemniteAstreinte_Ref(@PathVariable String ref) {
         return listeGardeService.findByIndemniteAstreinte_Ref(ref);
     }
     @GetMapping("/IndemniteGarde/{ref}")
     public List<ListeGarde> findByIndemniteGarde_Ref(@PathVariable String ref) {
         return listeGardeService.findByIndemniteGarde_Ref(ref);
     }

     @Transactional
     public int deleteByRef(List<ListeGarde> listeGardes) {
         return listeGardeService.deleteByRef(listeGardes);
     }

     @GetMapping("/tr/{year}/{typedegarde}")

     public List<Integer> trouvertrim(@PathVariable int year,@PathVariable String typedegarde) {
         return listeGardeService.trouvertrim(year,typedegarde);
     }

     @GetMapping("/find/{nom}/{prenom}/{year}/{trim}/{t}")

     public List<ListeGarde> findByFonctionnaire_NomAndFonctionnaire_PrenomAndTrimestre(@PathVariable String nom,@PathVariable String prenom,@PathVariable  int year,@PathVariable int trim,@PathVariable String t) {
         return listeGardeService.findByFonctionnaire_NomAndFonctionnaire_PrenomAndTrimestre(nom, prenom,year,trim,t);
     }
     @GetMapping("/chercher/{nom}/{prenom}")

     public List<ListeGarde> findByFonctionnaire_NomAndFonctionnaire_Prenom(@PathVariable String nom,@PathVariable String prenom) {
         return listeGardeService.findByFonctionnaire_NomAndFonctionnaire_Prenom(nom, prenom);
     }





     @GetMapping("/minetmaxdate/{n}/{d}/{a}/{t}")
     public List<ListeGarde> findBydateminetmax(@PathVariable String n,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate d, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate a,@PathVariable String t) {
         return listeGardeService.findBydateminetmax(n,d,a,t);
     }
     @GetMapping("/nombre/{n}")
     public int nombredefonc(@PathVariable String n) {
         return listeGardeService.nombredefonc(n);
     }
     @GetMapping("/joursFeries/{n}")

     public String joursFeries(@PathVariable   ListeGarde n) {
         return listeGardeService.joursFeries(n);
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
