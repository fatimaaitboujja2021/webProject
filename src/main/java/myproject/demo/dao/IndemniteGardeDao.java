package myproject.demo.dao;

import myproject.demo.bean.IndemniteAstreinte;
import myproject.demo.bean.IndemniteGarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IndemniteGardeDao extends JpaRepository<IndemniteGarde,Long> {
    IndemniteGarde findByRef(String ref);
//   List<IndemniteGarde> findByFonctionnaire_Ref(String ref);
@Query("SELECT c FROM IndemniteGarde c ,ListeGarde l WHERE l.fonctionnaire.nom LIKE %:n% and  l.fonctionnaire.prenom  LIKE %:p%")
List<IndemniteGarde> findBynomprenom(@Param("n") Object n, @Param("p") Object p);
//List<IndemniteGarde> findByTrim(int trim);

    @Query("SELECT c FROM IndemniteGarde c ,ListeGarde l WHERE   c.Trim=:t  and l.fonctionnaire.nom LIKE %:n% and  l.fonctionnaire.prenom  LIKE %:p%")
    List<IndemniteGarde> findBytrim(@Param("t") int t,@Param("n") Object n, @Param("p") Object p);
    @Query("SELECT c.Rlqt_reported as DOUBLE FROM IndemniteGarde c  WHERE c.ref LIKE :n")
     float findByrlqt(@Param("n") String ref);

void deleteById(Long id);

    @Query("SELECT c FROM IndemniteGarde c  order by SUBSTRING(c.ref, 10, 14) asc  ")
    List<IndemniteGarde> findAll();
    @Query("SELECT c FROM IndemniteGarde c  WHERE c.ref LIKE %:n%  order by SUBSTRING(c.ref, 10, 14) asc")
    List<IndemniteGarde> findByYear(@Param("n") int n);

    @Query("SELECT sum(c.Mnt_Net)  FROM IndemniteGarde c  WHERE SUBSTRING(c.ref, 10, 14) LIKE %:n% ")
    Float findMontantnettotal(@Param("n") int n);

    @Query("SELECT c FROM IndemniteGarde c  WHERE c.ref LIKE %:n%  and c.Trim=:t ORDER BY c.Trim asc ")
    List<IndemniteGarde> findByYearTrim(@Param("n") int n,@Param("t") int t);


int deleteByListeGardes_Ref(String ref);


    @Query("SELECT sum(c.Mnt_Net)  FROM IndemniteGarde c  WHERE c.fonctionnaire.nom LIKE :t and  c.fonctionnaire.prenom LIKE :p and SUBSTRING(c.ref, 10, 14) Like %:n%")
    Float findMontantnet(@Param("t") Object t,@Param("p") Object p,@Param("n") int n);







}
