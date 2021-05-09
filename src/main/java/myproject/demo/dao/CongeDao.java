package myproject.demo.dao;

import myproject.demo.bean.Comptebancaire;
import myproject.demo.bean.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CongeDao extends JpaRepository<Conge,Long> {
   List<Conge> findBytypeConge(String type);
    List<Conge> findByDateDebutCongeAndDateFinConge(Date dateDebutConge, Date dateFinConge);
    List<Conge> findByDateDebutConge(Date dateDebutConge);
    List<Conge> findByDateFinConge(Date dateFinConge);
    int deleteByDateDebutConge(Date dateDebutConge);
    Conge findByFonctionnaireMatriculeSub(String MatriculeSub);
    Conge findByRef(String ref);
}
