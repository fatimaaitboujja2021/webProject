package myproject.demo.ws;

import myproject.demo.bean.Grade;
import myproject.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CHU/gradews")
public class GradeWs {
    @Autowired
    private GradeService gradeService;
    @PostMapping("/")

    public int save(@RequestBody Grade grade){
      return gradeService.save(grade);

    }
    @GetMapping("/ref/{ref}")

    public Grade findByRef(@PathVariable String ref){
        return gradeService.findByRef(ref);
    }
    @GetMapping("/MatriculeSub/{MatriculeSub}")

    public Grade  findByFonctionnaire_MatriculeSub(@PathVariable String MatriculeSub){
        return gradeService.findByFonctionnaire_MatriculeSub(MatriculeSub);
    }
    @GetMapping("/")

    public List<Grade> findAll() {
        return gradeService.findAll();
    }
    @GetMapping("/dtgrade/{dtgrade}")

    public Grade findBydTGrade(@PathVariable String dtgrade){
        return gradeService.findBydTGrade(dtgrade);
    }
    @GetMapping("/gradenom/{gradenom}")

    public Grade findBygradenom(@PathVariable String  gradenom){
        return  gradeService.findBygradenom(gradenom);
    }
    @DeleteMapping("/dTGrade/{dTGrade}")

    public  int deleteBydTGrade(@PathVariable String dTGrade){
        return gradeService.deleteBydTGrade(dTGrade);
    }
    @DeleteMapping("/gradenom/{gradenom}")

    public  int deleteBygradenom( @PathVariable String gradenom){
        return  gradeService.deleteBygradenom(gradenom);
    }
}
