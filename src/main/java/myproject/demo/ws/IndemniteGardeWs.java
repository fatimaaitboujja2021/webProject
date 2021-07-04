package myproject.demo.ws;

import myproject.demo.bean.IndemniteAstreinte;
import myproject.demo.bean.IndemniteGarde;
import myproject.demo.bean.ListeGarde;
import myproject.demo.service.IndemniteGardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Chu/indemniteGardeWs")
public class IndemniteGardeWs {
    @Autowired
    private IndemniteGardeService indemniteGardeService;
    @GetMapping("/ref/{ref}")
    public IndemniteGarde findByRef(@PathVariable String ref){
        return indemniteGardeService.findByRef(ref);
    }
    @GetMapping("/refe/{ref}")
    public double findByrlqt(@PathVariable String ref) {
        return indemniteGardeService.findByrlqt(ref);
    }
    @GetMapping("/annee/{n}")
    public List<IndemniteGarde> findByYear(@PathVariable int n) {
        return indemniteGardeService.findByYear(n);
    }
    @GetMapping("/")
    public List<IndemniteGarde> findAll() {
        return indemniteGardeService.findAll();
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByListeGardes_Ref(@PathVariable String ref) {
        return indemniteGardeService.deleteByListeGardes_Ref(ref);
    }

    @GetMapping("/anneetrim/{n}/{t}")

    public List<IndemniteGarde> findByYearTrim(@PathVariable int n,@PathVariable int t) {
        return indemniteGardeService.findByYearTrim(n, t);
    }

    @GetMapping("/calcul/{nom}/{prenom}/{year}/{typedegarde}")

    public List<IndemniteGarde> calculDindemnite(@PathVariable String nom,@PathVariable String prenom,@PathVariable int year,@PathVariable String typedegarde) {
        return indemniteGardeService.calculDindemnite(nom, prenom, year,typedegarde);
    }

    @GetMapping("/calculAll/{matricule}/{year}")
    public  int CalculAll(@PathVariable String matricule,@PathVariable int year) {
        return indemniteGardeService.CalculAll(matricule, year);
    }

    @GetMapping("/search/{n}/{p}")
    public List<IndemniteGarde> findBynomprenom(@PathVariable Object n,@PathVariable Object p) {
        return indemniteGardeService.findBynomprenom(n, p);
    }

    @PostMapping("/")
    public int save(@RequestBody IndemniteGarde indemniteGarde){
      return indemniteGardeService.save(indemniteGarde);

    }

    @GetMapping("/montant/{n}")
    public Float findMontantnettotal(@PathVariable int n) {
        return indemniteGardeService.findMontantnettotal(n);
    }

    @DeleteMapping("/delete/{id}")

    public void deleteById(@PathVariable Long id) {
        indemniteGardeService.deleteById(id);
    }


    @GetMapping("/Montantnet/{t}/{p}/{n}")
    public Float findMontantnet(@PathVariable Object t,@PathVariable Object p,@PathVariable int n) {
        return indemniteGardeService.findMontantnet(t, p, n);
    }
}
