package myproject.demo.dao;

import myproject.demo.bean.Servhopital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ServhopitalDao extends JpaRepository<Servhopital,Long> {


    Servhopital findByintitule(String intitule);
    int deleteByintitule(String intitule);
    List<Servhopital> findAll();
Servhopital findByFonctionnaire_MatriculeSuperieur(String matricule);
Servhopital findByRef(String ref);
}
