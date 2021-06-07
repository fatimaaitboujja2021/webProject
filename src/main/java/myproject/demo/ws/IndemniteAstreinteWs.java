package myproject.demo.ws;


import myproject.demo.bean.IndemniteAstreinte;
import myproject.demo.bean.IndemniteGarde;
import myproject.demo.service.IndemniteAstreinteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Chu/indemniteAstreinteWs")
public class IndemniteAstreinteWs {

    @Autowired
    private IndemniteAstreinteService indemniteAstreinteService;
    @GetMapping("/ref/{ref}")
    public IndemniteAstreinte findByRef(@PathVariable String ref){
        return  indemniteAstreinteService.findByRef(ref);
    }

    @GetMapping("/Montantnet/{t}/{p}/{n}")
    public double findMontantnet(@PathVariable String t,@PathVariable String p,@PathVariable int n) {
        return indemniteAstreinteService.findMontantnet(t, p, n);
    }

    @GetMapping("/montant/{n}")

    public Float findMontantnettotal(@PathVariable int n) {
        return indemniteAstreinteService.findMontantnettotal(n);
    }

    @GetMapping("/annee/{n}")
    public List<IndemniteAstreinte> findByYear(@PathVariable int n) {
        return indemniteAstreinteService.findByYear(n);
    }

    @GetMapping("/anneetrim/{n}/{t}")
    public List<IndemniteAstreinte> findByYearTrim(@PathVariable int n,@PathVariable int t) {
        return indemniteAstreinteService.findByYearTrim(n, t);
    }

    @GetMapping("/")

    public List<IndemniteAstreinte> findAll() {

        return indemniteAstreinteService.findAll();
    }
    @GetMapping("/calculAll/{matricule}/{year}")

    public int CalculAll(@PathVariable String matricule,@PathVariable int year) {
        return indemniteAstreinteService.CalculAll(matricule, year);
    }

    @GetMapping("/sub/{t}/{p}/{n}")
    public String[] findBySub(@PathVariable String t,@PathVariable String p,@PathVariable int n) {
        return indemniteAstreinteService.findBySub(t, p, n);
    }

    @GetMapping("/search/{n}/{p}")
    public List<IndemniteAstreinte> findBynomprenom(@PathVariable Object n,@PathVariable  Object p) {
        return indemniteAstreinteService.findBynomprenom(n, p);
    }

    @GetMapping("/calcule/{nom}/{prenom}/{year}/{montant}/{typedegarde}")

    public List<IndemniteAstreinte> calculDindemnite(@PathVariable String nom, @PathVariable String prenom, @PathVariable int year, @PathVariable float montant, @PathVariable String typedegarde) {
        return indemniteAstreinteService.calculDindemnite(nom, prenom, year,montant,typedegarde);
    }

    @PostMapping("/")
    public int save(@RequestBody IndemniteAstreinte indemniteAstreinte){
        return  indemniteAstreinteService.save(indemniteAstreinte);
    }
}
