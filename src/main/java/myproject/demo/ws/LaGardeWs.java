package myproject.demo.ws;

import myproject.demo.bean.LaGarde;
import myproject.demo.bean.ListeGarde;
import myproject.demo.service.LaGardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/laGardeWs")
public class LaGardeWs {

    @Autowired
    private LaGardeService laGardeService;

    @GetMapping("/ref/{ref}")
    public LaGarde findByRef(@PathVariable String ref){
        return laGardeService.findByRef(ref);

    }


    @GetMapping("/type/{type}")
    public LaGarde findByTypeGarde(String type){
        return laGardeService.findByTypeGarde(type);
    }

    @DeleteMapping("/ref/{ref}")
    public   int deleteByRef(@PathVariable String ref){
        return  laGardeService.deleteByRef(ref);
    }


    @PostMapping("/")
    public int save(@RequestBody LaGarde laGarde){
        return laGardeService.save(laGarde);
    }



}
