package myproject.demo.dao;

import myproject.demo.bean.Comptebancaire;
import myproject.demo.bean.Conge;
import myproject.demo.bean.Fonctionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
 @Query("SELECT count(c) FROM Conge c WHERE c.typeConge IS NOT NULL and c.fonctionnaire.matriculeSuperieur Like %:m%")
 int nombredefonc(@Param("m") String m);
 @Query("SELECT c FROM Conge  c WHERE  c.fonctionnaire.id IS NOT NULL  ")
 List<Conge> fonctionnaireconge();
}
