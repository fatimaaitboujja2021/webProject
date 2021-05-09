package myproject.demo.dao;

import myproject.demo.bean.Echelon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface EchelonDao  extends JpaRepository<Echelon,Long> {
    Echelon findBydTEchelon(String dtechelon);
    int deleteBydTEchelon(String dtechelon);
    Echelon findByechelonnom(String echelonnom);
    int deleteByechelonnom(String echelonnom);
    Echelon findByFonctionnaire_MatriculeSub(String MatriculeSub);
    Echelon findByRef(String ref);
}
