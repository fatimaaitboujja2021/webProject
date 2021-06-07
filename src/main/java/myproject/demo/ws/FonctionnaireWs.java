package myproject.demo.ws;


import myproject.demo.bean.*;
import myproject.demo.service.FonctionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Chu/Fonctionnairews")
public class FonctionnaireWs {


@Autowired
private FonctionnaireService fonctionnaireService;
    @GetMapping("/refgarde/{refgarde}")
    public Fonctionnaire findByListeGarde_Ref(@PathVariable String refgarde) {
        return fonctionnaireService.findByListeGarde_Ref(refgarde);
    }

    @PutMapping("/")
    public Fonctionnaire update(@RequestBody Fonctionnaire fonctionnaire) {
        return fonctionnaireService.update(fonctionnaire);
    }
    @PostMapping("/delete-multiple-by-reference")
    public int deleteByReference(@RequestBody List<Fonctionnaire> fonctionnaires) {
        return fonctionnaireService.deleteByRef(fonctionnaires);
    }
    @GetMapping("/nomp/{nom}/{prenom}")
    public Fonctionnaire findByNomAndPrenom(@PathVariable  String nom,@PathVariable  String prenom){
        return fonctionnaireService.findByNomAndPrenom(nom,prenom);
    }
    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return fonctionnaireService.deleteByRef(reference);
    }
    @GetMapping("/r")
    public int nombredefonc() {
        return fonctionnaireService.nombredefonc();
    }

    @GetMapping("/ref/{ref}")
    public Fonctionnaire findByRef(@PathVariable String ref){
        return fonctionnaireService.findByRef(ref);
    }

    @GetMapping("/d/{d}")
    public List<String> findBynom(@PathVariable Object d) {
        return fonctionnaireService.findBynom(d);
    }

    @PostMapping("/")
    public int save (@RequestBody Fonctionnaire fonctionnaire){
       return fonctionnaireService.save(fonctionnaire);
    }
    @GetMapping("/")
    public List<Fonctionnaire> findAll() {
        return fonctionnaireService.findAll();
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
