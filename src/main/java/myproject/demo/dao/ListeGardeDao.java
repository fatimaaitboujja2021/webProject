package myproject.demo.dao;

import myproject.demo.bean.Grade;
import myproject.demo.bean.ListeGarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface ListeGardeDao extends JpaRepository<ListeGarde,Long> {

List<ListeGarde> findBydureDeGarde(int duree);
List<ListeGarde> findBydateGarde(Date date);
//ListeGarde findByRef(String refdeListe);
//find by ref de fonc
//List<ListeGarde> findByFonctionnaire
int deleteByRef(String ref);
List<ListeGarde> findByFonctionnaire_MatriculeSuperieur(String matricule);
    List<ListeGarde> findByFonctionnaire_MatriculeSub(String matricule);
    ListeGarde findByRef(String ref);
@Query("SELECT c FROM ListeGarde c WHERE c.fonctionnaire.matriculeSuperieur LIKE %:n% and c.dateGarde >= :d and c.dateGarde <=  :a")
    List<ListeGarde> findBydateminetmax(@Param("n") String n,@Param("d")Date d,@Param("a") Date a);
//    @Query("SELECT c FROM ListeGarde c WHERE c.statue LIKE %:n% and  c.dateGarde == ")
//    List<ListeGarde> findByabsent(@Param("n") String n,@Param("d")String d,@Param("a") Date a);

//    @Query("SELECT count(c) FROM ListeGarde c WHERE c.fonctionnaire.matriculeSuperieur LIKE %:n% and c.dateGarde >= :d and c.dateGarde <=  :a")
//    List<ListeGarde> countabsence(@Param("n") String n,@Param("m") String m,@Param("d")Date d,@Param("a") Date a);
@Query("SELECT count(c) FROM ListeGarde c WHERE c.jourounuit LIKE %:n%")
int nombredefonc(@Param("n") String n);

    @Query("SELECT count(c) FROM ListeGarde c WHERE c.garde.typeGarde LIKE %:n%")
    int nombredefoncgarde(@Param("n") String n);

    @Query("SELECT count(c) FROM ListeGarde c WHERE c.statue LIKE %:n%")
    int nombredefoncstatue(@Param("n") String n);

}
