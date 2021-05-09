package myproject.demo.dao;

import myproject.demo.bean.Etablissemment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissemmentDao  extends JpaRepository<Etablissemment,Long> {

    Etablissemment findByintitule(String intitule);
//Etablissemment findByid(Long id);
//  int deleteByid(Long id);
    int deleteByintitule(String intitule);
Etablissemment findByPole_Intitule(String  intitule);


}
