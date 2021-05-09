package myproject.demo.dao;

import myproject.demo.bean.Etablissemment;
import myproject.demo.bean.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GradeDao extends JpaRepository<Grade,Long> {
    Grade findBydTGrade(String dtgrade);
    Grade findBygradenom(String  gradenom);
    int deleteBydTGrade(String dTGrade);
int deleteBygradenom(String gradenom);
Grade  findByFonctionnaire_MatriculeSub(String MatriculeSub);
Grade findByRef(String ref);
}
