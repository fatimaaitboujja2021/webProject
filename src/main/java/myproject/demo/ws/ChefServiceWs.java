package myproject.demo.ws;


import myproject.demo.bean.ChefService;
import myproject.demo.service.ChefServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CHU/chefServiceWs")
public class ChefServiceWs {
    @Autowired
    private ChefServiceService chefServiceService;


    @PostMapping("/")
    public int save(@RequestBody ChefService chefService){
       return chefServiceService.save(chefService);
    }


    @GetMapping("/ref/{ref}")

    public ChefService findByRef(@PathVariable String ref){
        return chefServiceService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public  int deleteByRef(@PathVariable String ref){
        return chefServiceService.deleteByRef(ref);
    }
}
