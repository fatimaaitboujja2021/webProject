package myproject.demo.dao;

import myproject.demo.bean.Grade;
import myproject.demo.bean.IndemniteAstreinte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IndemniteAstreinteDao extends JpaRepository<IndemniteAstreinte,Long> {
     IndemniteAstreinte findByRef(String ref);
    List<IndemniteAstreinte> findByFonctionnaire_Ref(String ref);
}
