package myproject.demo.dao;

import myproject.demo.bean.Grade;
import myproject.demo.bean.IndemniteAstreinte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IndemniteAstreinteDao extends JpaRepository<IndemniteAstreinte,Long> {
     IndemniteAstreinte findByRef(String ref);
@Query("SELECT c FROM IndemniteAstreinte c ,ListeGarde l WHERE l.fonctionnaire.nom LIKE %:n% and  l.fonctionnaire.prenom  LIKE %:p%")
List<IndemniteAstreinte> findBynomprenom(@Param("n") Object n,@Param("p") Object p);

     @Query("SELECT c FROM IndemniteAstreinte c  order by SUBSTRING(c.ref, 12, 5) asc ")
     List<IndemniteAstreinte> findAll();
     @Query("SELECT c FROM IndemniteAstreinte c  WHERE c.ref LIKE %:n% order by SUBSTRING(c.ref, 12, 5) asc ")
     List<IndemniteAstreinte> findByYear(@Param("n") int n);
     @Query("SELECT c FROM IndemniteAstreinte c  WHERE c.ref LIKE %:n%  and c.Trim=:t ORDER BY c.Trim asc")
     List<IndemniteAstreinte> findByYearTrim(@Param("n") int n,@Param("t") int t);
     @Query("SELECT sum(c.Mnt_Net)  FROM IndemniteAstreinte c  WHERE c.ref LIKE %:n% ")
     Float findMontantnettotal(@Param("n") int n);
     @Query("SELECT sum(c.Mnt_Net)  FROM IndemniteAstreinte c  WHERE c.fonctionnaire.nom LIKE :t and  c.fonctionnaire.prenom LIKE :p and SUBSTRING(c.ref, 12, 5) Like %:n%")
     double findMontantnet(@Param("t") String t,@Param("p") String p,@Param("n") int n);
     @Query("SELECT SUBSTRING(c.ref, 12, 5)  FROM IndemniteAstreinte c  WHERE c.fonctionnaire.nom LIKE :t and  c.fonctionnaire.prenom LIKE :p and SUBSTRING(c.ref, 12, 5) Like %:n% GROUP BY c.ref")
     String[] findBySub(@Param("t") String t,@Param("p") String p,@Param("n") int n);

}


