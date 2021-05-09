package myproject.demo.ws;

import myproject.demo.bean.Services;
import myproject.demo.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CHU/servicesWs")
public class ServicesWs {
    @Autowired
    private ServicesService servicesService;
    @GetMapping("/matricule/{matricule}")

    public Services findByFonctionnaire_MatriculeSub(@PathVariable String matricule) {

        return servicesService.findByFonctionnaire_MatriculeSub(matricule);
    }
    @PostMapping("/")

    public int save(@RequestBody Services services) {
        return servicesService.save(services);
}
    @GetMapping("/ref/{ref}")
    public     Services findByRef(@PathVariable String ref){
        return servicesService.findByRef(ref);
    }




}
