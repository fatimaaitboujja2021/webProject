package myproject.demo.dao;

import myproject.demo.bean.Grade;
import myproject.demo.bean.ListeGarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface ListeGardeDao extends JpaRepository<ListeGarde,Long> {


List<ListeGarde> findBydureDeGarde(int duree);
List<ListeGarde> findBydateGarde(Date date);
int deleteByRef(String refdeListe);
//ListeGarde findByRef(String refdeListe);
//find by ref de fonc
//List<ListeGarde> findByFonctionnaire

    List<ListeGarde> findByFonctionnaire_MatriculeSub(String matricule);
    ListeGarde findByRef(String ref);
}
