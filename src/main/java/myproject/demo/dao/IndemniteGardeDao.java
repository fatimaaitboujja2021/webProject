package myproject.demo.dao;

import myproject.demo.bean.IndemniteAstreinte;
import myproject.demo.bean.IndemniteGarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IndemniteGardeDao extends JpaRepository<IndemniteGarde,Long> {
    IndemniteGarde findByRef(String ref);
   List<IndemniteGarde> findByFonctionnaire_Ref(String ref);


}
