package myproject.demo.ws;

import myproject.demo.bean.IndemniteGarde;
import myproject.demo.service.IndemniteGardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/indemniteGardeWs")
public class IndemniteGardeWs {
    @Autowired
    private IndemniteGardeService indemniteGardeService;
    @GetMapping("/ref/{ref}")
    public IndemniteGarde findByRef(@PathVariable String ref){
        return indemniteGardeService.findByRef(ref);
    }
    @GetMapping("/fref/{fref}")

    public List<IndemniteGarde> findByFonctionnaire_Ref(@PathVariable String fref){
        return indemniteGardeService.findByFonctionnaire_Ref(fref);
    }
    @PostMapping("/")
    public int save(@RequestBody IndemniteGarde indemniteGarde){
      return indemniteGardeService.save(indemniteGarde);

    }

}
