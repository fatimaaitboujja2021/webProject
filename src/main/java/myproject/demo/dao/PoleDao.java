package myproject.demo.dao;

import myproject.demo.bean.Etablissemment;
import myproject.demo.bean.Pole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoleDao extends JpaRepository<Pole,Long> {
    Pole findByintitule(String intitule);
   // Pole findByEtablissemmentintitule(String intitule);
    int deleteByintitule(String intitule);
    //int deleteByEtablissemmentintitule(String intitule);
    Pole findByServices_Intitule(String intitule);
}
