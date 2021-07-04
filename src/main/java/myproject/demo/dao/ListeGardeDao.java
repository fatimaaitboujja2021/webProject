package myproject.demo.dao;

import myproject.demo.bean.Grade;
import myproject.demo.bean.ListeGarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository

public interface ListeGardeDao extends JpaRepository<ListeGarde, Long> {

    List<ListeGarde> findBydureDeGarde(int duree);
    List<ListeGarde> findBydateGarde(Date date);
    int deleteByRef(String ref);
    @Query("SELECT c FROM ListeGarde c WHERE c.garde.typeGarde LIKE  'astreinte' and c.fonctionnaire.matriculeSuperieur LIKE  :matricule order by c.dateGarde desc")
    List<ListeGarde> findByFonctionnaire_MatriculeSuperieurA(@Param("matricule") String matricule);
    @Query("SELECT c FROM ListeGarde c WHERE c.garde.typeGarde LIKE  'garde' and c.fonctionnaire.matriculeSuperieur LIKE  :matricule order by c.dateGarde desc")
    List<ListeGarde> findByFonctionnaire_MatriculeSuperieurG(@Param("matricule") String matricule);
    List<ListeGarde> findByFonctionnaire_MatriculeSub(String matricule);
    List<ListeGarde> findByFonctionnaire_NomAndFonctionnaire_PrenomAndTrimestre(String nom, String prenom, int trim);
    List<ListeGarde> findByFonctionnaire_NomAndFonctionnaire_Prenom(String nom, String prenom);
    ListeGarde findByRef(String ref);
    @Query("SELECT c FROM ListeGarde c WHERE c.fonctionnaire.matriculeSuperieur LIKE %:n% and c.dateGarde >= :d and c.dateGarde <=  :a and c.garde.typeGarde LIKE %:t% order by c.dateGarde desc ")
    List<ListeGarde> findBydateminetmax(@Param("n") String n, @Param("d") LocalDate d, @Param("a") LocalDate a, @Param("t") String t);
    @Query("SELECT count(c) FROM ListeGarde c WHERE c.jourounuit LIKE %:n% and c.fonctionnaire.matriculeSuperieur LIKE  :matricule and c.dateGarde between DATEADD(DAY,-7,GETDATE()) and  GETDATE() ")
    int nombredefonc(@Param("n") String n,@Param("matricule") String matricule);

    @Query("SELECT count(c) FROM ListeGarde c WHERE c.garde.typeGarde LIKE  %:n% and c.fonctionnaire.matriculeSuperieur LIKE  :matricule and c.dateGarde between DATEADD(DAY,-7,GETDATE()) and  GETDATE()")
    int nombredefoncgarde(@Param("n") String n,@Param("matricule") String matricule);

    @Query("SELECT count(c) FROM ListeGarde c WHERE c.statue LIKE %:n% and c.fonctionnaire.matriculeSuperieur LIKE  :matricule and c.dateGarde  between DATEADD(DAY,-7,GETDATE()) and  GETDATE()")
    int nombredefoncstatue(@Param("n") String n,@Param("matricule") String matricule);
    List<ListeGarde> findByIndemniteAstreinte_Ref(String ref);
    List<ListeGarde> findByIndemniteGarde_Ref(String ref);


}
