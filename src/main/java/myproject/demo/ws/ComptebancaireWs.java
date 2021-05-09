package myproject.demo.ws;

import myproject.demo.bean.Comptebancaire;
import myproject.demo.service.ComptebancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/Fonctionnaire")
public class ComptebancaireWs {
    @PostMapping("/")
    public int save(@RequestBody Comptebancaire comptebancaire) {
        return  comptebancaireService.save(comptebancaire);
    }
        @GetMapping("/nom/{nom}")
    public Comptebancaire findByBanquenom(@PathVariable String nom) {
        return comptebancaireService.findByBanquenom(nom);
    }
    @GetMapping("/ref/{ref}")
    public Comptebancaire findByRef(@PathVariable String ref){
        return comptebancaireService.findByRef(ref);
    }
    @GetMapping("/nCompte/{nCompte}")
    public Comptebancaire findBynCompte(@PathVariable Long nCompte) {
        return comptebancaireService.findBynCompte(nCompte);
    }
    @GetMapping("/")
    public List<Comptebancaire> findAll() {
        return comptebancaireService.findAll();
    }
    @DeleteMapping("/banquenom/{banquenom}")
    public int deleteBynom(@PathVariable String banquenom) {
        return comptebancaireService.deleteBynom(banquenom);
    }
    @DeleteMapping("/nCompte/{nCompte}")

    public int deleteBynCompte(@PathVariable Long nCompte) {
        return comptebancaireService.deleteBynCompte(nCompte);
    }

    @Autowired
    private ComptebancaireService comptebancaireService;




}
