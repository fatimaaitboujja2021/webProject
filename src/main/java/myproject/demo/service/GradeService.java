package myproject.demo.service;

import myproject.demo.bean.Grade;
import myproject.demo.dao.GradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
   private GradeDao gradeDao;

    public int save(Grade grade){
        if(findBygradenom(grade.getGradenom())!=null)
            return -1;
            else
                gradeDao.save(grade);
            return 1;

        }
   public Grade findByRef(String ref){
        return gradeDao.findByRef(ref);
}
    public Grade  findByFonctionnaire_MatriculeSub(String MatriculeSub){
        return gradeDao.findByFonctionnaire_MatriculeSub(MatriculeSub);
}

    public Grade findBydTGrade(String dtgrade){
        return gradeDao.findBydTGrade(dtgrade);
    }
   public Grade findBygradenom(String  gradenom){
    return  gradeDao.findBygradenom(gradenom);
   }
    public  int deleteBydTGrade(String dTGrade){
        return gradeDao.deleteBydTGrade(dTGrade);
    }
    public  int deleteBygradenom(String gradenom){
        return  gradeDao.deleteBygradenom(gradenom);
    }

    public List<Grade> findAll() {
        return gradeDao.findAll();
    }
}
