package myproject.demo.dao;

import myproject.demo.bean.Specialite;
import myproject.demo.bean.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SpecialiteDao extends JpaRepository<Specialite,Long> {


    Specialite findByintitule(String intitule);
    int deleteByintitule(String intitule);
    List<Specialite> findAll();
Specialite findByFonctionnaire_MatriculeSub(String matricule);
Specialite findByRef(String ref);
}
