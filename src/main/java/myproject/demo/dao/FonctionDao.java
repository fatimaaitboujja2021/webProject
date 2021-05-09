package myproject.demo.dao;

import myproject.demo.bean.Echelon;
import myproject.demo.bean.Fonction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FonctionDao extends JpaRepository<Fonction,Long> {
    Fonction findByintitule(String intitule);
    int deleteByintitule(String intitule);
    List<Fonction> findAll();
    Fonction findByFonctionnaire_MatriculeSub(String MatriculeSub);
Fonction findByRef(String ref);
}
