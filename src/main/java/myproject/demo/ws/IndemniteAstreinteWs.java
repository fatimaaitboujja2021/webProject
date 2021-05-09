package myproject.demo.ws;


import myproject.demo.bean.IndemniteAstreinte;
import myproject.demo.service.IndemniteAstreinteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/indemniteAstreinteWs")
public class IndemniteAstreinteWs {

    @Autowired
    private IndemniteAstreinteService indemniteAstreinteService;
    @GetMapping("/ref/{ref}")
    public IndemniteAstreinte findByRef(@PathVariable String ref){
        return  indemniteAstreinteService.findByRef(ref);
    }
    @GetMapping("/fref/{fref}")
    public List<IndemniteAstreinte> findByFonctionnaire_Ref(@PathVariable String fref){
        return indemniteAstreinteService.findByFonctionnaire_Ref(fref);
    }
    @PostMapping("/")
    public int save(@RequestBody IndemniteAstreinte indemniteAstreinte){
        return  indemniteAstreinteService.save(indemniteAstreinte);
    }
}
