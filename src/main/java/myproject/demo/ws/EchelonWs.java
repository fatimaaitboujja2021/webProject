package myproject.demo.ws;

import myproject.demo.bean.Echelon;
import myproject.demo.service.EchelonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/echelonws")
public class EchelonWs {
    @Autowired
    private EchelonService echelonService;
    @PostMapping("/")
    public  int save(@RequestBody Echelon echelon){

        return echelonService.save(echelon);
    }

    @GetMapping("/ref/{ref}")

    public Echelon findByRef(@PathVariable String ref){
        return echelonService.findByRef(ref);
    }
    @GetMapping("/dt_echelon/{dtechelon}")
    public Echelon findBydTEchelon(@PathVariable String dtechelon){
        return echelonService.findBydTEchelon(dtechelon);
    }
    @DeleteMapping("/dtechelon/{dtechelon}")
    public int deleteBydTEchelon(@PathVariable String dtechelon){
        return  echelonService.deleteBydTEchelon(dtechelon);
    }
    @GetMapping("/echelonnom/{echelonnom}")
    public Echelon findByechelonnom(@PathVariable String echelonnom){
        return echelonService.findByechelonnom(echelonnom);
    }
    @GetMapping("/MatriculeSub/{MatriculeSub}")
    public Echelon findByFonctionnaire_MatriculeSub(String MatriculeSub){
        return echelonService.findByFonctionnaire_MatriculeSub(MatriculeSub);
    }
    @DeleteMapping("/echelonnom/{echelonnom}")

    public int deleteByechelonnom(@PathVariable String echelonnom){
        return echelonService.deleteByechelonnom(echelonnom);
    }
    @GetMapping("/")

    public List<Echelon> findAll() {
        return echelonService.findAll();
    }
}
